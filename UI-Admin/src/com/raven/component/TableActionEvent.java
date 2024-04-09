package com.raven.component;

/**
 *
 * @author RAVEN
 */
public interface TableActionEvent {

    public void onEdit(int row);
    public void onDelete(int row);
    public void onEnable(int row);
   
}
