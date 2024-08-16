//
//  AddBooksViewController.swift
//  ios101-project7-task
//
//  Created by Diwakar Kumawat on 8/15/24.
//

import UIKit
import Vision

class AddBooksViewController: UIViewController, UINavigationControllerDelegate, UIImagePickerControllerDelegate {

    override func viewDidLoad() {
        super.viewDidLoad()

    }
    
    @IBAction func cameraTrigger(_ sender: Any) {
        let imagePickerController = UIImagePickerController()
                
        // Check if the camera is available before trying to use it
        if UIImagePickerController.isSourceTypeAvailable(.camera) {
            imagePickerController.sourceType = .camera
            imagePickerController.allowsEditing = true
            imagePickerController.delegate = self
            present(imagePickerController, animated: true)
        } else {
            // Handle the case where the camera is not available (e.g., on a simulator)
            let alert = UIAlertController(title: "Camera Not Available", message: "The camera is not available on this device or simulator.", preferredStyle: .alert)
            alert.addAction(UIAlertAction(title: "OK", style: .default))
            self.present(alert, animated: true)
        }
    }
    
    // This delegate method is called when the user cancels the image picker
    func imagePickerControllerDidCancel(_ picker: UIImagePickerController) {
        picker.dismiss(animated: true, completion: nil)
    }
    
    func detectText(in image: UIImage) {
            guard let cgImage = image.cgImage else { return }
            
            // Create an image request handler
            let requestHandler = VNImageRequestHandler(cgImage: cgImage, options: [:])

            // Create a text recognition request
            let request = VNRecognizeTextRequest { [weak self] request, error in
                guard let observations = request.results as? [VNRecognizedTextObservation], error == nil else {
                    print("Text recognition failed: \(error?.localizedDescription ?? "Unknown error")")
                    return
                }
                
                // Extract recognized text
                let recognizedStrings = observations.compactMap { $0.topCandidates(1).first?.string }
                
                // Process the recognized text
                DispatchQueue.main.async {
                    self?.processDetectedText(recognizedStrings)
                }
            }
            
            do {
                // Perform the text recognition request
                try requestHandler.perform([request])
            } catch {
                print("Failed to perform text recognition request: \(error)")
            }
        }
    
    func processDetectedText(_ recognizedStrings: [String]) {
        let fullTitle = recognizedStrings.joined(separator: " ")
        fetchBookInformation(withTitle: fullTitle)
    }

    func fetchBookInformation(withTitle title: String) {
        let baseUrl = "https://www.googleapis.com/books/v1/volumes"
        let query = title.addingPercentEncoding(withAllowedCharacters: .urlQueryAllowed) ?? ""

        let urlString = "\(baseUrl)?q=\(query)"
        guard let url = URL(string: urlString) else {
            print("Invalid URL")
            return
        }

        let task = URLSession.shared.dataTask(with: url) { [weak self] data, response, error in
            if let error = error {
                print("Error fetching book info: \(error)")
                return
            }

            guard let httpResponse = response as? HTTPURLResponse,
                  httpResponse.statusCode == 200 else {
                print("Error with the response, unexpected status code: \(String(describing: response))")
                return
            }

            if let data = data {
                do {
                    let searchResults = try JSONDecoder().decode(BookSearchResults.self, from: data)
                    
                    DispatchQueue.main.async {
                        self?.performSegue(withIdentifier: "showFacts", sender: searchResults)
                    }
                } catch {
                    print("JSON Decoding Error: \(error)")
                }
            }
        }

        task.resume()
    }


        // Pass the book information to the next view controller during segue
        override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
            if segue.identifier == "showFacts",
               let destinationVC = segue.destination as? FactsViewController,
               let searchResults = sender as? BookSearchResults {
                destinationVC.searchResults = searchResults
            }
        }
        
        // Delegate method called when an image is chosen
        func imagePickerController(_ picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [UIImagePickerController.InfoKey : Any]) {
            picker.dismiss(animated: true, completion: nil)
            
            guard let image = info[.editedImage] as? UIImage else {
                print("No image found")
                return
            }
            
            // Log that the image was selected and start text detection
            print("Image selected, starting text detection.")
            
            // Perform text detection on the selected image
            detectText(in: image)
        }


}
