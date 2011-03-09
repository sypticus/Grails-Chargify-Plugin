package org.grails.plugins.chargify;


import groovy.xml.MarkupBuilder
import java.text.ParseException

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: Mar 8, 2011
 * Time: 5:06:21 PM
 * To change this template use File | Settings | File Templates.
 */
class Adjustment{
    String adjustmentMethod
    static final String dateFormat = "yyyy-MM-dd'T'HH:mm:ss"
    Date createdAt
    String productId
    String endingBalance
    String memo
    String id
    String transactionType
    String type
    String amount
    String success
    String subscriptionId

    String getXml(){
        StringWriter xmlWriter = new StringWriter()
        MarkupBuilder xmlBuilder = new MarkupBuilder(xmlWriter)
        xmlBuilder.adjustment() {
            ending_balance_in_cents(endingBalance)
            memo(memo)
            amount_in_cents(amount)
            adjustment_method(adjustmentMethod)
        }
        return xmlWriter.toString()
    }

    public static org.grails.plugins.chargify.Adjustment getAdjustmentFromXml(String xml){
       def chargifyAdjustment = new XmlParser().parseText(xml);
       org.grails.plugins.chargify.Adjustment adjustment = new org.grails.plugins.chargify.Adjustment()
        try {
            adjustment.createdAt = Date.parse(dateFormat, chargifyAdjustment.created_at.text())
        } catch (ParseException e) {
            // Unable to parse date
        }
        adjustment.productId = chargifyAdjustment.product_id.text()
        adjustment.endingBalance = chargifyAdjustment.ending_balance_in_cents.text()
        adjustment.memo = chargifyAdjustment.memo.text()
        adjustment.id = chargifyAdjustment.id.text()
        adjustment.transactionType = chargifyAdjustment.transaction_type.text()
        adjustment.type = chargifyAdjustment.type.text()
        adjustment.success = chargifyAdjustment.success.text()
        adjustment.amount = chargifyAdjustment.amount_in_cents.text()
        adjustment.subscriptionId = chargifyAdjustment.subscription_id.text()
        return adjustment
    }

}
