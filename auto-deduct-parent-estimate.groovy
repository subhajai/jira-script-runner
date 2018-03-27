import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.MutableIssue;
import com.atlassian.jira.event.type.EventDispatchOption;

if( issue.isSubTask() ) {
    
    Issue parent = issue.getParentObject();
    Long newEstimate = parent.getEstimate() - issue.getOriginalEstimate();
    Long newOriginalEsimate = parent.getOriginalEstimate() - issue.getOriginalEstimate();
    if(newEstimate < 0) {
        newEstimate = 0;
    }
    if( newOriginalEsimate < 0) {
        newOriginalEsimate = 0;
    }

    
    Long parentId = parent.getId();    
    MutableIssue parentObject = ComponentAccessor.getIssueManager().getIssueObject(parentId);
   
    parentObject.setEstimate(newEstimate);
    parentObject.setOriginalEstimate(newOriginalEsimate);
    
    ComponentAccessor.getIssueManager().updateIssue(
        issue.getReporter(),
        parentObject,
        EventDispatchOption.DO_NOT_DISPATCH,
        false
    ); 
    
}
