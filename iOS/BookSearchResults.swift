//
//  BookSearchResults.swift
//  ios101-project7-task
//
//  Created by Diwakar Kumawat on 8/15/24.
//

import Foundation

struct BookSearchResults: Codable {
    let items: [Volume]?
}

struct Volume: Codable {
    let id: String?
    let volumeInfo: VolumeInfo
}

struct VolumeInfo: Codable {
    let title: String?
    let authors: [String]?
    let publishedDate: String?
    let description: String?
    let imageLinks: ImageLinks?
    let averageRating: Double?
}

struct ImageLinks: Codable {
    let thumbnail: String?
}
