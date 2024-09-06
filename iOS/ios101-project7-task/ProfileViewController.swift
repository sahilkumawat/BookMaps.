//
//  ProfileViewController.swift
//  ios101-project7-task
//
//  Created by Diwakar Kumawat on 8/15/24.
//

import UIKit

class ProfileViewController: UIViewController {
    var enteredName: String?
    var enteredUsername: String?

    @IBOutlet weak var profileImageView: UIImageView!
    @IBOutlet weak var nameLabel: UILabel!
    @IBOutlet weak var usernameLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        profileImageView.layer.cornerRadius = profileImageView.frame.size.width / 2
        profileImageView.layer.masksToBounds = true
        // set name, username
        nameLabel.text = enteredName
        usernameLabel.text = enteredUsername
        
    }
    
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
