package my.firstapp.sukh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import my.firstapp.sukh.R;

public class draww extends Activity {
	private final int interval = 2000; // 1 Second
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.draww);
	 Handler handler = new Handler();
	 Runnable runnable = new Runnable(){
		    public void run() {
		        Intent samreet= new Intent(draww.this,MainActivity.class);
		        startActivity(samreet);
		    }
		};
		
		handler.postAtTime(runnable, System.currentTimeMillis()+interval);
		handler.postDelayed(runnable, interval);
	}

	
}
