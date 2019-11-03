//
//  UIView+Utils.swift
//  iosApp
//
//  Created by vjgarcia on 03/11/2019.
//

import UIKit

extension UIView {

	class func nib() -> UINib {
		let fullName = NSStringFromClass(self)
		let className = fullName.components(separatedBy: ".").last!
		let bundle = Bundle(for: self)
		return UINib(nibName: className, bundle: bundle)
	}

	class func viewFromNib() -> Self {
		return internalViewFromNib()
	}

	class func internalViewFromNib<T>(owner: Any? = nil) -> T where T: UIView {
		let nibObjects = nib().instantiate(withOwner: owner, options: nil)
		guard let view = nibObjects.first as? T else {
			fatalError("Nib first element was expected to be \(T.self), found \(String(describing: nibObjects.first.self))")
		}
		return view
	}
}
