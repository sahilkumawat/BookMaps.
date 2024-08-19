//
//  FactsViewController.swift
//  ios101-project7-task
//
//  Created by Diwakar Kumawat on 8/15/24.
//

import UIKit
import NukeExtensions

class FactsViewController: UIViewController {

    @IBOutlet weak var bookImage: UIImageView!
    @IBOutlet weak var bookTitle: UILabel!
    @IBOutlet weak var bookRating: UILabel!
    @IBOutlet weak var bookRelease: UILabel!
    @IBOutlet weak var bookOverview: UILabel!
    @IBOutlet weak var bookAdd: UIButton!
    @IBOutlet weak var bookAuthor: UILabel!
    
    // Property to hold the book information passed from the previous view controller
    var searchResults: BookSearchResults?

    override func viewDidLoad() {
        super.viewDidLoad()

        // If we have the book information, use it to update the UI
        if let results = searchResults {
            updateUIWithBookInfo(results)
        }
    }

    func updateUIWithBookInfo(_ searchResults: BookSearchResults) {
        // Assuming the first item in the search results is the book we want to display
        guard let book = searchResults.items?.first else {
            print("No book information found.")
            return
        }
        // Update UI elements with the book information
        DispatchQueue.main.async { [weak self] in
            self?.bookTitle.text = book.volumeInfo.title
            self?.bookRelease.text = book.volumeInfo.publishedDate ?? "Not available"
            
            let authorsList = book.volumeInfo.authors?.joined(separator: ", ") ?? "Author information not available"
            self?.bookAuthor.text = authorsList
                
            if let averageRating = book.volumeInfo.averageRating {
                self?.bookRating.text = "Rating: \(averageRating)"
            } else {
                self?.bookRating.text = "Rating: Not available"
            }
            self?.bookOverview.text = book.volumeInfo.description ?? "No description available."
            
            if var imageUrlString = book.volumeInfo.imageLinks?.thumbnail {
                imageUrlString = imageUrlString.replacingOccurrences(of: "http://", with: "https://")
                if let imageUrl = URL(string: imageUrlString), let imageView = self?.bookImage {
                    NukeExtensions.loadImage(with: imageUrl, into: imageView)
                }
            } else {
                self?.bookImage.image = UIImage(named: "defaultCover")
            }

            self?.bookImage.layer.cornerRadius = 10
            self?.bookImage.clipsToBounds = true
            self?.bookImage.layer.borderWidth = 2
            self?.bookImage.layer.borderColor = UIColor.white.cgColor
                
            self?.bookImage.layer.shadowColor = UIColor.black.cgColor
            self?.bookImage.layer.shadowOpacity = 0.5
            self?.bookImage.layer.shadowOffset = CGSize(width: 0, height: 4)
            self?.bookImage.layer.shadowRadius = 5
            self?.bookImage.layer.masksToBounds = false
        }
    }

}
