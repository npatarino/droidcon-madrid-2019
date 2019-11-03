//
//  SessionViewCell.swift
//  iosApp
//
//  Created by vjgarcia on 03/11/2019.
//

import UIKit
import app

class SessionViewCell: UITableViewCell {
	@IBOutlet weak var time: UILabel!
	@IBOutlet weak var timePeriod: UILabel!
	@IBOutlet weak var title: UILabel!
	@IBOutlet weak var additionalInformation: UILabel!
	@IBOutlet weak var category: UILabel!

    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }
}

// MARK: Public API

extension SessionViewCell {

	static let rowHeight: CGFloat = 80

	func bind(_ session: SessionModel) {
		title.text = session.title
		time.text = "10"
		timePeriod.text = "PM"
		additionalInformation.text = session.additionalInfo
		category.text = session.category
	}
}
