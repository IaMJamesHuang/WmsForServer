package com.kt.james.wmsforserver.po;

public class ShelfItem {

    public static final int STATE_INIT = 0;

    public static final int STATE_FINISH = 1;

    private int id;

    private int item_id;

    private int shelf_list_id;

    private int loc_id;

    private int state;

    private float num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getShelf_list_id() {
        return shelf_list_id;
    }

    public void setShelf_list_id(int shelf_list_id) {
        this.shelf_list_id = shelf_list_id;
    }

    public int getLoc_id() {
        return loc_id;
    }

    public void setLoc_id(int loc_id) {
        this.loc_id = loc_id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public float getNum() {
        return num;
    }

    public void setNum(float num) {
        this.num = num;
    }
}
