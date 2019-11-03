//
//  SessionsViewController.swift
//  iosApp
//
//  Created by vjgarcia on 03/11/2019.
//

import Foundation
import UIKit
import app

class SessionsViewController: UIViewController {

	private let sessionsPresenter = ServiceLocator.init().sessionsPresenter

	@IBOutlet weak var sessions: UITableView!

	private var sessionsModel: SessionsModel? = nil
	
	override func viewDidLoad() {
        super.viewDidLoad()
		setUpSessionsTableView()
		sessionsPresenter.onAttach(sessionsView: self)
    }

	override func viewWillDisappear(_ animated: Bool) {
		sessionsPresenter.onDetach()
		super.viewWillDisappear(animated)
	}
}

// MARK: UITableViewDelegate

extension SessionsViewController: UITableViewDelegate {
	func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
		return SessionViewCell.rowHeight
	}
}

// MARK: UITableViewDataSource

extension SessionsViewController: UITableViewDataSource {

	func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
		guard let sessionsModel = sessionsModel else { return 0 }
		return sessionsModel.sessions.count
	}

	func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
		guard let sessionsModel = sessionsModel else {
			return UITableViewCell()
		}

		let sessionCell = SessionViewCell.dequeueReusableCell(for: indexPath, from: sessions)

		let session = sessionsModel.sessions[indexPath.row]
		sessionCell.bind(session)

		return sessionCell
	}
}

// MARK: SessionView

extension SessionsViewController: SessionsView {
	func showSessions(sessionsModel: SessionsModel) {
		self.sessionsModel = sessionsModel
		sessions.reloadData()
	}
}

// MARK: Private section
private extension SessionsViewController {
	func setUpSessionsTableView() {
		sessions.delegate = self
		sessions.dataSource = self
		registerCells()
	}

	private func registerCells() {
		SessionViewCell.registerNib(on: sessions)
	}
}
