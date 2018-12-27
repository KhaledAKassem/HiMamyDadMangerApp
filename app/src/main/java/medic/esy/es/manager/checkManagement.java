package medic.esy.es.manager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class checkManagement extends AppCompatActivity {


    private EditText username,password;
    private Button donemanage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_management);


        username=(EditText)findViewById(R.id.two);
        password=(EditText)findViewById(R.id.three);
        donemanage=(Button)findViewById(R.id.donemanage);


        donemanage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernames=username.getText().toString().trim();
                String passwords=password.getText().toString().trim();
                if(usernames.equals("manager2018")&&passwords.equals("manager2018")){
                    startActivity(new Intent(checkManagement.this,MainActivity.class));
                }
                else{
                    Toast.makeText(checkManagement.this,"Invalid userName or Password !",Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}
