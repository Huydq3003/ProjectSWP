/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DLC;

/**
 *
 * @author huy
 */
public class MessageSpecified {
    
    private String id;
    private String errorDetail;
    private String errorMessage;

    public MessageSpecified() {
    }

    public MessageSpecified(String id, String errorDetail, String errorMessage) {
        this.id = id;
        this.errorDetail = errorDetail;
        this.errorMessage = errorMessage;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    
}
