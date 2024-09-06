//
//  MainViewController.swift
//  ios101-project7-task
//
//  Created by Diwakar Kumawat on 9/2/24.
//

import Foundation
import UIKit

class MainViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var signInButton: UIButton!
    @IBOutlet weak var signUpButton: UIButton!
    @IBOutlet weak var nameTextField: UITextField!
    @IBOutlet weak var usernameTextField: UITextField!
    @IBOutlet weak var passwordTextField: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Rounding the button
        
        signInButton.layer.cornerRadius = 15  // Adjust this value for more or less rounding
        signInButton.layer.masksToBounds = true
        signUpButton.layer.cornerRadius = 15  // Adjust this value for more or less rounding
        signUpButton.layer.masksToBounds = true
        // Set the delegates for the text fields
        nameTextField.delegate = self
        usernameTextField.delegate = self
        passwordTextField.delegate = self
        // Set return key type for each field
        nameTextField.returnKeyType = .done
        usernameTextField.returnKeyType = .done
        passwordTextField.returnKeyType = .done
    }


    // Dismiss the keyboard when "Done" is pressed
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()  // Dismisses the keyboard
        return true
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "toTabBar" {
            let tabBarVC = segue.destination as! UITabBarController
            let profileVC = tabBarVC.viewControllers?.first(where: { $0 is ProfileViewController }) as! ProfileViewController
            
            // Pass the user data
            profileVC.enteredName = nameTextField.text
            profileVC.enteredUsername = usernameTextField.text
        }
    }
}
