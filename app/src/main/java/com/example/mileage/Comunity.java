package com.example.mileage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class Comunity extends Fragment {

    View view;
    SearchView searchView;
    FloatingActionButton Fabwrite;

    private RecyclerView comunityview;
    private MainAdapter adapter;
    private List<Board> boardList;

    private class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

        private List<Board> boardList;

        public MainAdapter(List<Board> boardList){
            this.boardList = boardList;
        }

        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
            Board data = boardList.get(position);
            holder.TitleTextView.setText(data.getTitle());
            holder.NameTextView.setText(data.getName());
        }

        @Override
        public int getItemCount() {
            return boardList.size();
        }

        class MainViewHolder extends RecyclerView.ViewHolder {
            private TextView TitleTextView;
            private TextView NameTextView;

            public MainViewHolder(View itemView) {
                super(itemView);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity(), Checklist.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent);
                    }
                });
                TitleTextView = (TextView) itemView.findViewById(R.id.itemTitle);
                NameTextView = (TextView) itemView.findViewById(R.id.itemName);

            }
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 프레그먼트 화면 뷰를 객체화
        view = inflater.inflate(R.layout.fragment_comunity, container, false);

        Fabwrite = (FloatingActionButton) view.findViewById(R.id.Floating1);
        comunityview = (RecyclerView) view.findViewById(R.id.C_list);
        comunityview.setHasFixedSize(true);
        comunityview.setLayoutManager(new LinearLayoutManager(getActivity()));
        comunityview.setAdapter(adapter);
        boardList = new ArrayList<>();
        boardList.add(new Board(null, "반갑습니다.",null,"android"));
        boardList.add(new Board(null, "Hello",null,"server"));
        boardList.add(new Board(null, "OK",null,"java"));
        boardList.add(new Board(null, "안녕하세요",null,"php"));
        boardList.add(new Board(null, "zz",null,"c"));
        boardList.add(new Board(null, "ㅎㅎ",null,"ㅠㅠ"));
        boardList.add(new Board(null, "질문",null,"사용자"));
        boardList.add(new Board(null, "ㅎㅇ",null,"ㄷㄷ"));
        boardList.add(new Board(null, "분리수거",null,"ppp"));
        boardList.add(new Board(null, "배고파요",null,"hu"));
        boardList.add(new Board(null, "보고싶읍니다",null,"부자"));


        adapter = new MainAdapter(boardList);
        comunityview.setAdapter(adapter);

        // 글 작성 버튼
        Fabwrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Writing.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });


                // searchview 검색 키워드 지정
        searchView = view.findViewById(R.id.csearch);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if (s.equals("OK")) {
                    Intent intent = new Intent(getActivity(), Checklist.class);
                    startActivity(intent);
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        // 게시글 클릭시 화면 전환
        comunityview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Checklist.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        return view;


        }
    }

