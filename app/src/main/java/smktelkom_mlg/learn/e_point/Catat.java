package smktelkom_mlg.learn.e_point;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@SuppressLint("NewApi")
public class Catat extends Activity {

    Spinner nama, nama_pelanggaran;
    String vNama, vNamapel;
    TextView tanggal;
    Button simpan;
    RequestQueue requestQueue;
    String insertUrl = "http://10.0.2.2/epoin/insertData.php";

    //datepicker start
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    //dp end
    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            showDate(arg1, arg2 + 1, arg3);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catat);

        nama = (Spinner) findViewById(R.id.spinner1);
        nama_pelanggaran = (Spinner) findViewById(R.id.spinner2);
        //tanggal = (TextView) findViewById(R.id.tvShowDate);
        simpan = (Button) findViewById(R.id.btn_simpan);

        requestQueue = Volley.newRequestQueue(getApplicationContext());



        //dp start
        dateView = (TextView) findViewById(R.id.tvShowDate);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month + 1, day);
        //end

        // Permission StrictMode
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        // spinner1
        final Spinner spin = (Spinner) findViewById(R.id.spinner1);
        //String nama = spin.getSelectedItem().toString();

        //spinner2
        final Spinner spin2 = (Spinner) findViewById(R.id.spinner2);
        //String nama_pelanggaran = spin2.getSelectedItem().toString();

        //spinner1
        String url = "http://10.0.2.2/epoin/getDataSiswa.php";

        //spinner2
        String url2 = "http://10.0.2.2/epoin/getDataJenis.php";

        //spinner1
        try {

            JSONArray data = new JSONArray(getJSONUrl(url));

            final ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map;

            for (int i = 0; i < data.length(); i++) {
                JSONObject c = data.getJSONObject(i);

                map = new HashMap<String, String>();
                //map.put("id_siswa", c.getString("id_siswa"));
                //map.put("nis", c.getString("nis"));
                map.put("nama", c.getString("nama"));
                MyArrList.add(map);

            }
            SimpleAdapter sAdap;
            sAdap = new SimpleAdapter(Catat.this, MyArrList, R.layout.activity_show,
                    new String[]{/*"id_siswa", "nis",*/ "nama"}, new int[]{/*R.id.ColID, R.id.ColNis,*/ R.id.ColNama});
            spin.setAdapter(sAdap);

            final AlertDialog.Builder viewDetail = new AlertDialog.Builder(this);

            spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                public void onItemSelected(AdapterView<?> arg0, View selectedItemView,
                                           int position, long id) {
                    //String id_siswa = MyArrList.get(position).get("id_siswa").toString();
                    //String nis = MyArrList.get(position).get("nis").toString();
                    vNama = MyArrList.get(position).get("nama");

                    /*viewDetail.setIcon(android.R.drawable.btn_star_big_on);
                    viewDetail.setTitle("Siswa");
                    viewDetail.setMessage("Id Siswa : " + id_siswa + "\n"
                            + "Nis : " + nis + "\n" + "Nama : " + nama);
                    viewDetail.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    // TODO Auto-generated method stub
                                    dialog.dismiss();
                                }
                            });
                    viewDetail.show();*/

                }

                public void onNothingSelected(AdapterView<?> arg0) {
                    // TODO Auto-generated method stub
                    Toast.makeText(Catat.this,
                            "Your Selected : Nothing",
                            Toast.LENGTH_SHORT).show();
                }
            });

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //spinner2
        try {

            JSONArray data = new JSONArray(getJSONUrl(url2));

            final ArrayList<HashMap<String, String>> MyArrList2 = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map;

            for (int i = 0; i < data.length(); i++) {
                JSONObject c = data.getJSONObject(i);

                map = new HashMap<String, String>();
                //map.put("id_siswa", c.getString("id_siswa"));
                //map.put("nis", c.getString("nis"));
                map.put("nama_pelanggaran", c.getString("nama_pelanggaran"));
                map.put("poin", c.getString("poin"));
                MyArrList2.add(map);

            }
            SimpleAdapter sAdapt;
            sAdapt = new SimpleAdapter(Catat.this, MyArrList2, R.layout.activity_show2,
                    new String[]{/*"id_siswa", "nis",*/ "nama_pelanggaran", "poin"}, new int[]{/*R.id.ColID, R.id.ColNis,*/ R.id.ColJenis, R.id.ColPoin});
            spin2.setAdapter(sAdapt);

            final AlertDialog.Builder viewDetail = new AlertDialog.Builder(this);

            spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                public void onItemSelected(AdapterView<?> arg0, View selectedItemView,
                                           int position, long id) {
                    //String id_siswa = MyArrList.get(position).get("id_siswa").toString();
                    //String nis = MyArrList.get(position).get("nis").toString();
                    vNamapel = MyArrList2.get(position).get("nama_pelanggaran");

                    /*viewDetail.setIcon(android.R.drawable.btn_star_big_on);
                    viewDetail.setTitle("Siswa");
                    viewDetail.setMessage("Id Siswa : " + id_siswa + "\n"
                            + "Nis : " + nis + "\n" + "Nama : " + nama);
                    viewDetail.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    // TODO Auto-generated method stub
                                    dialog.dismiss();
                                }
                            });
                    viewDetail.show();*/

                }

                public void onNothingSelected(AdapterView<?> arg0) {
                    // TODO Auto-generated method stub
                    Toast.makeText(Catat.this,
                            "Your Selected : Nothing",
                            Toast.LENGTH_SHORT).show();
                }
            });

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //end

        //spinner2 poin

        //end

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progressDialog = ProgressDialog.show(Catat.this, "", "Menyimpan....");

                StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        Log.d("res", response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Log.e("reponError", error.getMessage());
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parameters = new HashMap<String, String>();
                        parameters.put("nama", vNama);
                        parameters.put("nama_pelanggaran", vNamapel);
                        parameters.put("tanggal", dateView.getText().toString());

                        return parameters;
                    }
                };
                requestQueue.add(request);
                Log.d("Test", vNama);
                Log.d("Test", vNamapel);
                Log.d("Test", dateView.getText().toString());
            }
        });
    }

    //dp start
    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(year).append("-").append(month).append("-").append(day));
    }
    //end

    public String getJSONUrl(String url) {
        StringBuilder str = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) { // Download OK
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine()) != null) {
                    str.append(line);
                }
            } else {
                Log.e("Log", "Failed to download result..");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str.toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}
