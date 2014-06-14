package info.adamjsmith.androidgames;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class BitmapTest extends Activity {
	class RenderView extends View {
		Bitmap bird565;
		Bitmap bird4444;
		Rect dst = new Rect();
		
		public RenderView(Context context) {
			super(context);
			
			try {
				AssetManager assetManager = context.getAssets();
				InputStream inputStream = assetManager.open("bird.gif");
				bird565 = BitmapFactory.decodeStream(inputStream);
				inputStream.close();
				Log.d("BitmapText", "bird.png format: " + bird565.getConfig());
				inputStream = assetManager.open("bird.gif");
				BitmapFactory.Options options =  new BitmapFactory.Options();
				options.inPreferredConfig = Bitmap.Config.ARGB_4444;
				bird4444 = BitmapFactory.decodeStream(inputStream, null, options);
				inputStream.close();
				Log.d("BitmapText", "bird.png format: " + bird4444.getConfig());
			} catch (IOException e) {
				
			} finally {
				
			}
		}
		
		protected void onDraw(Canvas canvas) {
			canvas.drawRGB(0, 0, 0);
			dst.set(50, 50, 350, 350);
			canvas.drawBitmap(bird565, null, dst, null);
			canvas.drawBitmap(bird4444, 100, 100, null);
			invalidate();
		}
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(new RenderView(this));
	}
}
