package fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.R;

import java.util.ArrayList;

import Models.ApiUtilities;
import Models.ModelClass;
import Models.mainNews;
import adapters.Adapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusinessFragment extends Fragment {
    String API_KEY="6c76309661e948fe848a707205125f19";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country = "in";
    private RecyclerView recyclerViewBusiness;
    private String category = "business";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.business_fragment,null);
        recyclerViewBusiness=v.findViewById(R.id.business_recycler_view);
        modelClassArrayList=new ArrayList<>();
        recyclerViewBusiness.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Adapter(getContext(),modelClassArrayList);
        recyclerViewBusiness.setAdapter(adapter);
        findNews();
        return v;

    }

    private void findNews() {
        ApiUtilities.getApiInterface().getCategoryNews(country, category,100,API_KEY).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if (response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });
    }
}
