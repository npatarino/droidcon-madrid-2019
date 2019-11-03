//
//  UITableViewCell+Utils.swift
//  iosApp
//
//  Created by vjgarcia on 03/11/2019.
//

import UIKit

extension UITableViewCell {

	class func register(on tableView: UITableView) {
		tableView.register(self, forCellReuseIdentifier: cellReuseIdentifier())
	}

	class func registerNib(on tableView: UITableView) {
		tableView.register(nib(), forCellReuseIdentifier: cellReuseIdentifier())
	}

	class func dequeueReusableCell(for indexPath: IndexPath, from tableView: UITableView) -> Self {
		return internalDequeueReusableCell(for: indexPath, from: tableView, identifier: cellReuseIdentifier())
	}

	class func dequeueReusableCell(from tableView: UITableView) -> Self {
		return internalDequeueReusableCell(from: tableView, identifier: cellReuseIdentifier())
	}

	class func dequeueReusableCell(for indexPath: IndexPath, from tableView: UITableView, with customIdentifier: String) -> Self {
		return internalDequeueReusableCell(for: indexPath, from: tableView, identifier: customIdentifier)
	}
}

private extension UITableViewCell {
	class func cellReuseIdentifier() -> String {
		return NSStringFromClass(self).components(separatedBy: ".").last!
	}

	class func internalDequeueReusableCell<T>(for indexPath: IndexPath, from tableView: UITableView, identifier: String) -> T where T: UITableViewCell {
		guard let cell = tableView.dequeueReusableCell(withIdentifier: identifier, for: indexPath) as? T else {
			fatalError("Nib cell class does not match expected cell class \(identifier).")
		}

		return cell
	}

	class func internalDequeueReusableCell<T>(from tableView: UITableView, identifier: String) -> T where T: UITableViewCell {
		guard let cell = tableView.dequeueReusableCell(withIdentifier: identifier) as? T else {
			fatalError("Nib cell class does not match expected cell class \(identifier).")
		}

		return cell
	}

}


import Foundation
