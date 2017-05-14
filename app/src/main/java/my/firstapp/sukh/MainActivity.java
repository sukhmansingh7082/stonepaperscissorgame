package my.firstapp.sukh;






import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import my.firstapp.sukh.R;

public class MainActivity extends Activity {
	
ImageView stonee,sci,popo,sci1,popo1,stonee1;
Button click;
TextView rv,playy1,playy2;
public int i=0,j=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		stonee=(ImageView)findViewById(R.id.stonee);
		sci=(ImageView)findViewById(R.id.sci);
		popo=(ImageView)findViewById(R.id.popo);
		stonee1=(ImageView)findViewById(R.id.stonee1);
		popo1=(ImageView)findViewById(R.id.popo1);
		sci1=(ImageView)findViewById(R.id.sci1);
		click=(Button)findViewById(R.id.click);
		playy1=(TextView)findViewById(R.id.player1);
		playy2=(TextView)findViewById(R.id.player2);
	
		stonee.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				i=3;
				popo.setClickable(false);
				sci.setClickable(false);
				playy1.setText("Player 1 clicked");
			}
		});
		popo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			i=2;
			sci.setClickable(false);
			stonee.setClickable(false);
				playy1.setText("Player 1 clicked");
			}
		});
		sci.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			i=1;
			popo.setClickable(false);
			stonee.setClickable(false);
				playy1.setText("Player 1 clicked");

			}
		});
		sci1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			j=1;	// TODO Auto-generated method stub
				popo1.setClickable(false);
				stonee1.setClickable(false);
				playy2.setText("Player 2 clicked");
			}
		});
		stonee1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			j=3;
			sci1.setClickable(false);
			popo1.setClickable(false);
				playy2.setText("Player 2 clicked");
			}
		});
		popo1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			j=2;
			sci1.setClickable(false);
			stonee1.setClickable(false);
				playy2.setText("Player 2 clicked");
			}
		});
		click.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(i==1&&j==0||i==2&&j==0||i==3&&j==0){
					//draw
					final AlertDialog alert= new AlertDialog.Builder(MainActivity.this).create();
					alert.setTitle("You cannot play alone");
					alert.setMessage("Play it again. For HELP, click menu");
					alert.setButton("OK", new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog, int which) {

							alert.cancel();
						}
					});
					alert.show();i=0;
					j=0;
					playy1.setText(null);playy2.setText(null);

				}
				else if (i==0&&j==1||i==0&&j==2||i==0&&j==3){
					final AlertDialog alert= new AlertDialog.Builder(MainActivity.this).create();
					alert.setTitle("You cannot play alone");
					alert.setMessage("Play it again. For HELP, click menu");
					alert.setButton("OK", new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog, int which) {

							alert.cancel();
						}
					});
					alert.show();i=0;
					j=0;
					playy2.setText(null);playy1.setText(null);

				}
				else{
					if(i==1&&j==2){
						//p1 wins
						Intent inf=new Intent(MainActivity.this,player1.class);
						startActivity(inf);
						//rv.setText("p1");
					}
					else if(i==1&&j==3){
						//p2 wins

						Intent inf=new Intent(MainActivity.this,player2.class);
						startActivity(inf);
					}
					else if(i==2&&j==1){
						//p2 wins

						Intent inf=new Intent(MainActivity.this,player2.class);
						startActivity(inf);
					}
					else if(i==2&&j==2){
						//draw

						Intent inf=new Intent(MainActivity.this,draww.class);
						startActivity(inf);
					}
					else if(i==2&&j==3){
						//p1 wins
						Intent inf=new Intent(MainActivity.this,player1.class);
						startActivity(inf);
						//rv.setText("p1");
					}
					else if(i==3&&j==1){
						//p1 wins
						Intent inf=new Intent(MainActivity.this,player1.class);
						startActivity(inf);
						//rv.setText("p1");
					}
					else if(i==3&&j==2){
						//p2 wins

						Intent inf=new Intent(MainActivity.this,player2.class);
						startActivity(inf);
					}
					else{
						//draw

						Intent inf=new Intent(MainActivity.this,draww.class);
						startActivity(inf);
					}
				}

				i=0;
				j=0;
				popo.setClickable(true);
				sci.setClickable(true);
				stonee.setClickable(true);
				popo1.setClickable(true);
				sci1.setClickable(true);
				stonee1.setClickable(true);
			}
		});
			
	}

	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
	
		MenuInflater blowUp= getMenuInflater();
		blowUp.inflate(R.menu.cool, menu);
		return true;
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch (item.getItemId()) {
		case R.id.rulee:
			Intent i=new Intent("com.example.stonepaperscissor.RULES");
			startActivity(i);
			break;
		case R.id.developerR:
			Intent p= new Intent("com.example.stonepaperscissor.DEVELOPER");
			startActivity(p);
			break;
	}
return false;
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onBackPressed()
	 */
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		AlertDialog.Builder alert=new AlertDialog.Builder(this);
		alert.setMessage(R.string.decesion);
		alert.setPositiveButton(R.string.positive, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
			}
		});
		alert.setNegativeButton(R.string.negative, null);
		alert.show();
		
		
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onBackPressed()
	 */
	
}