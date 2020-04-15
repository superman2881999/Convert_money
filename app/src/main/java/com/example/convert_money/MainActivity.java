package com.example.convert_money;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity implements OnClickListener {


    private String xuatRaManHinh="0";
    private String xuatRaManHinh2="0";
    //Khai báo các View
    private TextView tvResult;
    private Button btnNumber0;
    private Button btnNumber1;
    private Button btnNumber2;
    private Button btnNumber3;
    private Button btnNumber4;
    private Button btnNumber5;
    private Button btnNumber6;
    private Button btnNumber7;
    private Button btnNumber8;
    private Button btnNumber9;
    private Button btnCham;
    private Button btnBS;
    private Button btnCE;

    List<String> list_view;
    ArrayAdapter<String> adapter;
    Spinner spin1, spin2;
    TextView tv_donvi1, tv_quy_doi,tv_updated_last, tv_donvi2;
    TextView  tvResult2;

    SpinnerModel1 tien_do = new SpinnerModel1("$",23000.0);
    SpinnerModel1 tien_thai = new SpinnerModel1("฿",718.75);
    SpinnerModel1 tien_viet = new SpinnerModel1("₫",1.0);
    SpinnerModel1 tien_trung = new SpinnerModel1("¥",3326.64);
    SpinnerModel1 tien_anh = new SpinnerModel1("€",25731.0);

    SpinnerModel1 from = tien_do;
    SpinnerModel1 to = tien_viet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        setEventClickViews();

        list_view = new ArrayList<>();
        list_view.add("England - Euro");
        list_view.add("United States - Dollar");
        list_view.add("ThaiLand - baht");
        list_view.add("VietNam - Dong");
        list_view.add("China - NhanDanTe");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,list_view);

        spin1= findViewById(R.id.spinner1);
        spin1.setAdapter(adapter);

        spin2 = findViewById(R.id.spinner2);
        spin2.setAdapter(adapter);

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        from = tien_anh;
                        break;
                    case 1:
                        from = tien_do;
                        break;
                    case 2:
                        from = tien_thai;
                        break;
                    case 3:
                        from = tien_viet;
                        break;
                    default:
                        from = tien_trung;
                        break;
                }
                tv_donvi1.setText(from.symbol);
                tv_quy_doi.setText("1 "+from.symbol + "="+ from.getRate(to) + to.symbol);
                xuatRaManHinh2 = String.valueOf((double)Math.round(Double.parseDouble(xuatRaManHinh)*from.getRate(to)*100)/100);
                tvResult2.setText(xuatRaManHinh2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        to = tien_anh;
                        break;
                    case 1:
                        to = tien_do;
                        break;
                    case 2:
                        to = tien_thai;
                        break;
                    case 3:
                        to = tien_viet;
                        break;
                    default:
                        to = tien_trung;
                        break;
                }
                tv_donvi2.setText(to.symbol);
                tv_quy_doi.setText("1 "+from.symbol + "="+ from.getRate(to) + to.symbol);
                xuatRaManHinh2 = String.valueOf((double)Math.round(Double.parseDouble(xuatRaManHinh)*from.getRate(to)*100)/100);
                tvResult2.setText(xuatRaManHinh2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    // Khởi tạo gán gtri các id cho button tương ứng
    public void initWidget() {
        tv_donvi2 = findViewById(R.id.tv_donvi2);
        tv_donvi1 = findViewById(R.id.tv_donvi1);
        tv_quy_doi = findViewById(R.id.tv_quy_doi);
        tv_updated_last = findViewById(R.id.tv_updated_last);
        tvResult = findViewById(R.id.tvResult);
        tvResult2 = findViewById(R.id.tvResult2);
        btnNumber0 =  findViewById(R.id.So0);
        btnNumber1 =  findViewById(R.id.So1);
        btnNumber2 =  findViewById(R.id.So2);
        btnNumber3 = findViewById(R.id.So3);
        btnNumber4 = findViewById(R.id.So4);
        btnNumber5 =  findViewById(R.id.So5);
        btnNumber6 = findViewById(R.id.So6);
        btnNumber7 = findViewById(R.id.So7);
        btnNumber8 =  findViewById(R.id.So8);
        btnNumber9 =  findViewById(R.id.So9);
        btnCham =  findViewById(R.id.dauCham);
        btnBS = findViewById(R.id.nutBS);
        btnCE = findViewById(R.id.nutCE);
    }

    // Lắng nghe sự kiện
    public void setEventClickViews() {
        btnNumber0.setOnClickListener(this);
        btnNumber1.setOnClickListener(this);
        btnNumber2.setOnClickListener(this);
        btnNumber3.setOnClickListener(this);
        btnNumber4.setOnClickListener(this);
        btnNumber5.setOnClickListener(this);
        btnNumber6.setOnClickListener(this);
        btnNumber7.setOnClickListener(this);
        btnNumber8.setOnClickListener(this);
        btnNumber9.setOnClickListener(this);
        btnCham.setOnClickListener(this);
        btnBS.setOnClickListener(this);
        btnCE.setOnClickListener(this);
    }

    //chạy vào hàm onClick khi có sự kiện click
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.nutCE:
                xuatRaManHinh="0";
                xuatRaManHinh2="0";
                break;

            // Xoá 1 ký tự vừa nhập
            case R.id.nutBS:
                String newNumber = deleteAString(xuatRaManHinh);
                xuatRaManHinh=newNumber;
                break;

            // Nối chuỗi các toán hạng và loại bỏ số 0 ở đầu toán hạng
            default:
                if(xuatRaManHinh.equals("0")){
                    xuatRaManHinh="";
                }

                xuatRaManHinh+=((Button)v).getText().toString();
                break;
        }
        // xu ly input
        xuatRaManHinh2 = String.valueOf((double)Math.round(Double.parseDouble(xuatRaManHinh)*from.getRate(to)*100)/100);
        //output
        tvResult.setText(xuatRaManHinh);
        tvResult2.setText(xuatRaManHinh2);

    }
    // Xoá ký tự vừa nhập vào
    public String deleteAString(String number) {
        if(number.length()>1) {
            String temp = number.substring(0, number.length() - 1);
            return temp;
        }
        else if(number.length() == 1){
            return "0";
        }
        return xuatRaManHinh ;
    }


}
