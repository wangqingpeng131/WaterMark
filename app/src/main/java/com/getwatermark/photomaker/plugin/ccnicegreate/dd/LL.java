package com.getwatermark.photomaker.plugin.ccnicegreate.dd;

/**
 * @author Afra55
 * @date 2018/7/20
 * A smile is the best business card.
 */
public class LL extends CBaseBean {

    /**
     * status : 1
     * message : success
     * isStoreTester : true
     */

    private int status;
    private String message;
    // ture 隐藏入口
    private boolean isStoreTester;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isIsStoreTester() {
        return isStoreTester;
    }

    public void setIsStoreTester(boolean isStoreTester) {
        this.isStoreTester = isStoreTester;
    }
}
