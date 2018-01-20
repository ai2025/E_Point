package smktelkom_mlg.learn.e_point;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Laporan extends AppCompatActivity {

    private final String url = "http://10.0.3.2/epoin/getDataLaporan.php";
    private final String url_update = "http://10.0.3.2/epoin/updateData.php";
    private final String url_delete = "http://10.0.3.2/epoin/deleteData.php";
    RecyclerView mRecyclerview;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mManager;
    RequestQueue mRequest;
    List<ModelList> mListItems;
    EditText idLaporan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan);

        idLaporan = (EditText) findViewById(R.id.tvId);
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerTemp);
        mRequest = Volley.newRequestQueue(getApplicationContext());
        mListItems = new ArrayList<>();

        request();

        mManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerview.setLayoutManager(mManager);
        mAdapter = new AdapterList(mListItems, Laporan.this);
        mRecyclerview.setAdapter(mAdapter);


    }

    private void request() {
        JsonArrayRequest requestLaporan = new JsonArrayRequest(Request.Method.POST, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        Log.d("JSONResponse", response.toString());
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject data = response.getJSONObject(i);
                                ModelList model = new ModelList();
                                model.setNama(data.getString("nama"));
                                model.setNama_pelanggaran(data.getString("nama_pelanggaran"));
                                model.setNama_kategori("Kategori : " + data.getString("nama_kategori"));
                                model.setTanggal(data.getString("tanggal"));
                                model.setPoin("poin : " + data.getString("poin"));

                                mListItems.add(model);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            mAdapter.notifyDataSetChanged();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.d("ERRORRequest", "Error : " + error.getMessage());
                    }
                });
        mRequest.add(requestLaporan);
    }

    public void Update(View view) {
        Intent intent = new Intent(Laporan.this, Update.class);
        startActivity(intent);

    }


}