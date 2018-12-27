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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import medic.esy.es.manager.model.staff;

public class AddStaff extends AppCompatActivity {

    EditText name,homePhone,workPhone,address,cellPhone,staffEmail,staffPassword;
    private FirebaseAuth auth;
    private FirebaseDatabase db;
    private Button addStaff;
    Spinner spinner;
    String genderr[]={"Male","Female"};
    String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_staff);

        name=(EditText) findViewById(R.id.staffname);
        homePhone=(EditText) findViewById(R.id.homePhone);
        address=(EditText) findViewById(R.id.staffAddress);
        staffEmail=(EditText) findViewById(R.id.staffEmail);
        staffPassword=(EditText) findViewById(R.id.staffPassword);
        addStaff=(Button)findViewById(R.id.addStaff);
        spinner=(Spinner)findViewById(R.id.spinner2);
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

        ArrayAdapter<String> spin_adapter = new ArrayAdapter<String>(AddStaff.this, android.R.layout.simple_list_item_1, genderr);

        // setting adapteers to spinners
        spinner.setAdapter(spin_adapter);
        auth=FirebaseAuth.getInstance();

        addStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.length() == 0) {
                    name.setError("name is Required");
                    name.requestFocus();
                    return;
                }
                 else if (homePhone.length() == 0) {
                    homePhone.setError("HomePhone is Required");
                    homePhone.requestFocus();
                    return;

                } else if (address.length() == 0) {
                    address.setError("Address is Required");
                    address.requestFocus();
                    return;
                } else if (staffEmail.length() == 0) {
                    staffEmail.setError("Email is Required");
                    staffEmail.requestFocus();
                    return;
                }
                else if (staffPassword.length() == 0) {
                    staffPassword.setError("Password is Required");
                    staffPassword.requestFocus();
                    return;
                }


                else {

                    signupforstaff();
                }
            }
        });








    }



    public void signupforstaff() {
        String email=staffEmail.getText().toString().trim();
        String password=staffPassword.getText().toString().trim();
        //////////////////////////////////////////////////
        final String staffname=name.getText().toString().trim();
        final String genders=spinner.getSelectedItem().toString();
        final String homePhones=homePhone.getText().toString().trim();
        final String addresss=address.getText().toString().trim();


        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
////Hint that cell phone must be upgrade

                    staff staff = new staff(
                            staffname,value,homePhones,addresss
                    );
                    FirebaseDatabase.getInstance().getReference("staff").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(staff);
                    Toast.makeText(AddStaff.this, "Staff add Successfully", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(AddStaff.this, "Faild !!", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}
