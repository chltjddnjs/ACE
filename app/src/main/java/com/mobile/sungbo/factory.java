package com.mobile.sungbo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Toast;

import com.mobile.sungbo.adapters.ItemAdapter;
import com.mobile.sungbo.models.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class factory extends AppCompatActivity implements ItemAdapter.onItemListener{
    private ItemAdapter adapter;
    private List<ItemModel> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.factory);
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        itemList = new ArrayList<>();
        fillData();
        adapter = new ItemAdapter(itemList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        adapter.setOnClickListener(this);
    }
    private void fillData() {
        itemList = new ArrayList<>();
        itemList.add(new ItemModel(R.drawable.wnddnjsguseo, " 중원현대서비스(블루핸즈)", "보험사 협력업체 : 없음 ", "무상대차 : 승용차", "중원구 하대원동 230-4", "010.7172.8204", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.ehdqnguseo, "동부현대서비스(블루핸즈)", "보험사 협력업체 : 삼성.현대.DB.KB ", "무상대차 : 승용차", "광주 쌍령동60-30", "010.2010.1140", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.hyundaiblue, "태전현대서비스(블루랜즈)", "보험사 협력업체 : 없음 ", "무상대차 : 없음 ", "경기도 광주시 순암로 155", "010.3319.0288", "픽업 : 가능"));
        itemList.add(new ItemModel(R.drawable.ehdrhkdwnguseo, "동광주현대서비스(블루핸즈)", "보험사 협력업체 : 없음 ", "무상대차 : 승용차", "광주시 초월읍 산수로148", "010.7496.1300", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.rhswldkaguseo, "곤지암현대서비스(블루핸즈)", "보험사 협력업체 : 삼성.LG.DB.악사.KB ", "무상대차 : 승용차", "광주 곤지암읍 대석동길 113", "010.9136.5601", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.tnwlwkehdck, "수지현대서비스(블루핸즈)", "보험사 협력업체 : 한화.DB ", "무상대차 : 없음", "경기 용인시 수지구 풍덕천로190번길 15-4", "010.9043.6658", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.rkdskaguseo, "강남현대서비스(블루핸즈)", "보험사 협력업체 : 삼성.현대.DB.KB.메리츠.한화.AXA.흥국.MG.캐롯.하나  ", "무상대차 : 없음", "서울 서초구 마방로 26", "010.5359.6202", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.eoflarldk, "대림기아서비스(오토큐)", "보험사 협력업체 : DB.더케이.메리츠.현대.악사.현대캐피탈 ", "무상대차 : 없음", "성남 사송동358-6", "010.7476.8317", "픽업 : 없음 "));
        itemList.add(new ItemModel(R.drawable.tnwlrldk, "수지기아서비스(오토큐)", "보험사 협력업체 : 한화.DB ", "무상대차 : 없음", "경기 용인시 수지구 풍덕천로190번길 15-4", "010.9043.6658", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.rkdskaguseo, "강남기아서비스(오토큐)", "보험사 협력업체 : 삼성.현대.DB.KB.메리츠.한화.AXA.흥국.MG.캐롯.하나", "무상대차 : 없음", "서울 서초구 마방로 26", "010.5359.6202", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.tjdskatkddyd, "성남쌍용자동차(센터)", "보험사 협력업체 :  ", "무상대차 : ", "성남 상대원동 178", "031.730.5582", "픽업 : "));
        itemList.add(new ItemModel(R.drawable.qnsekdwjdqltkdjqth, "동원쌍용자동차(센터)", "보험사 협력업체 :  ", "무상대차 : ", "성남 동원동 59-19", "031.719.5582", "픽업 : "));
        itemList.add(new ItemModel(R.drawable.altkehdlcl, "미사도이치(BMW)", "보험사 협력업체 :  ", "무상대차 : 없음", "셩기 하남시 덕풍로 192", "010.6731.0064", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.handokbmw, "분당한독서비스(BMW)", "보험사 협력업체 :  ", "무상대차 : ", "분당구 대왕판교로 331", "031.8016.7301", "픽업 : "));
        itemList.add(new ItemModel(R.drawable.qnsekddnlqhs, "분당위본서비스(아우디)", "보험사 협력업체 :  ", "무상대차 : ", "분당구 새마을로 31", "031.715.8255", "픽업 :  "));
        itemList.add(new ItemModel(R.drawable.tlgmdehdfpdlswlfhqj, "KCC 시흥동 랜드로버(센터)", "보험사 협력업체 :  ", "무상대차 : ", "성남 수정구 설개로2번길20", "031.723.6000", "픽업 :  "));
        itemList.add(new ItemModel(R.drawable.tlgmdehdfpdlswlfhqj, "KCC 시흥동 재규어(센터)", "보험사 협력업체 :  ", "무상대차 : ", "성남 수정구 설개로2번길20", "031.723.6000", "픽업 :  "));
        itemList.add(new ItemModel(R.drawable.qnsekdwlvm, "분당지프서비스(센터)", "보험사 협력업체 :  ", "무상대차 : 승용차", "성남 금곡동 368-10", "010.5026.7501", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.qnsekdwlvm, "분당피아트서비스(센터)", "보험사 협력업체 :  ", "무상대차 : 승용차", "성남 금곡동 368-10", "010.5026.7501", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.qnsekdvhrtmqkrps, "분당폭스바겐(센터)", "보험사 협력업체 :  ", "무상대차 : ", "성남 분당구 궁내동208-3", "031.696.0177", "픽업 :  "));
        itemList.add(new ItemModel(R.drawable.wnddnjsfmshtkatjd, "중원르노자동차(센터)", "보험사 협력업체 :  ", "무상대차 : 승용차", "성남 하대원동110", "010.5325.7656", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.dhvhtnpqhfp, "분당쉐보레(센터) ", "보험사 협력업체 :  ", "무상대차 : ", "경기도 성남시 분당구 대왕판교로 148", "050.71342.4273", "픽업 :  "));
        itemList.add(new ItemModel(R.drawable.dhvhvhemfldzjs, "오포포드서비스(센터)", "보험사 협력업체 :  ", "무상대차 : 승용차", "광주시 오포음 창뜰윗길6번길26", "010.3795.1790", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.dhvhvhemfldzjs, "오포링컨서비스(센터)", "보험사 협력업체 :  ", "무상대차 : 승용차", "광주시 오포음 창뜰윗길6번길26", "010.3795.1790", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.tntjfmshwkehdck, "수서르노자동차(센터)", "보험사 협력업체 :  ", "무상대차 : 승용차", "서울 헌릉로757길53", "010.5616.7633", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.thdvkqpscmtjqltm, "송파벤츠서비스(벤츠)", "보험사 협력업체 : ", "무상대차 : 없음", "서울 송파구 정의로8길6", "010.4568.7434", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.wnrwjsqpscmtjqltm, "죽전벤츠서비스(벤츠)", "보험사 협력업체 :  ", "무상대차 : ", "용인 수지구 용구대로 2749", "031.786.6100", "픽업 :  "));
        itemList.add(new ItemModel(R.drawable.dyddlsslttks, "용인닛산서비스(센터) ", "보험사 협력업체 :  ", "무상대차 : ", "용인 기흥구 용구대로 1845", "031.302.5800", "픽업 :  "));
        itemList.add(new ItemModel(R.drawable.dyddlsslttks, "용인인피니티서비스(센터) ", "보험사 협력업체 :  ", "무상대차 : ", "용인 기흥구 용구대로 1845", "031.302.5800", "픽업 :  "));
        itemList.add(new ItemModel(R.drawable.dyddlsvnwhtjqltm, "용인수원 푸조서비스(센터) ", "보험사 협력업체 :  ", "무상대차 : 승용차", "용인 기흥구 중부대로 48", "010.9191.4972", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.dyddlsvnwhtjqltm, "용인수원 시트로엥서비스(센터) ", "보험사 협력업체 :  ", "무상대차 : 승용차", "용인 기흥구 중부대로 48", "010.9191.4972", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.skaqnsekdfmsh, "남분당르노자동차(센터) ", "보험사 협력업체 :  ", "무상대차 : 승용차", "용인 보정동 375-16", "031.8021.7600", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.tndnjsqhfqhtjqltm, "수원 볼보서비스(센터)", "보험사 협력업체 :  ", "무상대차 : ", "수원 원천동 245-1", "031.211.8575", "픽업 :  "));
        itemList.add(new ItemModel(R.drawable.tjdtksworbdj, "성산 재규어서비스(센터)", "보험사 협력업체 :  ", "무상대차 : ", "서울 마포구 모래내로1길 23", "010.5882.3153", "픽업 :  "));
        itemList.add(new ItemModel(R.drawable.tjdtksworbdj, "성산 랜드로버서비스(센터)", "보험사 협력업체 :  ", "무상대차 : ", "서울 마포구 모래내로1길 23", "010.5882.3153", "픽업 :  "));
        itemList.add(new ItemModel(R.drawable.dlscjsskaehdworbdj, "인천남동 재규어서비스(센터)", "보험사 협력업체 :  ", "무상대차 : ", "인천 남동구 고잔동512-20", "010.5882.3153", "픽업 : "));
        itemList.add(new ItemModel(R.drawable.dlscjsskaehdworbdj, "인천남동 랜드로버서비스(센터)", "보험사 협력업체 :  ", "무상대차 : ", "인천 남동구 고잔동512-20", "010.5882.3153", "픽업 : "));
        itemList.add(new ItemModel(R.drawable.whdudwkehdck, "조영자동차공업사", "보험사 협력업체 : 현대.KB.메리츠.악사.캐롯.DB.한화 ", "무상대차 : 승용차", "성남 하대원동 143", "010.2851.5756", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.sungbo, "성보자동차공업사", "보험사 협력업체 : DB.KB.현대.삼성.한화 ", "무상대차 : 승용차/1톤화물", "광주 태전동 413", "010.6236.6226", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.rhkdwnxhxkfguseo, "토탈현대자동차공업사 ", "보험사 협력업체 : MG.쌍용.한화 ", "무상대차 : 승용차/1톤화물", "광주 절골길80", "010.5216.0038", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.dpadpaahxjtm, "엠엠모터스 분당점", "보험사 협력업체 : 삼성.DB.현대.악사.KB.메리츠 ", "무상대차 : 승용차", "광주 신현동 672-7", "010.9306.9745", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.eotksguseoahxjtm, "대산현대모터스", "보험사 협력업체 : 현대.삼성.DB.KB.교보.한화 ", "무상대차 : 승용차/1톤화물", "광주 쌍령동 121-1", "010.8638.7922", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.dbqlswkeheck, "유빈모터스", "보험사 협력업체 : 삼성.현대.DB.KB.메리츠.한화.AXA.흥국.MG.캐롯.하나 ", "무상대차 : 승용차/1톤화물", "광주 장지동 609-1", "010.6710.6575", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.ckdwkrahxjtm, "창작모터스", "보험사 협력업체 : 없음 ", "무상대차 : 없음", "중원구 하대원동 230-4", "010.4723.7521", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.dptmzkahxjtm, "에스카모터스", "보험사 협력업체 : 삼성.DB.메리츠.SK렌터카.롯데렌터카.JB우리캐피탈 ", "무상대차 : 없음", "기흥구 용구대로2469번길 164", "010.4104.7669", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.xodkstjqltmdkdnel, "태안서비스(아우디)", "보험사 협력업체 : 없음 ", "무상대차 : 없음", "용산구 한강대로 21길7", "010.4045.7477", "픽업 :  "));
        itemList.add(new ItemModel(R.drawable.tjchdnlqhstjqltm, "서초위본서비스(아우디)", "보험사 협력업체 : 없음 ", "무상대차 : 없음", "서초구 남구순환로 342길94", "010.3311.6624", "픽업 :  "));
        itemList.add(new ItemModel(R.drawable.dhvhguseotjqltm, "오포현대서비스(블루핸즈)", "보험사 협력업체 : 현대.삼성.디비.케이비.악사.한화 ", "무상대차 : 없음", "오포읍 신현로85", "010.4469.6652", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.gkswlsahxjtm, "한진모터스", "보험사 협력업체 :  확인필요 ", "무상대차 : 없음", "광주 이배재로210 ", "010.9036.0202", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.wnrwjsdhxhzpdj, "죽전오토케어(테슬라)", "보험사 협력업체 : 삼성.디비 ", "무상대차 : 없음", "처인구 모현읍 오산로12-21", "010.2221.7455", "픽업 : 가능 "));
        itemList.add(new ItemModel(R.drawable.gkskagytjdqpscm, "하남효성벤츠서비스(벤츠)", "보험사 협력업체 : 확인필요 ", "무상대차 : 없음", "하남시 감초로188", "010.4568.6208", "픽업 : 가능 "));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onItemClicked(int position) {
        Intent get_explain = new Intent(getApplicationContext(),factory_explain.class);
        get_explain.putExtra("factory_image",itemList.get(position).getImageResource());
        get_explain.putExtra("factory",itemList.get(position).getText1());
        get_explain.putExtra("company",itemList.get(position).getText2());
        get_explain.putExtra("car",itemList.get(position).getText3());
        get_explain.putExtra("address",itemList.get(position).getText4());
        get_explain.putExtra("number",itemList.get(position).getText5());
        get_explain.putExtra("etc",itemList.get(position).getText6());
        startActivity(get_explain);
        finish();
    }
}
