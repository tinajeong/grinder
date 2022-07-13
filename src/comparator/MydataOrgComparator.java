package comparator;

import java.util.ArrayList;

public class MydataOrgComparator {
    ArrayList<String> superSetList = new ArrayList<>();
    ArrayList<ArrayList<String>> subSetList = new ArrayList<>();
    String[] tableNameArr;
//    ArrayList<String> differ
    public MydataOrgComparator(int cnt) {
        subSetList.add(new ArrayList<>());
        tableNameArr = new String[cnt];
    }

    public MydataOrgComparator(ArrayList<ArrayList<String>> subSetList) {
        this.subSetList = subSetList;
        tableNameArr = new String[subSetList.size()];
    }



}
