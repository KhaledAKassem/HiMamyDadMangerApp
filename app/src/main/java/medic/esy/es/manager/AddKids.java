package medic.esy.es.manager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import medic.esy.es.manager.model.parent;

public class AddKids extends AppCompatActivity {



    EditText address,age,email,password,phone;
    Button addKids;
    EditText name,gender;
    Spinner spinner;
    String genderr[]={"Male","Female"};
    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_kids);

        name=(EditText)findViewById(R.id.kidName);
        address=(EditText) findViewById(R.id.KidAddress);
        age=(EditText) findViewById(R.id.KidAge);
        email=(EditText) findViewById(R.id.KidEmail);
        password=(EditText) findViewById(R.id.KidPassword);
        phone=(EditText) findViewById(R.id.KidCode);
        addKids=(Button)findViewById(R.id.addKids);
        spinner=(Spinner)findViewById(R.id.spinner);
        value="Male";
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                  value=genderr[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        ArrayAdapter<String> spin_adapter = new ArrayAdapter<String>(AddKids.this, android.R.layout.simple_list_item_1, genderr);

        // setting adapteers to spinners
        spinner.setAdapter(spin_adapter);



        addKids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (name.length() == 0) {
                    name.setError("name is Required");
                    name.requestFocus();
                    return;

                } else if (address.length() == 0) {
                    address.setError("Address is Required");
                    address.requestFocus();
                    return;
                } else if (age.length() == 0) {
                    age.setError("Age is Required");
                    age.requestFocus();
                    return;
                } else if (email.length() == 0) {
                    email.setError("Email is Required");
                    email.requestFocus();
                    return;
                } else if (password.length() == 0) {
                    password.setError("Password is Required");
                    password.requestFocus();
                    return;
                } else if (phone.length() == 0) {
                    phone.setError("Code is Required");
                    phone.requestFocus();
                    return;
                }

                String kidName=name.getText().toString().trim();
                String KidAddress=address.getText().toString().trim();
                String KidAge=age.getText().toString().trim();
                String KidEmail=email.getText().toString().trim();
                String KidPassword=password.getText().toString().trim();
                String KidPhone=phone.getText().toString().trim();
                parent parent=new parent(
                        kidName,value,KidAddress,KidAge,KidEmail,KidPassword,KidPhone
                );

                FirebaseDatabase.getInstance().getReference().child("childern").child(KidPhone).setValue(parent).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(AddKids.this, "Student added Successfully", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });


    }
}
