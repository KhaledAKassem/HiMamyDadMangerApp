package medic.esy.es.manager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {



    private Button staff,kids;
    private ImageView imagerotate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        staff=(Button)findViewById(R.id.staff);
        kids=(Button)findViewById(R.id.kids);
        imagerotate=(ImageView)findViewById(R.id.rotate);

        RotateAnimation rotate = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(5000);
        rotate.setInterpolator(new LinearInterpolator());
        imagerotate.startAnimation(rotate);
        staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(MainActivity.this,AddStaff.class));
            }
        });

///////////////////////////////////////////////////////////////////////////
        kids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AddKids.class));
            }
        });
//////////////////////////////////////////////////////////////////////////
    }
}
