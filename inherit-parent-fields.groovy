import com.atlassian.jira.issue.Issue;
// import com.atlassian.jira.issue.IssueManager;
import com.atlassian.jira.component.ComponentAccessor;

if( issue.isSubTask() ) {
    
    Issue parent = issue.getParentObject();
    issue.fixVersions = parent.getFixVersions();
  	def customFieldManager = ComponentAccessor.getCustomFieldManager();
    def cf = customFieldManager.getCustomFieldObjects(parent).find {it.name == 'Billable'};
    
    log.warn(cfValues['Billable']?.value);
        
    if( !cfValues['Billable']?.value ) {
    	
		issue.setCustomFieldValue(cf, parent.getCustomFieldValue(cf));
    }
    

    
    /*
	To deduct the parent's remaining estimate, to be continued.
	Long newEstimate = parent.getEstimate() - issue.getOriginalEstimate();
    if(newEstimate < 0) {
        newEstimate = 0;
    }
        
  	Issue parentObject = IssueManager.getIssueObject(parent.getId());
    parentObject.setEstimate(new Long(issue.getOriginalEstimate()));
	*/
}

