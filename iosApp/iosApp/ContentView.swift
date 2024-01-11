import SwiftUI
import shared

struct ContentView: View {

	var body: some View {
        VStack{
            Image(resource: \.img)
                .resizable()
                .aspectRatio(1920/1395,contentMode : .fit)
        Text(Strings().get(id:SharedRes.strings().hello_world,args: []))
        Text(Strings().get(id:SharedRes.strings().hello_x,args: ["Hussein"]))
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
