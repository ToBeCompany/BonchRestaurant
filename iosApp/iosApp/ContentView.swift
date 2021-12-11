import SwiftUI
import shared

struct ContentView: View {
	let greet = "qwdqwd"

	var body: some View {
		Text(greet)
        Text("Not Yet!")
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
