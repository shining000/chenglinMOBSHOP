package com.chenglin.mobileshop.fragment;import android.support.v4.app.FragmentManager;import android.support.v4.app.FragmentTransaction;import android.view.View;import android.widget.ImageButton;import com.chenglin.mobileshop.R;import com.chenglin.mobileshop.common.BaseFragment;public class NavigationFragment extends BaseFragment implements View.OnClickListener{    private ImageButton tabItemHomeBtn,tabItemCateGoryBtn,tabItemCartBtn,tabItemPersonalBtn;    private HomeFragment homeFragment;    private CategoryFragment categroyFragment;    private CartFragment cartFragment;    private PersonalFragment personalFragment;    @Override    public int getContentId() {        return R.layout.fragment_navication;    }   //初始化视图对象    @Override    protected void initView(View view){        super.initView(view);        tabItemHomeBtn=view.findViewById(R.id.tab_item_home_btn);        tabItemCateGoryBtn=view.findViewById(R.id.tab_item_category_btn);        tabItemCartBtn=view.findViewById(R.id.tab_item_cart_btn);        tabItemPersonalBtn=view.findViewById(R.id.tab_item_personal_btn);        tabItemHomeBtn.setOnClickListener(this);        tabItemCateGoryBtn.setOnClickListener(this);        tabItemCartBtn.setOnClickListener(this);        tabItemPersonalBtn.setOnClickListener(this);        setTabSelection(tabItemHomeBtn.getId());    }    //设置Tab选中    public void setTabSelection(int id) {        //重置所有tabItem状态        tabItemHomeBtn.setImageResource(R.drawable.tab_item_home_normal);        tabItemCateGoryBtn.setImageResource(R.drawable.tab_item_category_normal);        tabItemCartBtn.setImageResource(R.drawable.tab_item_cart_normal);        tabItemPersonalBtn.setImageResource(R.drawable.tab_item_personal_normal);        //开启一个事务        FragmentManager fragmentManager=getFragmentManager();        assert fragmentManager != null;        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();        //隐藏所有Fragment        if(homeFragment!=null)            fragmentTransaction.hide(homeFragment);        if(categroyFragment !=null)            fragmentTransaction.hide(categroyFragment);        if(cartFragment!=null)            fragmentTransaction.hide(cartFragment);        if(personalFragment!=null)            fragmentTransaction.hide(personalFragment);        //根据tabItem的id来执行不同的操作        switch(id){            case R.id.tab_item_home_btn:                tabItemHomeBtn.setImageResource(R.drawable.tab_item_home_focus);                if(homeFragment==null){                    homeFragment=new HomeFragment();                    fragmentTransaction.add(R.id.fl_main_navigation,homeFragment);                }else {                    fragmentTransaction.show(homeFragment);                }                break;            case R.id.tab_item_category_btn:                tabItemCateGoryBtn.setImageResource(R.drawable.tab_item_category_focus);                if(categroyFragment ==null){                    categroyFragment =new CategoryFragment();                    fragmentTransaction.add(R.id.fl_main_navigation, categroyFragment);                }else {                    fragmentTransaction.show(categroyFragment);                }                break;            case R.id.tab_item_cart_btn:                tabItemCartBtn.setImageResource(R.drawable.tab_item_cart_focus);                if(cartFragment==null){                    cartFragment=new CartFragment();                    fragmentTransaction.add(R.id.fl_main_navigation,cartFragment);                }else {                    fragmentTransaction.show(cartFragment);                }                break;            case R.id.tab_item_personal_btn:                tabItemPersonalBtn.setImageResource(R.drawable.tab_item_personal_focus);                if(personalFragment==null){                    personalFragment=new PersonalFragment();                    fragmentTransaction.add(R.id.fl_main_navigation,personalFragment);                }else {                    fragmentTransaction.show(personalFragment);                }                break;        }        fragmentTransaction.commit();    }    //点击事件    @Override    public void onClick(View view) {        setTabSelection(view.getId());    }}