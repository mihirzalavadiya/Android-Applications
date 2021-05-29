package com.example.chatings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ReagisterActivity extends AppCompatActivity {

    TextView register;
    EditText rname, rmobileno, rpassword, rcpassword, remail;

//    FirebaseDatabase rootNode;
    DatabaseReference reference;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reagister);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Register");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        register = findViewById(R.id.register);
        rname = findViewById(R.id.rusername);
        rmobileno = findViewById(R.id.rmobileno);
        rpassword = findViewById(R.id.rpassword);
        rcpassword = findViewById(R.id.rcpassword);
        remail = findViewById(R.id.remail);

        auth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = rname.getText().toString();
                String mobileno = rmobileno.getText().toString();
                String email = remail.getText().toString();
                String password = rpassword.getText().toString();
                String cpassword = rcpassword.getText().toString();

                if(TextUtils.isEmpty(name) || TextUtils.isEmpty(mobileno) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
                {
                    Toast.makeText(ReagisterActivity.this, "All fileds are required", Toast.LENGTH_SHORT).show();
                }
                else if(password.length() < 6)
                {
                    Toast.makeText(ReagisterActivity.this, "Password must be at least 6 charcters", Toast.LENGTH_SHORT).show();
                }
//                else if(cpassword != password)
//                {
//                    Toast.makeText(ReagisterActivity.this, "Please enter valid password", Toast.LENGTH_SHORT).show();
//                }
                else
                {
                    register(name, mobileno, email, password);
                }
            }
        });

//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                rootNode = FirebaseDatabase.getInstance();
//                reference = rootNode.getReference("users");
//
//                Log.d("Mihir", String.valueOf(rootNode));
//
//                String name = rname.getText().toString();
//                String mobileno = rmobileno.getText().toString();
//                String email = remail.getText().toString();
//                String password = rpassword.getText().toString();
//
//                UserHelperClass userHelperClass = new UserHelperClass(name, mobileno, email, password);
//
//                reference.child(mobileno).setValue(userHelperClass);
//                startActivity(l);
//            }
//        });
    }

    private void register(String name, String mobileno, String email, String password)
    {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser firebaseUser = auth.getCurrentUser();
                    String userid = firebaseUser.getUid();

                    reference = FirebaseDatabase.getInstance().getReference("users").child(userid);
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("id", userid);
                    hashMap.put("name", name);
                    hashMap.put("mobileno", mobileno);
                    hashMap.put("email", email);
                    hashMap.put("password", password);
                    hashMap.put("imageURL", "default");

                    reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Intent l = new Intent(ReagisterActivity.this, MainActivity.class);
                                l.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(l);
                                finish();
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(ReagisterActivity.this, "You can't register both this email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}