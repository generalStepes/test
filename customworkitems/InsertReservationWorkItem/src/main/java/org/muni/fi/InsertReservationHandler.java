package org.muni.fi;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

 
public class InsertReservationHandler implements java.io.Serializable, WorkItemHandler
{
    static final long serialVersionUID = 1L;

    public InsertReservationHandler() {}
    
    public void	abortWorkItem(WorkItem workItem, WorkItemManager manager)
    {

    }

    public void	executeWorkItem(WorkItem workItem, WorkItemManager manager)
    {
        Reservation reservation = (Reservation)workItem.getParameter("reservation");
    
        // insert new reservation
        SQLServerDB sqlServerDB = new SQLServerDB();
        Integer insertedRows = sqlServerDB.insertReservation(reservation);
      
        //this is how you can construct workitem output
        Map<String,Object> results = new HashMap<String,Object>();
        results.put("insertedRows", insertedRows);
    
        System.out.println("A new reservation has been created!");

        //you always need to call complete method, otherwise your process will not proceed!
        manager.completeWorkItem(workItem.getId(), results);
    }
}