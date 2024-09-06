//
//  SignUpViewController.swift
//  ios101-project7-task
//
//  Created by Diwakar Kumawat on 9/4/24.
//

import Foundation
import UIKit

class SignUpViewController: UIViewController {
    
    // Outlets for your text fields and buttons
    
    @IBOutlet weak var usernameTextField: UITextField!
    @IBOutlet weak var passwordTextField: UITextField!
    @IBOutlet weak var signUpButton: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Any additional setup you want to perform when the view loads
        signUpButton.layer.cornerRadius = 15  // Adjust this value for more or less rounding
        signUpButton.layer.masksToBounds = true
        passwordTextField.isSecureTextEntry = true
    }
    
    
    // Action for when the Sign Up button is tapped
    @IBAction func signUpTapped(_ sender: UIButton) {
        _ = usernameTextField.text
        _ = passwordTextField.text
        
        // Handle sign-up logic here, such as form validation or network requests
    }
}

