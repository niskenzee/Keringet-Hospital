package com.niskenzee.keringethospitalsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {

                    {"Doctor Name : Mukaru Plangat", "Hospital Adress : Keringet", "Exp : 5yrs", "Mobile No : 0725993999", "600"},
                    {"Doctor Name : Rachael Mlunje", "Hospital Adress : Vihiga", "Exp : 15yrs", "Mobile No : 0726883150", "900"},
                    {"Doctor Name : Faith Kirui", "Hospital Adress : Mariakani", "Exp : 8yrs", "Mobile No : 0729909099", "300"},
                    {"Doctor Name : Sanjo Jose", "Hospital Adress : Bomet", "Exp : 4yrs", "Mobile No : 0710200602", "500"},
                    {"Doctor Name : mutiga Kingori", "Hospital Adress : Nanyuki", "Exp : 6yrs", "Mobile No : 0724150890", "800"}

            };
    private String[][] doctor_details2 =
            {

                    {"Doctor Name : Gibson Afandee", "Hospital Adress : Kapsabet", "Exp : 5yrs", "Mobile No : 0725546799", "600"},
                    {"Doctor Name : Pker Langat", "Hospital Adress : virunga", "Exp : 15yrs", "Mobile No : 0726667150", "900"},
                    {"Doctor Name : Faith Kegoyot", "Hospital Adress : Makutano", "Exp : 8yrs", "Mobile No : 0714789099", "300"},
                    {"Doctor Name : Sarah mzungu", "Hospital Adress : Bondeni", "Exp : 4yrs", "Mobile No : 0734521348", "500"},
                    {"Doctor Name : Nelson biwott", "Hospital Adress : Narok", "Exp : 6yrs", "Mobile No : 0720900840", "800"}

            };
    private String[][] doctor_details3 =
            {

                    {"Doctor Name : Masaren Boss", "Hospital Adress : Kabarnet", "Exp : 5yrs", "Mobile No : 0725009879", "600"},
                    {"Doctor Name : Gladys Shollei", "Hospital Adress : Vyulia", "Exp : 15yrs", "Mobile No : 0765789080", "900"},
                    {"Doctor Name : Viola Batush", "Hospital Adress : Makueni", "Exp : 8yrs", "Mobile No : 0723768901", "300"},
                    {"Doctor Name : Lenny Kinyozi", "Hospital Adress : Bondo", "Exp : 4yrs", "Mobile No : 0709567482", "500"},
                    {"Doctor Name : Edu Laboso", "Hospital Adress : Namanga", "Exp : 6yrs", "Mobile No : 0712345678", "800"}

            };
    private String[][] doctor_details4 =
            {

                    {"Doctor Name : James Wachira", "Hospital Adress : Nairobi", "Exp : 5yrs", "Mobile No : 0700987675", "600"},
                    {"Doctor Name : Faith Mabwai", "Hospital Adress : Tenweek", "Exp : 15yrs", "Mobile No : 0754678342", "900"},
                    {"Doctor Name : Cynthia Shikoli", "Hospital Adress : Machakos", "Exp : 8yrs", "Mobile No : 0733456790", "300"},
                    {"Doctor Name : Sylvia Muhambe", "Hospital Adress : Meru", "Exp : 4yrs", "Mobile No : 0714536374", "500"},
                    {"Doctor Name : Angela Nderitu", "Hospital Adress : Nakuru", "Exp : 6yrs", "Mobile No : 0725556789", "800"}

            };
    private String[][] doctor_details5 =
            {

                    {"Doctor Name : Mark Too", "Hospital Adress : Kericho", "Exp : 5yrs", "Mobile No : 0728767879", "600"},
                    {"Doctor Name : Naomi Ariani", "Hospital Adress : kitui", "Exp : 15yrs", "Mobile No : 0727869084", "900"},
                    {"Doctor Name : Diana Cook", "Hospital Adress : Malindi", "Exp : 8yrs", "Mobile No : 0729567678", "300"},
                    {"Doctor Name : Weldon Mahoka", "Hospital Adress : Beeston", "Exp : 4yrs", "Mobile No : 0711324563", "500"},
                    {"Doctor Name : Bonni Matindwet", "Hospital Adress : Mombasa", "Exp : 6yrs", "Mobile No : 0717965214", "800"}

            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv = findViewById(R.id.textViewODTitle);
        btn = findViewById(R.id.butonBMDAddToCart);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physicians") == 0)
            doctor_details = doctor_details1;
        else if (title.compareTo("Dietician") == 0)
            doctor_details = doctor_details2;
        else if (title.compareTo("Dentist") == 0)
            doctor_details = doctor_details3;
        else if (title.compareTo("Surgeon") == 0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });
        list = new ArrayList();
        for (int i = 0; i <doctor_details.length; i++) {
            item = new HashMap<String,String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5","Cons Fees:"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewBMD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}