package com.extremecoder.fileservice.model;


import com.extremecoder.fileservice.enums.ActiveStatus;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable {

    private ActiveStatus activeStatus = ActiveStatus.ACTIVE;
    private Date dateCreated = new Date();
    private Date updatedDate;

    public ActiveStatus getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(ActiveStatus activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
