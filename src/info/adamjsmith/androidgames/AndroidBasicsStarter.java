package info.adamjsmith.androidgames;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AndroidBasicsStarter extends ListActivity {
	String tests[] = {"LifecycleTest", "SingleTouchTest", "MultiTouchTest", "KeyTest", 
			"AccelerometerTest", "AssetsTest", "ExternalStorageTest", "SoundPoolTest", 
			"MediaPlayerTest", "FuillScreenTest", "RenderViewTest", "ShapeTest", 
			"BitmapTest", "FontTest", "SurfaceViewTest" }; 
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_1, tests));
	}
	
	@Override
	protected void onListItemClick(ListView list, View view, int position,
			long id) {
		super.onListItemClick(list,  view,  position, id);
		String testName = tests[position];
		try {
			Class clazz = Class
					.forName("info.adamjsmith.androidgames." + testName);
			Intent intent = new Intent(this, clazz);
			startActivity(intent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
