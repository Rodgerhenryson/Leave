package com.example.mb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    EditText Fname,Sname,Email,Password;
    Button Register;
    DatabaseReference reff;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Fname=(EditText)findViewById(R.id.Fname);
        Sname=(EditText)findViewById(R.id.Sname);
        Email=(EditText)findViewById(R.id.Email);
        Password=(EditText)findViewById(R.id.Register_Password);
        Register=(Button)findViewById(R.id.Register_btn);
        member=new Member();
        reff= FirebaseDatabase.getInstance().getReference().child("Member");

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               member.setFname(Fname.getText().toString().trim());
                member.setSname(Sname.getText().toString().trim());
                member.setEmail(Email.getText().toString().trim());
                member.setPassword(Password.getText().toString().trim());
                reff.push().setValue(member);
                Toast.makeText(RegisterActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                Toast.makeText(RegisterActivity.this, "Please Log In Now", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
