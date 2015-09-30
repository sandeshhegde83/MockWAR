/*
 * -------------------------------------------------------------------------
 *
 * (C) Copyright / American Express, Inc. All rights reserved.
 * The contents of this file represent American Express trade secrets and
 * are confidential. Use outside of American Express is prohibited and in
 * violation of copyright law.
 *
 * -------------------------------------------------------------------------
 */

package com.mockservlet.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mockservlet.constants.ApplicationConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mockservice.domain.CardJson;
import com.mockservice.domain.Greeting;

/**
 * MockServletController
 *
 * @author shegde6
 * @version $Id$
 */
@Controller
public class MockServletController {
	
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
	
	@Autowired
    ServletContext context;

	/**
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/main")
    public ModelAndView viewMainPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	
        String uri =
            getApplicationController(ApplicationConstants.APP_MAIN_CONTROLLER_VIEW).performAction(request, response,
                "main");
        
        return new ModelAndView(uri);
    }
    
    @RequestMapping("/import")
    public ModelAndView viewImportPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	
        String uri =
            getApplicationController(ApplicationConstants.APP_IMPORT_CONTROLLER_VIEW).performAction(request, response,
                "main");
        
        return new ModelAndView(uri);
    }
    @RequestMapping("/operation")
    public ModelAndView getoperation(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	
        String uri =
            getApplicationController(ApplicationConstants.APP_OPERATION_CONTROLLER_VIEW).performAction(request, response,
                "operation");
        
        return new ModelAndView(uri);
    }
    @RequestMapping("/saveDefResp")
    public ModelAndView saveDefaultResp(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	
        String uri =
            getApplicationController(ApplicationConstants.APP_SAVE_DEF_RESP_CONTROLLER_VIEW).performAction(request, response,
                "saveDefResp");
        
        return new ModelAndView(uri);
    }
    
    @RequestMapping("/customResponse")
    public ModelAndView getCustomResponse(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	
        String uri =
            getApplicationController(ApplicationConstants.APP_CUSTOM_RESPONSE_CONTROLLER_VIEW).performAction(request, response,
                "customResponse");
        
        return new ModelAndView(uri);
    }
    
    @RequestMapping("/saveCustomResp")
    public ModelAndView saveCustomResp(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	
        String uri =
            getApplicationController(ApplicationConstants.APP_SAVE_CUSTOM_RESP_CONTROLLER_VIEW).performAction(request, response,
                "saveCustomResp");
        
        return new ModelAndView(uri);
    }
    
    @RequestMapping("/showSavedHistory")
    public ModelAndView showSavedHistory(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	
        String uri =
            getApplicationController(ApplicationConstants.APP_SHOW_SAVED_HISTORY_CONTROLLER_VIEW).performAction(request, response,
                "showSavedHistory");
        
        return new ModelAndView(uri);
    }
    /*@RequestMapping("/greeting")
    public @ResponseBody Greeting greeting(
            @RequestParam(value="name", required=false, defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }*/
    
