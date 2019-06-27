package com.app.distance2.directionhelpers;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Vishal on 10/20/2018.
 */

public class PointsParser extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {
    TaskLoadedCallback taskCallback;
    String directionMode = "driving";
    Context mContext;
    public PointsParser(Context mContext, String directionMode) {
        this.mContext=mContext;
        this.taskCallback = (TaskLoadedCallback) mContext;
        this.directionMode = directionMode;
    }

    // Parsing the data in non-ui thread
    @Override
    protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

        JSONObject jObject;
        List<List<HashMap<String, String>>> routes = null;

        try {
            //JSONArray jsonArray=new JSONArray(jsonData[0]);
            //jObject=new JSONObject(jsonData[0]);
            jObject = new JSONObject("{\n" +
                    "   \"geocoded_waypoints\" : [\n" +
                    "      {\n" +
                    "         \"geocoder_status\" : \"OK\",\n" +
                    "         \"place_id\" : \"ChIJ2dBj6eG7BTsRqDVZLh8Vf4I\",\n" +
                    "         \"types\" : [ \"route\" ]\n" +
                    "      },\n" +
                    "      {\n" +
                    "         \"geocoder_status\" : \"OK\",\n" +
                    "         \"place_id\" : \"ChIJ1x-gpKm_BTsR8W7f0THarwE\",\n" +
                    "         \"types\" : [\n" +
                    "            \"bus_station\",\n" +
                    "            \"establishment\",\n" +
                    "            \"point_of_interest\",\n" +
                    "            \"transit_station\"\n" +
                    "         ]\n" +
                    "      },\n" +
                    "      {\n" +
                    "         \"geocoder_status\" : \"OK\",\n" +
                    "         \"place_id\" : \"ChIJnbY-5nW8BTsRZCENSp0P0qc\",\n" +
                    "         \"types\" : [ \"car_wash\", \"establishment\", \"point_of_interest\" ]\n" +
                    "      },\n" +
                    "      {\n" +
                    "         \"geocoder_status\" : \"OK\",\n" +
                    "         \"place_id\" : \"ChIJ0eQSAhG8BTsRank-Dfy1cOc\",\n" +
                    "         \"types\" : [ \"route\" ]\n" +
                    "      },\n" +
                    "      {\n" +
                    "         \"geocoder_status\" : \"OK\",\n" +
                    "         \"place_id\" : \"ChIJ0eQSAhG8BTsRank-Dfy1cOc\",\n" +
                    "         \"types\" : [ \"route\" ]\n" +
                    "      },\n" +
                    "      {\n" +
                    "         \"geocoder_status\" : \"OK\",\n" +
                    "         \"place_id\" : \"ChIJc9-MwLi7BTsR5soJQ2x3Uwg\",\n" +
                    "         \"types\" : [ \"establishment\", \"point_of_interest\" ]\n" +
                    "      }\n" +
                    "   ],\n" +
                    "   \"routes\" : [\n" +
                    "      {\n" +
                    "         \"bounds\" : {\n" +
                    "            \"northeast\" : {\n" +
                    "               \"lat\" : 8.5941566,\n" +
                    "               \"lng\" : 76.9485608\n" +
                    "            },\n" +
                    "            \"southwest\" : {\n" +
                    "               \"lat\" : 8.492153699999999,\n" +
                    "               \"lng\" : 76.863338\n" +
                    "            }\n" +
                    "         },\n" +
                    "         \"copyrights\" : \"Map data ©2019\",\n" +
                    "         \"legs\" : [\n" +
                    "            {\n" +
                    "               \"distance\" : {\n" +
                    "                  \"text\" : \"16.3 km\",\n" +
                    "                  \"value\" : 16274\n" +
                    "               },\n" +
                    "               \"duration\" : {\n" +
                    "                  \"text\" : \"31 mins\",\n" +
                    "                  \"value\" : 1849\n" +
                    "               },\n" +
                    "               \"end_address\" : \"Chakkai Jn, Kazhakuttam, Vadakkumbhagam, Thiruvananthapuram, Kerala 695301, India\",\n" +
                    "               \"end_location\" : {\n" +
                    "                  \"lat\" : 8.572974199999999,\n" +
                    "                  \"lng\" : 76.8698211\n" +
                    "               },\n" +
                    "               \"start_address\" : \"Unnamed Road, Vivekanand Nagar, Kesavadasapuram, Thiruvananthapuram, Kerala 695004, India\",\n" +
                    "               \"start_location\" : {\n" +
                    "                  \"lat\" : 8.5241396,\n" +
                    "                  \"lng\" : 76.936635\n" +
                    "               },\n" +
                    "               \"steps\" : [\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"12 m\",\n" +
                    "                        \"value\" : 12\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"1 min\",\n" +
                    "                        \"value\" : 3\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.5242436,\n" +
                    "                        \"lng\" : 76.9366574\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Head \\u003cb\\u003enorth\\u003c/b\\u003e toward \\u003cb\\u003eLane E\\u003c/b\\u003e\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"{z_s@_uqtMSC\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.5241396,\n" +
                    "                        \"lng\" : 76.936635\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"26 m\",\n" +
                    "                        \"value\" : 26\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"1 min\",\n" +
                    "                        \"value\" : 10\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.524346699999999,\n" +
                    "                        \"lng\" : 76.9364468\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Turn \\u003cb\\u003eleft\\u003c/b\\u003e at Home Away Home Kerala onto \\u003cb\\u003eLane E\\u003c/b\\u003e\",\n" +
                    "                     \"maneuver\" : \"turn-left\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"o{_s@cuqtMENCHEHED\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.5242436,\n" +
                    "                        \"lng\" : 76.9366574\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"0.6 km\",\n" +
                    "                        \"value\" : 603\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"2 mins\",\n" +
                    "                        \"value\" : 128\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.529454299999999,\n" +
                    "                        \"lng\" : 76.9360726\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Turn \\u003cb\\u003eright\\u003c/b\\u003e at JANVIKAS KENDRA onto \\u003cb\\u003eAishwariya Nagar\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by Sk Gold Valves (on the right)\\u003c/div\\u003e\",\n" +
                    "                     \"maneuver\" : \"turn-right\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"e|_s@ysqtMGBMDODSHMDEBE@a@LQDA??@?@?@DV?@A@A@gA@eABC?AAA?C?AAAAAA?AA?AAA?A?AAA?A?}AGSAWAU?MAQAMAw@EA?k@?[Ai@@U@I?E?EAGAEAGCCCCAAAA?AAC?E?Q@y@FeDT\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.524346699999999,\n" +
                    "                        \"lng\" : 76.9364468\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"3.6 km\",\n" +
                    "                        \"value\" : 3554\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"8 mins\",\n" +
                    "                        \"value\" : 476\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.5488707,\n" +
                    "                        \"lng\" : 76.91725679999999\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Turn \\u003cb\\u003eleft\\u003c/b\\u003e at Thomson Sofas onto \\u003cb\\u003eKesavadasapuram-Ulloor Rd\\u003c/b\\u003e/\\u003cb\\u003eUlloor Rd\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by CORDIAL EMERALD (on the left)\\u003c/div\\u003e\",\n" +
                    "                     \"maneuver\" : \"turn-left\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"a|`s@mqqtMDZXtAZjAj@pBDh@FzABL@F@F?D@R?L?H?DAH?FCLCLCHCBEFCDe@f@[`@STEHGLGLSf@Eb@I\\\\A@?@CfAAR?T?XA?@`@@N?N?T?B@V@X?\\\\Ab@G~@EXE`@UlAAFAHCH?JCPm@?g@@i@B}JSKAM@C?G?M@M?G@G@I@OB[NE@C@OFGBCBQJgBhAWNC@MD_@Pw@h@m@b@q@j@g@^KHKFSJa@Rs@Ze@Pg@P[JkAXe@Je@Jq@LSFC?}@VeBl@g@TQF_Bt@u@^q@d@e@f@WXe@j@]VWRe@VOHQJy@\\\\uAp@mAh@e@R}Ap@u@`@UNcBp@A@cA^g@Ng@PgCdAyAb@KBi@JE@g@BS@W?QAYA[E[E[Cc@Ea@CSAO@S@MBMBMHMHSRIVO^KXADi@|AQl@M^AHAJEd@A\\\\?RFb@N~@@T@N?J?LCPCHADIZ?@M`@M\\\\K\\\\CFEP[pAIRMj@\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.529454299999999,\n" +
                    "                        \"lng\" : 76.9360726\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"3.8 km\",\n" +
                    "                        \"value\" : 3793\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"6 mins\",\n" +
                    "                        \"value\" : 372\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.5666332,\n" +
                    "                        \"lng\" : 76.89099569999999\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"At \\u003cb\\u003eSreekaryam Jct\\u003c/b\\u003e, continue onto \\u003cb\\u003eAakkulam Rd\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by Nash Communications (on the left)\\u003c/div\\u003e\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"muds@{{mtM@t@CvB?BAPCJAHCHAFCFIRGNUr@CHADK^[fAUt@]x@MPGF]b@e@h@e@j@{@jAW`@IRCJCHCLAFAJETGbAAJCb@C`@CzAAr@A^ARALANCPCLCJGPKTIRGHm@bA}@zAA?Q^ITIXETMt@Il@Kf@M`@c@`BI`@Of@WbAO^ADM`@O`@CDcA~AgAjBWd@QZKPKNSTGHQPe@b@o@f@i@d@OLMHOHKFMDSFMDg@JcAVSHA@QFYJuAj@OFeB|@u@\\\\iAh@YN[Li@Vi@R[LSDKBM@}@JUB[BSDKBKDIDA@EBABEBGDKJEFGHEFO\\\\GLGJIJGHEBIDKDQHOHGBKHIHIJKLELCDEJCLCJCL?L?H@L@NBRHX\\\\vA@FDTBT@V@pABt@@`A?n@CREXGXqAzEK`@Wx@IVELYl@U^QRSN]V]R[Ni@Ty@X_@PeBr@k@V_A^s@XMDOHOJWRIFa@Z_@^g@j@wAhBKNk@x@KPUXm@`Ao@hA\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.5488707,\n" +
                    "                        \"lng\" : 76.91725679999999\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"1.5 km\",\n" +
                    "                        \"value\" : 1526\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"3 mins\",\n" +
                    "                        \"value\" : 175\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.578225099999999,\n" +
                    "                        \"lng\" : 76.89459839999999\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Turn \\u003cb\\u003eright\\u003c/b\\u003e at \\u003cb\\u003eKaryavattom Jct\\u003c/b\\u003e onto \\u003cb\\u003eKariyavattom - Chenkottukonam Rd\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by Suguna - Daily Fresh (on the left)\\u003c/div\\u003e\",\n" +
                    "                     \"maneuver\" : \"turn-right\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"mdhs@wwhtMKCEAE?G?GB]Nc@Ra@RQHODUBk@B_AHs@FcAF_@@S@YBa@FWD[BcAJy@HI@w@H}EJu@DsAEa@EMAcAIi@CwACWAOAOCs@Sg@[i@Yc@Os@Q]QSUEOg@kACEe@mASk@sAkB[u@CCc@m@e@_@MIk@e@e@e@o@iAEG][IGIEYOUKOIG?c@A\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.5666332,\n" +
                    "                        \"lng\" : 76.89099569999999\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"0.4 km\",\n" +
                    "                        \"value\" : 408\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"1 min\",\n" +
                    "                        \"value\" : 53\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.5818353,\n" +
                    "                        \"lng\" : 76.8943242\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Continue straight through \\u003cb\\u003ePullanivila Junction\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by Nirbhaya Institute For Human Development (on the left)\\u003c/div\\u003e\",\n" +
                    "                     \"maneuver\" : \"straight\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"}ljs@gnitMSBQ@aALa@La@HM@o@FQ?i@Gq@K[Ec@CEAY?sAFo@BsBNM@SB\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.578225099999999,\n" +
                    "                        \"lng\" : 76.89459839999999\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"1.1 km\",\n" +
                    "                        \"value\" : 1089\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"2 mins\",\n" +
                    "                        \"value\" : 108\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.5901292,\n" +
                    "                        \"lng\" : 76.89341800000001\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Turn \\u003cb\\u003eleft\\u003c/b\\u003e at \\u003cb\\u003ePullanivila Fifth Ave\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by Vaiga Store (on the left in 900&nbsp;m)\\u003c/div\\u003e\",\n" +
                    "                     \"maneuver\" : \"turn-left\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"ocks@olitME@CDCFENAPCTCVCTITMTOPONMJQLSLEDSLUPUJYHUDOHMFSLUXMVKJMHm@Pm@V]P_@LYHO@O?K@qA@{ANo@Bc@?UAOCSGWI_CcA_@M]K_D_BGAe@KA?aAWe@QqAi@m@M_@G{@A\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.5818353,\n" +
                    "                        \"lng\" : 76.8943242\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"0.9 km\",\n" +
                    "                        \"value\" : 882\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"2 mins\",\n" +
                    "                        \"value\" : 147\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.5941566,\n" +
                    "                        \"lng\" : 76.8878521\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Turn \\u003cb\\u003eleft\\u003c/b\\u003e at Two wheeler workshop onto \\u003cb\\u003eAnnoor Rd\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by Tureds (on the right)\\u003c/div\\u003e\",\n" +
                    "                     \"maneuver\" : \"turn-left\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"iwls@{fitMAHAJALEPCLCHEPCLCLAHAJCHCLELGNGLADEHITOVEPEJEHEHIHCDCBC@CBEBKFGHIPKVOb@Qh@GTADAB?D@D@B?@@D@BAF?@EJITKZQl@IXKZIZCLEHAFEFA@ENIVGPELCFGHKRETGVCNGNIRENCD?@ADABC?A?E?EAIAGAC?E?EBCDGDE@G@GAE?IAIAWKe@OYIYKQGGAIAG?E@GBCBOTMXOZIRKNGF\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.5901292,\n" +
                    "                        \"lng\" : 76.89341800000001\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"3.1 km\",\n" +
                    "                        \"value\" : 3138\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"4 mins\",\n" +
                    "                        \"value\" : 249\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.5820893,\n" +
                    "                        \"lng\" : 76.863338\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Turn \\u003cb\\u003eleft\\u003c/b\\u003e at Soulmate Textiles onto \\u003cb\\u003eKazhakoottam - Kilimanoor Rd\\u003c/b\\u003e/\\u003cb\\u003eKazhakoottam - Thaikod Rd\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by Devi Tyre Repairing Shop (on the left)\\u003c/div\\u003e\",\n" +
                    "                     \"maneuver\" : \"turn-left\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"opms@adhtMBBJPPb@Rj@L\\\\DLLZHPRj@N\\\\N`@|@zBh@vA?@Xv@Pd@P^Vl@b@t@Zh@n@|@JLZ`@@Bf@j@Z^\\\\Zh@d@x@r@BB`@\\\\`@^`@b@\\\\^b@j@PZLVHXDLBNBV@H@L?\\\\@d@@ZBTDXFPFVFLBFVf@FLLTT\\\\V\\\\Z\\\\XZ~ApAj@h@^Z|@r@b@`@JPDH@H@F?PEf@Cb@IvA?LALAJCh@AVCd@Al@GrA?\\\\?XC|@?\\\\AX?t@A\\\\@`@?N?J@b@@V@NBV@J@NDVDPNx@FTHTVv@b@dAZl@h@|@l@|@T\\\\f@n@v@dALPRVJNlA`B^h@TZV\\\\FFdAvAJLZh@DLFNHVBZ@L?X@Z?VHn@BZBTD\\\\DRDRHVHRHT`@x@n@lAVj@vC|F\\\\p@\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.5941566,\n" +
                    "                        \"lng\" : 76.8878521\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"1.2 km\",\n" +
                    "                        \"value\" : 1243\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"2 mins\",\n" +
                    "                        \"value\" : 128\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.572974199999999,\n" +
                    "                        \"lng\" : 76.8698211\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Turn \\u003cb\\u003eleft\\u003c/b\\u003e at Anashawara Fashion Jewelleary onto \\u003cb\\u003eNH 66\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by Kottakkal Arya Vaidya Sala Kottakkal, kazhakkoottom Branch (on the left)\\u003c/div\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003eDestination will be on the left\\u003c/div\\u003e\",\n" +
                    "                     \"maneuver\" : \"turn-left\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"aeks@{jctMn@e@NMd@[`@URMdAk@fC_Bj@a@r@e@hAy@nDsChAy@vEmDrCwB`BmAdAu@r@e@d@WPIZOr@[DAb@UvAq@j@U`@ONGj@Qh@QJE\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.5820893,\n" +
                    "                        \"lng\" : 76.863338\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  }\n" +
                    "               ],\n" +
                    "               \"traffic_speed_entry\" : [],\n" +
                    "               \"via_waypoint\" : []\n" +
                    "            },\n" +
                    "            {\n" +
                    "               \"distance\" : {\n" +
                    "                  \"text\" : \"10.3 km\",\n" +
                    "                  \"value\" : 10341\n" +
                    "               },\n" +
                    "               \"duration\" : {\n" +
                    "                  \"text\" : \"16 mins\",\n" +
                    "                  \"value\" : 987\n" +
                    "               },\n" +
                    "               \"end_address\" : \"TC 92/2034-3, NH Bypass Road, Chackai,Near BMW Showroom, Thiruvananthapuram, Kerala 695029, India\",\n" +
                    "               \"end_location\" : {\n" +
                    "                  \"lat\" : 8.4977982,\n" +
                    "                  \"lng\" : 76.91690059999999\n" +
                    "               },\n" +
                    "               \"start_address\" : \"Chakkai Jn, Kazhakuttam, Vadakkumbhagam, Thiruvananthapuram, Kerala 695301, India\",\n" +
                    "               \"start_location\" : {\n" +
                    "                  \"lat\" : 8.572974199999999,\n" +
                    "                  \"lng\" : 76.8698211\n" +
                    "               },\n" +
                    "               \"steps\" : [\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"0.9 km\",\n" +
                    "                        \"value\" : 938\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"2 mins\",\n" +
                    "                        \"value\" : 114\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.566123600000001,\n" +
                    "                        \"lng\" : 76.8747539\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Head \\u003cb\\u003esoutheast\\u003c/b\\u003e on \\u003cb\\u003eNH 66\\u003c/b\\u003e toward \\u003cb\\u003ePolice Station-Menamkula Rd Bypass\\u003c/b\\u003e\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"alis@ksdtMd@Sl@Yf@Yn@_@PIh@]j@_@ZUZU`@[`@]d@_@d@a@d@_@nB}A@AbAcAl@a@tA_Av@e@XQvBoALIr@[dCmAj@a@n@a@h@YDA\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.572974199999999,\n" +
                    "                        \"lng\" : 76.8698211\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"68 m\",\n" +
                    "                        \"value\" : 68\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"1 min\",\n" +
                    "                        \"value\" : 9\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.5656591,\n" +
                    "                        \"lng\" : 76.87514229999999\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Slight \\u003cb\\u003eleft\\u003c/b\\u003e toward \\u003cb\\u003eNH 66\\u003c/b\\u003e\",\n" +
                    "                     \"maneuver\" : \"turn-slight-left\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"gahs@eretMJSHKx@e@JG\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.566123600000001,\n" +
                    "                        \"lng\" : 76.8747539\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"24 m\",\n" +
                    "                        \"value\" : 24\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"1 min\",\n" +
                    "                        \"value\" : 4\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.56546,\n" +
                    "                        \"lng\" : 76.87522609999999\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Slight \\u003cb\\u003eright\\u003c/b\\u003e toward \\u003cb\\u003eNH 66\\u003c/b\\u003e\",\n" +
                    "                     \"maneuver\" : \"turn-slight-right\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"k~gs@stetMf@Q\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.5656591,\n" +
                    "                        \"lng\" : 76.87514229999999\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"0.9 km\",\n" +
                    "                        \"value\" : 880\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"1 min\",\n" +
                    "                        \"value\" : 78\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.5578164,\n" +
                    "                        \"lng\" : 76.8763895\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Keep \\u003cb\\u003eright\\u003c/b\\u003e to continue on \\u003cb\\u003eNH 66\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003eParts of this road may be closed at certain times or days\\u003c/div\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by Canara Bank ATM (on the left)\\u003c/div\\u003e\",\n" +
                    "                     \"maneuver\" : \"keep-right\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"c}gs@euetMZM@Nf@Ux@a@NIXM|@_@\\\\MF?j@KZCZE`HYxAGhCIdDMrDI^AF?tCGdAE`@A\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.56546,\n" +
                    "                        \"lng\" : 76.87522609999999\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"11 m\",\n" +
                    "                        \"value\" : 11\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"1 min\",\n" +
                    "                        \"value\" : 3\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.5578275,\n" +
                    "                        \"lng\" : 76.8764881\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Turn \\u003cb\\u003eleft\\u003c/b\\u003e at the 1st cross street onto \\u003cb\\u003eTechnopark Rd\\u003c/b\\u003e\",\n" +
                    "                     \"maneuver\" : \"turn-left\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"kmfs@m|etMAS\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.5578164,\n" +
                    "                        \"lng\" : 76.8763895\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"0.8 km\",\n" +
                    "                        \"value\" : 793\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"2 mins\",\n" +
                    "                        \"value\" : 111\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.5507262,\n" +
                    "                        \"lng\" : 76.87710539999999\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Turn \\u003cb\\u003eright\\u003c/b\\u003e at the 1st cross street onto \\u003cb\\u003eService Rd\\u003c/b\\u003e\",\n" +
                    "                     \"maneuver\" : \"turn-right\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"mmfs@a}etMVCh@A|FQ`EQvBGhBIlCMvBMt@ER?\\\\C\\\\Av@Ex@El@C\\\\A`ACZA\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.5578275,\n" +
                    "                        \"lng\" : 76.8764881\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"12 m\",\n" +
                    "                        \"value\" : 12\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"1 min\",\n" +
                    "                        \"value\" : 6\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.550720399999999,\n" +
                    "                        \"lng\" : 76.8769935\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Turn \\u003cb\\u003eright\\u003c/b\\u003e at \\u003cb\\u003eAttinkuzhy Rd\\u003c/b\\u003e/\\u003cb\\u003eKallingal Rd\\u003c/b\\u003e\",\n" +
                    "                     \"maneuver\" : \"turn-right\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"aaes@}`ftM@V\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.5507262,\n" +
                    "                        \"lng\" : 76.87710539999999\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"6.4 km\",\n" +
                    "                        \"value\" : 6426\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"9 mins\",\n" +
                    "                        \"value\" : 519\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.5053277,\n" +
                    "                        \"lng\" : 76.90958169999999\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Turn \\u003cb\\u003eleft\\u003c/b\\u003e at the 1st cross street onto \\u003cb\\u003eNH 66\\u003c/b\\u003e\",\n" +
                    "                     \"maneuver\" : \"turn-left\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"_aes@e`ftMbCGjEIrEGtDGvBEnACdHE~@AvJIBAxBEd@At@Ev@Gb@Gx@OBAZG`@Kt@WTIbAe@tA{@vCsBx@i@rCiBnMiIFGhBkAf@[`@Y~AcAlFkD\\\\WnDoCxAqAtBmB^]^]v@}@r@u@zCyCzGuGtEgE`CyBlBgBr@u@r@u@r@u@nAuA`D}Cr@q@hEqDdA{@rGuFNMhCwB`DkC|CkC`DuCnK_JxBmBlAiAdK_JfD{CpAmAHGf@i@~@_AV[@?X]zAiBtEsFvCeEdB}BRWbA}AVc@`ByBp@}@r@{@LQ\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.550720399999999,\n" +
                    "                        \"lng\" : 76.8769935\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"1.2 km\",\n" +
                    "                        \"value\" : 1189\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"2 mins\",\n" +
                    "                        \"value\" : 143\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.4977982,\n" +
                    "                        \"lng\" : 76.91690059999999\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Continue straight\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by Maruti Driving School (on the left)\\u003c/div\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003eDestination will be on the left\\u003c/div\\u003e\",\n" +
                    "                     \"maneuver\" : \"straight\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"ie|r@{kltMLL@DJL`@c@tAcBjAmAxCsChBmBbBkBl@o@|E{E~@aA`AaAd@g@dAgA`@a@`@a@t@q@zDqDhBmB\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.5053277,\n" +
                    "                        \"lng\" : 76.90958169999999\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  }\n" +
                    "               ],\n" +
                    "               \"traffic_speed_entry\" : [],\n" +
                    "               \"via_waypoint\" : []\n" +
                    "            },\n" +
                    "            {\n" +
                    "               \"distance\" : {\n" +
                    "                  \"text\" : \"2.0 km\",\n" +
                    "                  \"value\" : 2023\n" +
                    "               },\n" +
                    "               \"duration\" : {\n" +
                    "                  \"text\" : \"3 mins\",\n" +
                    "                  \"value\" : 183\n" +
                    "               },\n" +
                    "               \"end_address\" : \"Kazhakootam - Kovalam Bypass Road, Oruvathilkotta, Kochuveli, Thiruvananthapuram, Kerala 695021, India\",\n" +
                    "               \"end_location\" : {\n" +
                    "                  \"lat\" : 8.510139299999999,\n" +
                    "                  \"lng\" : 76.9036294\n" +
                    "               },\n" +
                    "               \"start_address\" : \"TC 92/2034-3, NH Bypass Road, Chackai,Near BMW Showroom, Thiruvananthapuram, Kerala 695029, India\",\n" +
                    "               \"start_location\" : {\n" +
                    "                  \"lat\" : 8.4977982,\n" +
                    "                  \"lng\" : 76.91690059999999\n" +
                    "               },\n" +
                    "               \"steps\" : [\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"1.2 km\",\n" +
                    "                        \"value\" : 1165\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"2 mins\",\n" +
                    "                        \"value\" : 127\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.5051924,\n" +
                    "                        \"lng\" : 76.9094058\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Head \\u003cb\\u003enorthwest\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by A2Z Driving Practice Centere (on the left)\\u003c/div\\u003e\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"gvzr@symtMiBlB{DpDu@p@a@`@a@`@eAfAe@f@aA`A_A`A}EzEm@n@cBjBiBlByCrCkAlAuAbBa@b@\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.4977982,\n" +
                    "                        \"lng\" : 76.91690059999999\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"0.9 km\",\n" +
                    "                        \"value\" : 858\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"1 min\",\n" +
                    "                        \"value\" : 56\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.510139299999999,\n" +
                    "                        \"lng\" : 76.9036294\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Keep \\u003cb\\u003eright\\u003c/b\\u003e to continue on \\u003cb\\u003eNH 66\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by the gas station (on the right)\\u003c/div\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003eDestination will be on the left\\u003c/div\\u003e\",\n" +
                    "                     \"maneuver\" : \"keep-right\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"md|r@yjltMKMAEMNs@z@o@z@aBxBYd@cAzASXW^EDgAvA_AvA}@pAe@l@}@fAcAjA}@bAIJGFIHUVg@j@QRYVUTc@f@\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.5051924,\n" +
                    "                        \"lng\" : 76.9094058\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  }\n" +
                    "               ],\n" +
                    "               \"traffic_speed_entry\" : [],\n" +
                    "               \"via_waypoint\" : []\n" +
                    "            },\n" +
                    "            {\n" +
                    "               \"distance\" : {\n" +
                    "                  \"text\" : \"1.3 km\",\n" +
                    "                  \"value\" : 1252\n" +
                    "               },\n" +
                    "               \"duration\" : {\n" +
                    "                  \"text\" : \"2 mins\",\n" +
                    "                  \"value\" : 127\n" +
                    "               },\n" +
                    "               \"end_address\" : \"Kazhakootam - Kovalam Bypass Road, Oruvathilkotta, Kochuveli, Thiruvananthapuram, Kerala 695021, India\",\n" +
                    "               \"end_location\" : {\n" +
                    "                  \"lat\" : 8.510056499999999,\n" +
                    "                  \"lng\" : 76.9035502\n" +
                    "               },\n" +
                    "               \"start_address\" : \"Kazhakootam - Kovalam Bypass Road, Oruvathilkotta, Kochuveli, Thiruvananthapuram, Kerala 695021, India\",\n" +
                    "               \"start_location\" : {\n" +
                    "                  \"lat\" : 8.510139299999999,\n" +
                    "                  \"lng\" : 76.9036294\n" +
                    "               },\n" +
                    "               \"steps\" : [\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"0.5 km\",\n" +
                    "                        \"value\" : 544\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"1 min\",\n" +
                    "                        \"value\" : 33\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.5137248,\n" +
                    "                        \"lng\" : 76.9002618\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Head \\u003cb\\u003enorthwest\\u003c/b\\u003e on \\u003cb\\u003eNH 66\\u003c/b\\u003e\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"kc}r@ufktMMLo@v@KJ_B|AaGjF_FhE_Az@\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.510139299999999,\n" +
                    "                        \"lng\" : 76.9036294\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"0.6 km\",\n" +
                    "                        \"value\" : 614\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"1 min\",\n" +
                    "                        \"value\" : 72\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.509972700000001,\n" +
                    "                        \"lng\" : 76.90406\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Sharp \\u003cb\\u003eright\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by The Tamara Hotel (on the left)\\u003c/div\\u003e\",\n" +
                    "                     \"maneuver\" : \"turn-sharp-right\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"wy}r@sqjtMMOOOVUJIhB_BZ[ZYhA}@xAqAzAsAv@q@x@w@z@w@XY`@c@p@s@h@i@\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.5137248,\n" +
                    "                        \"lng\" : 76.9002618\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"39 m\",\n" +
                    "                        \"value\" : 39\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"1 min\",\n" +
                    "                        \"value\" : 13\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.509714299999999,\n" +
                    "                        \"lng\" : 76.9039051\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Turn \\u003cb\\u003eright\\u003c/b\\u003e onto \\u003cb\\u003ePettah - Venpalavattom Rd\\u003c/b\\u003e/\\u003cb\\u003eVeli Venpalavattom Rd\\u003c/b\\u003e\",\n" +
                    "                     \"maneuver\" : \"turn-right\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"ib}r@kiktMHGh@d@\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.509972700000001,\n" +
                    "                        \"lng\" : 76.90406\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"55 m\",\n" +
                    "                        \"value\" : 55\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"1 min\",\n" +
                    "                        \"value\" : 9\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.510056499999999,\n" +
                    "                        \"lng\" : 76.9035502\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Turn \\u003cb\\u003eright\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003eDestination will be on the right\\u003c/div\\u003e\",\n" +
                    "                     \"maneuver\" : \"turn-right\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"u`}r@mhktMKJy@z@\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.509714299999999,\n" +
                    "                        \"lng\" : 76.9039051\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  }\n" +
                    "               ],\n" +
                    "               \"traffic_speed_entry\" : [],\n" +
                    "               \"via_waypoint\" : []\n" +
                    "            },\n" +
                    "            {\n" +
                    "               \"distance\" : {\n" +
                    "                  \"text\" : \"7.5 km\",\n" +
                    "                  \"value\" : 7510\n" +
                    "               },\n" +
                    "               \"duration\" : {\n" +
                    "                  \"text\" : \"15 mins\",\n" +
                    "                  \"value\" : 885\n" +
                    "               },\n" +
                    "               \"end_address\" : \"UNIVERSITY COLLEGE, Palayam - Airport Rd, University of Kerala Senate House Campus, Palayam, Thiruvananthapuram, Kerala 695034, India\",\n" +
                    "               \"end_location\" : {\n" +
                    "                  \"lat\" : 8.5025625,\n" +
                    "                  \"lng\" : 76.9479391\n" +
                    "               },\n" +
                    "               \"start_address\" : \"Kazhakootam - Kovalam Bypass Road, Oruvathilkotta, Kochuveli, Thiruvananthapuram, Kerala 695021, India\",\n" +
                    "               \"start_location\" : {\n" +
                    "                  \"lat\" : 8.510056499999999,\n" +
                    "                  \"lng\" : 76.9035502\n" +
                    "               },\n" +
                    "               \"steps\" : [\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"0.5 km\",\n" +
                    "                        \"value\" : 544\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"1 min\",\n" +
                    "                        \"value\" : 58\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.5136603,\n" +
                    "                        \"lng\" : 76.90020079999999\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Head \\u003cb\\u003enorthwest\\u003c/b\\u003e toward \\u003cb\\u003eWorld Market Rd\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by Agricultural Wholesale Market (on the left)\\u003c/div\\u003e\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"{b}r@efktMwCxCED_DpC_@\\\\iDxCi@d@q@l@u@n@e@`@OL\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.510056499999999,\n" +
                    "                        \"lng\" : 76.9035502\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"3.5 km\",\n" +
                    "                        \"value\" : 3488\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"5 mins\",\n" +
                    "                        \"value\" : 308\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.492153699999999,\n" +
                    "                        \"lng\" : 76.922957\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Sharp \\u003cb\\u003eright\\u003c/b\\u003e onto \\u003cb\\u003eNH 66\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by the bridge (on the right in 600&nbsp;m)\\u003c/div\\u003e\",\n" +
                    "                     \"maneuver\" : \"turn-sharp-right\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"ky}r@gqjtMKKMOdK_JfD{CpAmAHGf@i@~@_AV[@?X]zAiBtEsFvCeEdB}BRWbA}AVc@`ByBp@}@r@{@LQv@aAh@q@|BcCtCqC~@_AbDiDfAgA^]zB{BbBaBDCt@w@dBiBRKFGZc@ZW`B_BTUlAgAJKFIXYvAsAJKnBoBz@{@b@c@jCmCj@k@^_@h@k@z@{@POPS`@a@lAkABElAgA`A_AVWHGHIFI@?DELMJORSN]NSp@w@z@}@XYRW\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.5136603,\n" +
                    "                        \"lng\" : 76.90020079999999\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"3.3 km\",\n" +
                    "                        \"value\" : 3268\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"8 mins\",\n" +
                    "                        \"value\" : 482\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.5034159,\n" +
                    "                        \"lng\" : 76.9482264\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"Turn \\u003cb\\u003eleft\\u003c/b\\u003e at Food Bowl onto \\u003cb\\u003ePalayam - Airport Rd\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by Chackai Bus Stop (on the left)\\u003c/div\\u003e\",\n" +
                    "                     \"maneuver\" : \"turn-left\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"}ryr@o_otMU}@Mc@Yy@c@eAc@aAk@oAk@uAg@sAk@oAOe@EMIe@E]G[Mi@WmAUq@Su@s@qBM_@MWy@gBIQ?KOYYa@[_@a@c@QSSUWYOQOUKMIMEKGKEKEMIWGWCMAQIUCUACAOC[C_@Gm@Gc@G[Mm@G[I[G[AQESAM?IAU?Y?USaBS}AY{AGYo@gFCOCIAKEOEQG[GWGQO_@KUEIG[AMA?GGEGIEQMMIsAo@i@QWG[E[CWCUGMGGIEMEWAO@M?KBK@IHUDUJ[DQDc@HmAJ}AJ{BBqA@m@?a@AYEw@AMS}BAKCiAEi@COGMIM_@e@M_@wA_Ea@aA}BeGQa@U]CCCCMIOIQGiDu@mBy@c@OYGQEQC\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.492153699999999,\n" +
                    "                        \"lng\" : 76.922957\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  },\n" +
                    "                  {\n" +
                    "                     \"distance\" : {\n" +
                    "                        \"text\" : \"0.2 km\",\n" +
                    "                        \"value\" : 210\n" +
                    "                     },\n" +
                    "                     \"duration\" : {\n" +
                    "                        \"text\" : \"1 min\",\n" +
                    "                        \"value\" : 37\n" +
                    "                     },\n" +
                    "                     \"end_location\" : {\n" +
                    "                        \"lat\" : 8.5025625,\n" +
                    "                        \"lng\" : 76.9479391\n" +
                    "                     },\n" +
                    "                     \"html_instructions\" : \"At \\u003cb\\u003eAasan Square\\u003c/b\\u003e, take the \\u003cb\\u003e3rd\\u003c/b\\u003e exit and stay on \\u003cb\\u003ePalayam - Airport Rd\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by NSS Section (on the left)\\u003c/div\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003eDestination will be on the left\\u003c/div\\u003e\",\n" +
                    "                     \"maneuver\" : \"roundabout-left\",\n" +
                    "                     \"polyline\" : {\n" +
                    "                        \"points\" : \"ky{r@m}stM?@A?A@A?A?A@A?C?A?C?A?CAA?CAA?CCAAAAAAAAAAACAA?C?AAC?A?C@A?C?A@C?A@C@A@A@A@A@ABABADAD?B?B?@?@@B?@@B@@?@@@@@B@@@@@@?B@@?B?@?B?@?B?@?BxClA\"\n" +
                    "                     },\n" +
                    "                     \"start_location\" : {\n" +
                    "                        \"lat\" : 8.5034159,\n" +
                    "                        \"lng\" : 76.9482264\n" +
                    "                     },\n" +
                    "                     \"travel_mode\" : \"DRIVING\"\n" +
                    "                  }\n" +
                    "               ],\n" +
                    "               \"traffic_speed_entry\" : [],\n" +
                    "               \"via_waypoint\" : []\n" +
                    "            }\n" +
                    "         ],\n" +
                    "         \"overview_polyline\" : {\n" +
                    "            \"points\" : \"{z_s@_uqtMSCENIRk@TcBh@@b@}C?IEsDOyAIgC@s@OaGZfBnHRzC@pAOh@kAvAi@z@e@jBC~D@`AGzCm@bEuA@gLOe@?k@D{@VuDxBsCdBqB|AoClAoCv@qCl@oEzAqB|@gBdAaCdC_B`AcGlCmGtCuCbAaFhBu@NyAFyE_@_AJ[R]j@gA|Cc@bBGbAFv@RpBIn@e@|Aq@hCW~@AlDGj@Sl@_CjHyAfBaBvBa@t@Mj@OdBUbHMz@e@dA_C~Dg@zBgAxEaAlDc@nAuDlGs@`AqCbCy@h@wA^kBj@eF|BuDdBcC~@uDh@s@l@_A~A{Az@_@l@Qr@Bt@l@lCLtC@zDkBpHaAlCyAzA}CrAsIrDcBvAwD~E_CvD_@EkBz@a@NaAFwEZgBRcDZuGTiC?}CUoCKiDyAqAc@Ye@eBkEoBaDg@q@eCuBu@qAg@c@iAk@qABsCf@aAF{AS_BKeG\\\\YDGLOnAMj@]f@cAv@eAp@mA`@cAjAgCdAyAXiFV}AMuEgBgDaBg@KgFaB{AICTOv@_@hB}@xBk@p@i@z@k@hBBf@mA~Dk@bB]r@YlA]t@]ESH]Fq@OkBm@_@Ai@v@m@fA`B~DfE~KhBlDxApBjClC`CtBtBjC`@nAT~DZ~@bAhBr@z@xBlBlDzCTl@StDWpGEbHLzCb@xB`B`EzFhIpG|IZpABzAV~B^rArBhEtDnH~@s@`DkBpHaFdRsN`GaEpHeDpBq@jDgBbC}AdCoB|DaDpBeBlCeBrEgCjGkDtAgAr@YZM@N`Bw@h@WzAm@r@KrLk@bOc@dGOASVCfHSpPq@~EW|DQ~AEZA@VnIQhKOlPQzOSjEe@vBm@xAo@lFoDdTeNrGeEjGcEhGaFlFgFx_@{^xI{IrPqNjReP|]wZjH{GrByBpH}I|FcIpEsGdByBLQLLLRvBgCrL{LlKoKnDsDpFcFhBmBiBlBqFbFcAbAmFrFyMdNeF`FwBfCMSaAjAoFvH{IvLmFdGaBbB{@bAaJhI_HdG]_@hD{CbNyLfCiCh@d@KJqEtEoJnIwDdDOLKKMOdK_JxFiFp@q@rByBpH}I|FcIpEsGjDmEfDuDtEqEfKkKdGgGrAoAjIaI|MaNxLsLb@q@`AkAtAwARWU}@g@}AgAgCkDiIiB}HcB_FcAyBOe@iByBkAwAc@s@]iASkAKoAaAaGIaA?o@g@_EuAmJQw@cAoDYU_@W}BaAgBUc@OMWEaATaA`@_D\\\\yIIaC_@}FK]i@s@eGgPo@gA]S{D}@}DwASAOBWIKS@WRQ\\\\@PN@VxCpA\"\n" +
                    "         },\n" +
                    "         \"summary\" : \"Kazhakoottam - Kilimanoor Rd\",\n" +
                    "         \"warnings\" : [],\n" +
                    "         \"waypoint_order\" : [ 0, 1, 2, 3 ]\n" +
                    "      }\n" +
                    "   ],\n" +
                    "   \"status\" : \"OK\"\n" +
                    "}");
            Log.d("mylog", jsonData[0].toString());
            DataParser parser = new DataParser(mContext);


            Log.d("mylog", parser.toString());

            // Starts parsing data
            routes = parser.parse(jObject);
            Log.d("mylog", "Executing routes");
            Log.d("mylog", routes.toString());

        } catch (Exception e) {
            Log.d("mylog", e.toString());
            e.printStackTrace();
        }
        return routes;
    }

    // Executes in UI thread, after the parsing process
    @Override
    protected void onPostExecute(List<List<HashMap<String, String>>> result) {
        ArrayList<LatLng> points;
        PolylineOptions lineOptions = null;
        String distance = null;
        String duration=null;
        // Traversing through all the routes
        for (int i = 0; i < result.size(); i++) {
            points = new ArrayList<>();
            lineOptions = new PolylineOptions();
            // Fetching i-th route
            List<HashMap<String, String>> path = result.get(i);
            // Fetching all the points in i-th route
            for (int j = 0; j < path.size(); j++) {
                HashMap<String, String> point = path.get(j);
                /*if(j==0){    // Get distance from the list
                     distance = (String) point.get("distance");
                    Log.d("TAG","hkjh"+distance);
                    taskCallback.distance(distance);
                    continue;
                }else if(j==1){ // Get duration from the list
                    duration = (String)point.get("duration");
                    Log.d("TAG","hgj"+duration);
                    taskCallback.duration(duration);
                    continue;
                }*/
                double lat = Double.parseDouble(point.get("lat"));
                double lng = Double.parseDouble(point.get("lng"));
                LatLng position = new LatLng(lat, lng);
                points.add(position);


            }
            // Adding all the points in the route to LineOptions
            lineOptions.addAll(points);
            if (directionMode.equalsIgnoreCase("walking")) {
                lineOptions.width(10);
                lineOptions.color(Color.MAGENTA);
            } else {
                lineOptions.width(10);
                lineOptions.color(Color.BLUE);
            }
            Log.d("mylog", "onPostExecute lineoptions decoded");
        }

        // Drawing polyline in the Google Map for the i-th route
        if (lineOptions != null) {
            //mMap.addPolyline(lineOptions);
            taskCallback.onTaskDone(lineOptions);

        } else {
            Log.d("mylog", "without Polylines drawn");
        }
    }
}
