package org.muni.fi;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

 
public class GetFreePlacesHandler implements java.io.Serializable, WorkItemHandler
{
    static final long serialVersionUID = 1L;

    public GetFreePlacesHandler() {}
    
    public void	abortWorkItem(WorkItem workItem, WorkItemManager manager)
    {

    }

    public void	executeWorkItem(WorkItem workItem, WorkItemManager manager)
    {
        Date start = (Date)workItem.getParameter("start");
        Date end = (Date)workItem.getParameter("end");
    
        // get free places
        SQLServerDB sqlServerDB = new SQLServerDB();
        Integer availablePlaces = sqlServerDB.getFreePlaces(start, end);
      
        //this is how you can construct workitem output
        Map<String,Object> results = new HashMap<String,Object>();
        results.put("free", availablePlaces);
    
        System.out.println("There are " + availablePlaces + " chairs available for reservation.");

        //you always need to call complete method, otherwise your process will not proceed!
        manager.completeWorkItem(workItem.getId(), results);
    }
}