    @RequestMapping("/greeting")
    public @ResponseBody CardJson getJson(
            @RequestParam(value="name", required=false, defaultValue="World") String name) {
        return new CardJson("{\"CardList\":{\"Card\":{\"GlobalDataFragment\":{\"CardAccountNumber\":{\"AccountNO\":\"XXXXXXXXXX12008\",\"BasicCardAccountNumber\":\"XXXXXXXXXX12008\",\"FiveDigitAccountNO\":\"XXXX-XXXXXX-12008\",\"ReplacedIN\":\"false\",\"ConsistentAccountRepresentation\":{\"InternalAccountNOIndexNO\":\"37972699961\",\"InternalAccountNO\":\"0000300066005784104\",\"UnchangingAccountNO\":\"0000300066005784104\",\"UnchangingCardNO\":\"3797269996100\"}},\"EnrolledOnlineIN\":\"true\",\"SortedIndexNO\":\"0\",\"CardKeyData\":\"BD42D16AFA86C7BA0BC72D8944A19267489C20BD\",\"LegacyCardKeyData\":\"6EBD20C87A1295E6C3B9801D1F1246A9\",\"PurgedAccountIN\":\"false\"},\"CardHolderFragment\":{\"EmbossedNM\":\"SANDESH HEGDE\",\"BirthDT\":{\"Day\":\"28\",\"Month\":\"2\",\"Year\":\"1983\"},\"MemberSinceDT\":{\"Day\":\"-1\",\"Month\":\"-1\",\"Year\":\"2012\"},\"TitleNM\":\"\",\"FirstNM\":\"SANDESH\",\"MiddleNM\":\"\",\"LastNM\":\"HEGDE\",\"SuffixNM\":\"\",\"NationalID\":\"764276066\",\"ProminentIN\":\"false\",\"StudentIN\":\"false\",\"CharterMemberIN\":\"false\",\"SeniorIN\":\"false\",\"LegalBusinessNM\":\"\"},\"ContactInfoFragment\":{\"BillingAddress\":{\"CityNM\":\"PHOENIX\",\"CountryNM\":\"US\",\"StateNM\":\"AZ\",\"StreetAddressLine1DS\":\"18250 N 25TH AVE APT 2054\",\"StreetAddressLine2DS\":\"\",\"AddrPostalCd\":\"850231279\"},\"BillingAddressChangeDT\":{\"Day\":\"11\",\"Month\":\"5\",\"Year\":\"2014\"},\"AddressEffectiveDT\":{\"Day\":\"11\",\"Month\":\"5\",\"Year\":\"2014\"},\"HomePhoneNO\":\"4803941547\",\"BusinessPhoneNO\":\"4803941547\",\"Last4DigitsBusinessPhoneNO\":\"\"},\"LOBFragment\":{\"CorpNM\":\"\",\"CorpID\":\"\",\"CorpTaxID\":\"\"},\"CardStatusFragment\":{\"AccountSetupDT\":{\"Day\":\"6\",\"Month\":\"9\",\"Year\":\"2012\"},\"ExpirationDT\":{\"Day\":\"31\",\"Month\":\"7\",\"Year\":\"2019\"},\"CardAccountStatus\":{\"AccountStatusCodes\":[{\"Value\":{\"Indicator\":\"true\"},\"_AcctStaCd\":\"Active\"},{\"Value\":{\"Indicator\":\"false\"},\"_AcctStaCd\":\"CanceledBankrupt\"},{\"Value\":{\"ElementMetaData\":{\"_notAvailableIN\":\"true\"}},\"_AcctStaCd\":\"CanceledDeceased\"},{\"Value\":{\"Indicator\":\"true\"},\"_AcctStaCd\":\"ReplacedSinceEnrolled\"},{\"Value\":{\"Indicator\":\"false\"},\"_AcctStaCd\":\"CardInCycleCut\"}],\"ReplacedReasonCodes\":{\"Value\":{\"Indicator\":\"true\"},\"_ReplStaCD\":\"ReplacedDerogatory\"},\"DaysPastDueCount\":\"0\",\"ReplaceReasonCode\":\"01\",\"CancelStatusCode\":\"\",\"CancelStatusChangeDate\":{\"Day\":\"-1\",\"Month\":\"-1\",\"Year\":\"-1\"}}},\"ProgramEnrollmentFragment\":{\"PaperLessEnrolledIN\":\"false\",\"PastPaperLessEnrolledIN\":\"false\",\"BlueLootEnrolledIN\":\"false\"},\"CardProductFragment\":{\"ProductDS\":\"Costco TrueEarnings Card\",\"SpecialPlasticCard\":\"\",\"AbbreviatedProductDS\":\"CCSG WAREHOUSE CARD\",\"DigitalAssetID\":\"NUS000000129\",\"CardType\":{\"PlasticTypes\":[{\"Value\":{\"Indicator\":\"true\"},\"_PlasticName\":\"Revolve\"},{\"Value\":{\"Indicator\":\"false\"},\"_PlasticName\":\"OneFromAmericanExpress\"},{\"Value\":{\"Indicator\":\"true\"},\"_PlasticName\":\"Optima\"},{\"Value\":{\"Indicator\":\"false\"},\"_PlasticName\":\"NestCard\"},{\"Value\":{\"Indicator\":\"false\"},\"_PlasticName\":\"ClearCard\"},{\"Value\":{\"Indicator\":\"false\"},\"_PlasticName\":\"Executive\"},{\"Value\":{\"Indicator\":\"false\"},\"_PlasticName\":\"PrePaid\"},{\"Value\":{\"Indicator\":\"true\"},\"_PlasticName\":\"CashRebate\"},{\"Value\":{\"Indicator\":\"false\"},\"_PlasticName\":\"Metropolis\"},{\"Value\":{\"Indicator\":\"true\"},\"_PlasticName\":\"CoBrandCard\"},{\"Value\":{\"Indicator\":\"false\"},\"_PlasticName\":\"KnotCard\"},{\"Value\":{\"Indicator\":\"false\"},\"_PlasticName\":\"GumbyCard\"},{\"Value\":{\"Indicator\":\"true\"},\"_PlasticName\":\"ConsumerCard\"}],\"CoBrandType\":{\"_cobrandName\":\"Costco\"},\"ProductTypeCD\":\"41\"},\"ProductID\":\"JTU\",\"ProductCD\":\"161\",\"SEGenesisProductCD\":\"4500\",\"CardEligibility\":[{\"Value\":{\"Indicator\":\"true\"},\"_EligibilityName\":\"CheckEligible\"},{\"Value\":{\"Indicator\":\"false\"},\"_EligibilityName\":\"MandatoryAutoPayEligible\"},{\"Value\":{\"Indicator\":\"false\"},\"_EligibilityName\":\"AutomatedClearingHouseEligible\"},{\"Value\":{\"Indicator\":\"true\"},\"_EligibilityName\":\"OnlineDisputesEligible\"},{\"Value\":{\"Indicator\":\"false\"},\"_EligibilityName\":\"ExpoEnrollmentEligible\"},{\"Value\":{\"Indicator\":\"true\"},\"_EligibilityName\":\"PrivatePaymentsEligible\"},{\"Value\":{\"Indicator\":\"false\"},\"_EligibilityName\":\"SignAndTravelTransferEligible\"},{\"Value\":{\"Indicator\":\"false\"},\"_EligibilityName\":\"UnbilledDisputesEligible\"},{\"Value\":{\"Indicator\":\"true\"},\"_EligibilityName\":\"SelfSelectReallocationEligible\"},{\"Value\":{\"Indicator\":\"true\"},\"_EligibilityName\":\"YearEndSummaryEligible\"},{\"Value\":{\"Indicator\":\"false\"},\"_EligibilityName\":\"ExpoTransferEligible\"},{\"Value\":{\"Indicator\":\"true\"},\"_EligibilityName\":\"PayByPCEligible\"},{\"Value\":{\"Indicator\":\"false\"},\"_EligibilityName\":\"GraceTermRejectionIndicator\"},{\"Value\":{\"Indicator\":\"true\"},\"_EligibilityName\":\"BalanceTransferEligible\"},{\"Value\":{\"Indicator\":\"true\"},\"_EligibilityName\":\"LineOfCreditEligible\"},{\"Value\":{\"Indicator\":\"true\"},\"_EligibilityName\":\"GlobalLimitOnSuppsEligible\"},{\"Value\":{\"Indicator\":\"true\"},\"_EligibilityName\":\"PaperCopyEligible\"},{\"Value\":{\"Indicator\":\"false\"},\"_EligibilityName\":\"FlexSelectEligible\"},{\"Value\":{\"Indicator\":\"false\"},\"_EligibilityName\":\"SignAndTravelEnrollmentEligible\"}],\"CardFeatures\":{\"LoyaltyIN\":{\"Indicator\":\"false\"},\"AefaIN\":\"false\",\"PlasticIN\":{\"ElementMetaData\":{\"_notAvailableIN\":\"true\"}},\"LegalLoyaltyProgram\":{\"loyaltyTierCode\":\"CT\",\"loyaltyLegalProgramName\":\"Costco Cash Back\"}}},\"CardLocaleFragment\":{\"AmexRgnNM\":\"US\",\"MarketNM\":\"UnitedStates\",\"LocalizationPreferences\":{\"LocalizationID\":\"en_US\",\"LanguagePreference\":\"\",\"HomeCountryLocale\":\"en_US\",\"CurrencyLocale\":\"en_US\",\"DateLocale\":\"en_US\"}},\"HiddenDataFragment\":{\"SystemPlatform\":{\"TriumphIN\":\"true\"},\"ConversionStatusCD\":\"originalTriumph\"},\"_basicIN\":\"true\",\"_suppsNO\":\"0\"}}}");
    }
    
   public ApplicationController getApplicationController(String name)
   {
	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
	return (ApplicationController) wac.getBean(name);
   }

}
