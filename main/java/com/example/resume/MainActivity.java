package com.example.resume;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    String edu_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner education = (Spinner) findViewById(R.id.education);
        ArrayAdapter<String> eduAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
        eduAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        education.setAdapter(eduAdapter);
        education.setOnItemSelectedListener(this);
        Button build = (Button) findViewById(R.id.buldButton);
        build.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                RadioGroup RG;
                RadioButton RB;
                EditText name = (EditText) findViewById(R.id.name);
                EditText fname = (EditText) findViewById(R.id.fname);
                EditText job = (EditText) findViewById(R.id.job);
                EditText email = (EditText) findViewById(R.id.email);
                RG = (RadioGroup)findViewById(R.id.rg);
                int num = RG.getCheckedRadioButtonId();
                RB = (RadioButton)findViewById(num);
                String lookingFor;
                if(RB.getText().equals("Part Time"))
                    lookingFor = "Part Time";
                else
                    lookingFor = "Full Time";
                displayToast(v,name,fname,job,email,lookingFor);
            }
        });
    }
    public void displayToast(View v,EditText name,EditText fname,EditText job,EditText
            email,String lookingFor)
    {
        Toast.makeText(MainActivity.this,"welcome to Resume Builder",Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this,"Name:"+name.getText().toString(),Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this,"Father's Name:"+fname.getText().toString(),Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this,"Job:"+job.getText().toString(),Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this,"Email:"+email.getText().toString(),Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this,"Highest Education:"+edu_text,Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this,"Looking for:"+lookingFor,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        edu_text = parent.getItemAtPosition(position).toString();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}