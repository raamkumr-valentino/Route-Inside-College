package com.tcemap;

import android.app.Dialog;
import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.Locale;

public class Home extends AppCompatActivity implements OnMapReadyCallback,TextToSpeech.OnInitListener{
    private GoogleMap mMap;
    Intent searchIntent;
    public String searchQuery;
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FloatingActionButton fabtn, fabtn2, fabtn3,fabbtn4;
    Animation fab_open, fab_close, fab_clockwise, fab_anti_clockwise;
    CoordinatorLayout coordinatorLayout;
    Marker mark,from,to;
    String voice="Welcome TCE";
    boolean isOPEN = false;
    public double cLat,cLong;
    LatLngBounds.Builder builder=new LatLngBounds.Builder();
    //Main Building
    ArrayList<LatLng> MECE=new ArrayList<>();
    ArrayList<LatLng> MLIB = new ArrayList<>();
    ArrayList<LatLng> MPAR = new ArrayList<>();
    ArrayList<LatLng> MMECH = new ArrayList<>();
    ArrayList<LatLng> MEEE = new ArrayList<>();
    ArrayList<LatLng> MKM = new ArrayList<>();
    ArrayList<LatLng> MCVL = new ArrayList<>();
    ArrayList<LatLng> MCS = new ArrayList<>();
    ArrayList<LatLng> MIT=new ArrayList<>();
    //IT
    ArrayList<LatLng> IMAINBUILDING = new ArrayList<>();
    ArrayList<LatLng> ICSE = new ArrayList<>();
    ArrayList<LatLng> IMECH = new ArrayList<>();
    ArrayList<LatLng> IECE = new ArrayList<>();
    ArrayList<LatLng> IEEE = new ArrayList<>();
    ArrayList<LatLng> ICIVIL = new ArrayList<>();
    ArrayList<LatLng> IMECHT = new ArrayList<>();
    ArrayList<LatLng> IARCH = new ArrayList<>();
    ArrayList<LatLng> ISCIENCEBLOCK = new ArrayList<>();
    ArrayList<LatLng> IFRESHERBLOCK = new ArrayList<>();
    ArrayList<LatLng> INCCBLOCK = new ArrayList<>();
    ArrayList<LatLng> IINDOOR = new ArrayList<>();
    ArrayList<LatLng> IOUTDOOR = new ArrayList<>();
    ArrayList<LatLng> IKSAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> IKMAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> IPLACEMENTCELL = new ArrayList<LatLng>();
    ArrayList<LatLng> IGUESTHOUSE = new ArrayList<LatLng>();
    ArrayList<LatLng> IMAINCANTEEN = new ArrayList<LatLng>();
    ArrayList<LatLng> IFOODCOURT = new ArrayList<LatLng>();
    ArrayList<LatLng> IMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> IWOMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> ILIBRARY = new ArrayList<LatLng>();
    ArrayList<LatLng> IBANK = new ArrayList<LatLng>();
    ArrayList<LatLng> ITEMPLE = new ArrayList<LatLng>();
    ArrayList<LatLng> IPARKING = new ArrayList<LatLng>();
    //CSE
    ArrayList<LatLng> CMAINBUILDING = new ArrayList<LatLng>();
    ArrayList<LatLng> CIT = new ArrayList<LatLng>();
    ArrayList<LatLng> CECE = new ArrayList<LatLng>();
    ArrayList<LatLng> CEEE = new ArrayList<LatLng>();
    ArrayList<LatLng> CCIVIL = new ArrayList<LatLng>();
    ArrayList<LatLng> CMECH = new ArrayList<LatLng>();
    ArrayList<LatLng> CMECHT = new ArrayList<LatLng>();
    ArrayList<LatLng> CARCH = new ArrayList<LatLng>();
    ArrayList<LatLng> CSCIENCEBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> CFRESHERBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> CNCCBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> CINDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> COUTDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> CKSAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> CKMAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> CPLACEMENTCELL = new ArrayList<LatLng>();
    ArrayList<LatLng> CGUESTHOUSE = new ArrayList<LatLng>();
    ArrayList<LatLng> CMAINCANTEEN = new ArrayList<LatLng>();
    ArrayList<LatLng> CFOODCOURT = new ArrayList<LatLng>();
    ArrayList<LatLng> CMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> CWOMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> CLIBRARY = new ArrayList<LatLng>();
    ArrayList<LatLng> CBANK = new ArrayList<LatLng>();
    ArrayList<LatLng> CTEMPLE = new ArrayList<LatLng>();
    ArrayList<LatLng> CPARKING = new ArrayList<LatLng>();
    //ECE
    ArrayList<LatLng> ECMAINBUILDING = new ArrayList<LatLng>();
    ArrayList<LatLng> ECIT = new ArrayList<LatLng>();
    ArrayList<LatLng> ECCSE = new ArrayList<LatLng>();
    ArrayList<LatLng> ECEEE = new ArrayList<LatLng>();
    ArrayList<LatLng> ECCIVIL = new ArrayList<LatLng>();
    ArrayList<LatLng> ECMECH = new ArrayList<LatLng>();
    ArrayList<LatLng> ECMECHT = new ArrayList<LatLng>();
    ArrayList<LatLng> ECARCH = new ArrayList<LatLng>();
    ArrayList<LatLng> ECSCIENCEBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> ECFRESHERBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> ECNCCBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> ECINDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> ECOUTDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> ECKSAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> ECKMAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> ECPLACEMENTCELL = new ArrayList<LatLng>();
    ArrayList<LatLng> ECGUESTHOUSE = new ArrayList<LatLng>();
    ArrayList<LatLng> ECMAINCANTEEN = new ArrayList<LatLng>();
    ArrayList<LatLng> ECFOODCOURT = new ArrayList<LatLng>();
    ArrayList<LatLng> ECMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> ECWOMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> ECLIBRARY = new ArrayList<LatLng>();
    ArrayList<LatLng> ECBANK = new ArrayList<LatLng>();
    ArrayList<LatLng> ECTEMPLE = new ArrayList<LatLng>();
    ArrayList<LatLng> ECPARKING = new ArrayList<LatLng>();
    //EEE
    ArrayList<LatLng> EEMAINBUILDING = new ArrayList<LatLng>();
    ArrayList<LatLng> EEIT = new ArrayList<LatLng>();
    ArrayList<LatLng> EECSE = new ArrayList<LatLng>();
    ArrayList<LatLng> EEECE = new ArrayList<LatLng>();
    ArrayList<LatLng> EECIVIL = new ArrayList<LatLng>();
    ArrayList<LatLng> EEMECH = new ArrayList<LatLng>();
    ArrayList<LatLng> EEMECHT = new ArrayList<LatLng>();
    ArrayList<LatLng> EEARCH = new ArrayList<LatLng>();
    ArrayList<LatLng> EESCIENCEBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> EEFRESHERBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> EENCCBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> EEINDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> EEOUTDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> EEKSAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> EEKMAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> EEPLACEMENTCELL = new ArrayList<LatLng>();
    ArrayList<LatLng> EEGUESTHOUSE = new ArrayList<LatLng>();
    ArrayList<LatLng> EEMAINCANTEEN = new ArrayList<LatLng>();
    ArrayList<LatLng> EEFOODCOURT = new ArrayList<LatLng>();
    ArrayList<LatLng> EEMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> EEWOMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> EELIBRARY = new ArrayList<LatLng>();
    ArrayList<LatLng> EEBANK = new ArrayList<LatLng>();
    ArrayList<LatLng> EETEMPLE = new ArrayList<LatLng>();
    ArrayList<LatLng> EEPARKING = new ArrayList<LatLng>();
    //CIVIL
    ArrayList<LatLng> CIMAINBUILDING = new ArrayList<LatLng>();
    ArrayList<LatLng> CIIT = new ArrayList<LatLng>();
    ArrayList<LatLng> CICSE = new ArrayList<LatLng>();
    ArrayList<LatLng> CIECE = new ArrayList<LatLng>();
    ArrayList<LatLng> CIEEE = new ArrayList<LatLng>();
    ArrayList<LatLng> CIMECH = new ArrayList<LatLng>();
    ArrayList<LatLng> CIMECHT = new ArrayList<LatLng>();
    ArrayList<LatLng> CIARCH = new ArrayList<LatLng>();
    ArrayList<LatLng> CISCIENCEBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> CIFRESHERBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> CINCCBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> CIINDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> CIOUTDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> CIKSAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> CIKMAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> CIPLACEMENTCELL = new ArrayList<LatLng>();
    ArrayList<LatLng> CIGUESTHOUSE = new ArrayList<LatLng>();
    ArrayList<LatLng> CIMAINCANTEEN = new ArrayList<LatLng>();
    ArrayList<LatLng> CIFOODCOURT = new ArrayList<LatLng>();
    ArrayList<LatLng> CIMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> CIWOMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> CILIBRARY = new ArrayList<LatLng>();
    ArrayList<LatLng> CIBANK = new ArrayList<LatLng>();
    ArrayList<LatLng> CITEMPLE = new ArrayList<LatLng>();
    ArrayList<LatLng> CIPARKING = new ArrayList<LatLng>();
    //MECH
    ArrayList<LatLng> MEMAINBUILDING = new ArrayList<LatLng>();
    ArrayList<LatLng> MEIT = new ArrayList<LatLng>();
    ArrayList<LatLng> MECSE = new ArrayList<LatLng>();
    ArrayList<LatLng> MEECE = new ArrayList<LatLng>();
    ArrayList<LatLng> MEEEE = new ArrayList<LatLng>();
    ArrayList<LatLng> MECIVIL = new ArrayList<LatLng>();
    ArrayList<LatLng> MEMECHT = new ArrayList<LatLng>();
    ArrayList<LatLng> MEARCH = new ArrayList<LatLng>();
    ArrayList<LatLng> MESCIENCEBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> MEFRESHERBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> MENCCBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> MEINDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> MEOUTDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> MEKSAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> MEKMAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> MEPLACEMENTCELL = new ArrayList<LatLng>();
    ArrayList<LatLng> MEGUESTHOUSE = new ArrayList<LatLng>();
    ArrayList<LatLng> MEMAINCANTEEN = new ArrayList<LatLng>();
    ArrayList<LatLng> MEFOODCOURT = new ArrayList<LatLng>();
    ArrayList<LatLng> MEMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> MEWOMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> MELIBRARY = new ArrayList<LatLng>();
    ArrayList<LatLng> MEBANK = new ArrayList<LatLng>();
    ArrayList<LatLng> METEMPLE = new ArrayList<LatLng>();
    ArrayList<LatLng> MEPARKING = new ArrayList<LatLng>();
    //MECHT
    ArrayList<LatLng> MTMAINBUILDING = new ArrayList<LatLng>();
    ArrayList<LatLng> MTIT=new ArrayList<>();
    ArrayList<LatLng> MTCSE = new ArrayList<LatLng>();
    ArrayList<LatLng> MTECE = new ArrayList<LatLng>();
    ArrayList<LatLng> MTEEE = new ArrayList<LatLng>();
    ArrayList<LatLng> MTCIVIL = new ArrayList<LatLng>();
    ArrayList<LatLng> MTMECH = new ArrayList<LatLng>();
    ArrayList<LatLng> MTARCH = new ArrayList<LatLng>();
    ArrayList<LatLng> MTSCIENCEBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> MTFRESHERBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> MTNCCBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> MTINDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> MTOUTDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> MTKSAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> MTKMAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> MTPLACEMENTCELL = new ArrayList<LatLng>();
    ArrayList<LatLng> MTGUESTHOUSE = new ArrayList<LatLng>();
    ArrayList<LatLng> MTMAINCANTEEN = new ArrayList<LatLng>();
    ArrayList<LatLng> MTFOODCOURT = new ArrayList<LatLng>();
    ArrayList<LatLng> MTMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> MTWOMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> MTLIBRARY = new ArrayList<LatLng>();
    ArrayList<LatLng> MTBANK = new ArrayList<LatLng>();
    ArrayList<LatLng> MTTEMPLE = new ArrayList<LatLng>();
    ArrayList<LatLng> MTPARKING = new ArrayList<LatLng>();
    //ARCH
    ArrayList<LatLng> AMAINBUILDING = new ArrayList<LatLng>();
    ArrayList<LatLng> AIT = new ArrayList<LatLng>();
    ArrayList<LatLng> ACSE = new ArrayList<LatLng>();
    ArrayList<LatLng> AECE = new ArrayList<LatLng>();
    ArrayList<LatLng> AEEE = new ArrayList<LatLng>();
    ArrayList<LatLng> ACIVIL = new ArrayList<LatLng>();
    ArrayList<LatLng> AMECH = new ArrayList<LatLng>();
    ArrayList<LatLng> AMECHT = new ArrayList<LatLng>();
    ArrayList<LatLng> ASCIENCEBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> AFRESHERBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> ANCCBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> AINDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> AOUTDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> AKSAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> AKMAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> APLACEMENTCELL = new ArrayList<LatLng>();
    ArrayList<LatLng> AGUESTHOUSE = new ArrayList<LatLng>();
    ArrayList<LatLng> AMAINCANTEEN = new ArrayList<LatLng>();
    ArrayList<LatLng> AFOODCOURT = new ArrayList<LatLng>();
    ArrayList<LatLng> AMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> AWOMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> ALIBRARY = new ArrayList<LatLng>();
    ArrayList<LatLng> ABANK = new ArrayList<LatLng>();
    ArrayList<LatLng> ATEMPLE = new ArrayList<LatLng>();
    ArrayList<LatLng> APARKING = new ArrayList<LatLng>();
    //KM
    ArrayList<LatLng> KMMAINBUILDING = new ArrayList<LatLng>();
    ArrayList<LatLng> KMIT = new ArrayList<LatLng>();
    ArrayList<LatLng> KMCSE = new ArrayList<LatLng>();
    ArrayList<LatLng> KMECE = new ArrayList<LatLng>();
    ArrayList<LatLng> KMEEE = new ArrayList<LatLng>();
    ArrayList<LatLng> KMCIVIL = new ArrayList<LatLng>();
    ArrayList<LatLng> KMMECH = new ArrayList<LatLng>();
    ArrayList<LatLng> KMMECHT = new ArrayList<LatLng>();
    ArrayList<LatLng> KMARCH = new ArrayList<LatLng>();
    ArrayList<LatLng> KMSCIENCEBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> KMFRESHERBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> KMNCCBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> KMOUTDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> KMINDOOR=new ArrayList<>();
    ArrayList<LatLng> KMKSAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> KMPLACEMENTCELL = new ArrayList<LatLng>();
    ArrayList<LatLng> KMGUESTHOUSE = new ArrayList<LatLng>();
    ArrayList<LatLng> KMMAINCANTEEN = new ArrayList<LatLng>();
    ArrayList<LatLng> KMFOODCOURT = new ArrayList<LatLng>();
    ArrayList<LatLng> KMMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> KMWOMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> KMLIBRARY = new ArrayList<LatLng>();
    ArrayList<LatLng> KMBANK = new ArrayList<LatLng>();
    ArrayList<LatLng> KMTEMPLE = new ArrayList<LatLng>();
    ArrayList<LatLng> KMPARKING = new ArrayList<LatLng>();
    //KS
    ArrayList<LatLng> KSMAINBUILDING = new ArrayList<LatLng>();
    ArrayList<LatLng> KSIT = new ArrayList<LatLng>();
    ArrayList<LatLng> KSCSE = new ArrayList<LatLng>();
    ArrayList<LatLng> KSECE = new ArrayList<LatLng>();
    ArrayList<LatLng> KSEEE = new ArrayList<LatLng>();
    ArrayList<LatLng> KSCIVIL = new ArrayList<LatLng>();
    ArrayList<LatLng> KSMECH = new ArrayList<LatLng>();
    ArrayList<LatLng> KSMECHT = new ArrayList<LatLng>();
    ArrayList<LatLng> KSARCH = new ArrayList<LatLng>();
    ArrayList<LatLng> KSSCIENCEBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> KSFRESHERBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> KSNCCBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> KSINDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> KSOUTDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> KSKMAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> KSPLACEMENTCELL = new ArrayList<LatLng>();
    ArrayList<LatLng> KSGUESTHOUSE = new ArrayList<LatLng>();
    ArrayList<LatLng> KSMAINCANTEEN = new ArrayList<LatLng>();
    ArrayList<LatLng> KSFOODCOURT = new ArrayList<LatLng>();
    ArrayList<LatLng> KSMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> KSWOMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> KSLIBRARY = new ArrayList<LatLng>();
    ArrayList<LatLng> KSBANK = new ArrayList<LatLng>();
    ArrayList<LatLng> KSTEMPLE = new ArrayList<LatLng>();
    ArrayList<LatLng> KSPARKING = new ArrayList<LatLng>();
    //Science Block
    ArrayList<LatLng> SBMAINBUILDING = new ArrayList<LatLng>();
    ArrayList<LatLng> SBIT = new ArrayList<LatLng>();
    ArrayList<LatLng> SBCSE = new ArrayList<LatLng>();
    ArrayList<LatLng> SBECE = new ArrayList<LatLng>();
    ArrayList<LatLng> SBEEE = new ArrayList<LatLng>();
    ArrayList<LatLng> SBCIVIL = new ArrayList<LatLng>();
    ArrayList<LatLng> SBMECH = new ArrayList<LatLng>();
    ArrayList<LatLng> SBMECHT = new ArrayList<LatLng>();
    ArrayList<LatLng> SBARCH = new ArrayList<LatLng>();
    ArrayList<LatLng> SBFRESHERBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> SBNCCBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> SBINDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> SBOUTDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> SBKSAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> SBKMAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> SBPLACEMENTCELL = new ArrayList<LatLng>();
    ArrayList<LatLng> SBGUESTHOUSE = new ArrayList<LatLng>();
    ArrayList<LatLng> SBMAINCANTEEN = new ArrayList<LatLng>();
    ArrayList<LatLng> SBFOODCOURT = new ArrayList<LatLng>();
    ArrayList<LatLng> SBMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> SBWOMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> SBLIBRARY = new ArrayList<LatLng>();
    ArrayList<LatLng> SBBANK = new ArrayList<LatLng>();
    ArrayList<LatLng> SBTEMPLE = new ArrayList<LatLng>();
    ArrayList<LatLng> SBPARKING = new ArrayList<LatLng>();
    //Freshers Block
    ArrayList<LatLng> FBMAINBUILDING = new ArrayList<LatLng>();
    ArrayList<LatLng> FBIT = new ArrayList<LatLng>();
    ArrayList<LatLng> FBCSE = new ArrayList<LatLng>();
    ArrayList<LatLng> FBECE = new ArrayList<LatLng>();
    ArrayList<LatLng> FBEEE = new ArrayList<LatLng>();
    ArrayList<LatLng> FBCIVIL = new ArrayList<LatLng>();
    ArrayList<LatLng> FBMECH = new ArrayList<LatLng>();
    ArrayList<LatLng> FBMECHT = new ArrayList<LatLng>();
    ArrayList<LatLng> FBARCH = new ArrayList<LatLng>();
    ArrayList<LatLng> FBSCIENCEBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> FBNCCBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> FBINDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> FBOUTDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> FBKSAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> FBKMAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> FBPLACEMENTCELL = new ArrayList<LatLng>();
    ArrayList<LatLng> FBGUESTHOUSE = new ArrayList<LatLng>();
    ArrayList<LatLng> FBMAINCANTEEN = new ArrayList<LatLng>();
    ArrayList<LatLng> FBFOODCOURT = new ArrayList<LatLng>();
    ArrayList<LatLng> FBMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> FBWOMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> FBLIBRARY = new ArrayList<LatLng>();
    ArrayList<LatLng> FBBANK = new ArrayList<LatLng>();
    ArrayList<LatLng> FBTEMPLE = new ArrayList<LatLng>();
    ArrayList<LatLng> FBPARKING = new ArrayList<LatLng>();
    //NCC Block
    ArrayList<LatLng> NCCBMAINBUILDING = new ArrayList<LatLng>();
    ArrayList<LatLng> NCCBIT = new ArrayList<LatLng>();
    ArrayList<LatLng> NCCBCSE = new ArrayList<LatLng>();
    ArrayList<LatLng> NCCBECE = new ArrayList<LatLng>();
    ArrayList<LatLng> NCCBEEE = new ArrayList<LatLng>();
    ArrayList<LatLng> NCCBCIVIL = new ArrayList<LatLng>();
    ArrayList<LatLng> NCCBMECH = new ArrayList<LatLng>();
    ArrayList<LatLng> NCCBMECHT = new ArrayList<LatLng>();
    ArrayList<LatLng> NCCBARCH = new ArrayList<LatLng>();
    ArrayList<LatLng> NCCBSCIENCEBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> NCCBFRESHERBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> NCCBINDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> NCCBOUTDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> NCCBKSAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> NCCBKMAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> NCCBPLACEMENTCELL = new ArrayList<LatLng>();
    ArrayList<LatLng> NCCBGUESTHOUSE = new ArrayList<LatLng>();
    ArrayList<LatLng> NCCBMAINCANTEEN = new ArrayList<LatLng>();
    ArrayList<LatLng> NCCBFOODCOURT = new ArrayList<LatLng>();
    ArrayList<LatLng> NCCBMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> NCCBWOMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> NCCBLIBRARY = new ArrayList<LatLng>();
    ArrayList<LatLng> NCCBBANK = new ArrayList<LatLng>();
    ArrayList<LatLng> NCCBTEMPLE = new ArrayList<LatLng>();
    ArrayList<LatLng> NCCBPARKING = new ArrayList<LatLng>();
    //Indoor
    ArrayList<LatLng> INMAINBUILDING = new ArrayList<LatLng>();
    ArrayList<LatLng> INIT = new ArrayList<LatLng>();
    ArrayList<LatLng> INCSE = new ArrayList<LatLng>();
    ArrayList<LatLng> INECE = new ArrayList<LatLng>();
    ArrayList<LatLng> INEEE = new ArrayList<LatLng>();
    ArrayList<LatLng> INCIVIL = new ArrayList<LatLng>();
    ArrayList<LatLng> INMECH = new ArrayList<LatLng>();
    ArrayList<LatLng> INMECHT = new ArrayList<LatLng>();
    ArrayList<LatLng> INARCH = new ArrayList<LatLng>();
    ArrayList<LatLng> INSCIENCEBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> INFRESHERBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> INNCCBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> INOUTDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> INKSAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> INKMAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> INPLACEMENTCELL = new ArrayList<LatLng>();
    ArrayList<LatLng> INGUESTHOUSE = new ArrayList<LatLng>();
    ArrayList<LatLng> INMAINCANTEEN = new ArrayList<LatLng>();
    ArrayList<LatLng> INFOODCOURT = new ArrayList<LatLng>();
    ArrayList<LatLng> INMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> INWOMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> INLIBRARY = new ArrayList<LatLng>();
    ArrayList<LatLng> INBANK = new ArrayList<LatLng>();
    ArrayList<LatLng> INTEMPLE = new ArrayList<LatLng>();
    ArrayList<LatLng> INPARKING = new ArrayList<LatLng>();
    //Outdoor
    ArrayList<LatLng> OUTMAINBUILDING = new ArrayList<LatLng>();
    ArrayList<LatLng> OUTIT = new ArrayList<LatLng>();
    ArrayList<LatLng> OUTCSE = new ArrayList<LatLng>();
    ArrayList<LatLng> OUTECE = new ArrayList<LatLng>();
    ArrayList<LatLng> OUTEEE = new ArrayList<LatLng>();
    ArrayList<LatLng> OUTCIVIL = new ArrayList<LatLng>();
    ArrayList<LatLng> OUTMECH = new ArrayList<LatLng>();
    ArrayList<LatLng> OUTMECHT = new ArrayList<LatLng>();
    ArrayList<LatLng> OUTARCH = new ArrayList<LatLng>();
    ArrayList<LatLng> OUTSCIENCEBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> OUTFRESHERBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> OUTNCCBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> OUTINDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> OUTKSAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> OUTKMAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> OUTPLACEMENTCELL = new ArrayList<LatLng>();
    ArrayList<LatLng> OUTGUESTHOUSE = new ArrayList<LatLng>();
    ArrayList<LatLng> OUTMAINCANTEEN = new ArrayList<LatLng>();
    ArrayList<LatLng> OUTFOODCOURT = new ArrayList<LatLng>();
    ArrayList<LatLng> OUTMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> OUTWOMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> OUTLIBRARY = new ArrayList<LatLng>();
    ArrayList<LatLng> OUTBANK = new ArrayList<LatLng>();
    ArrayList<LatLng> OUTTEMPLE = new ArrayList<LatLng>();
    ArrayList<LatLng> OUTPARKING = new ArrayList<LatLng>();
    //Placement Cell
    ArrayList<LatLng> PCMAINBUILDING = new ArrayList<LatLng>();
    ArrayList<LatLng> PCIT = new ArrayList<LatLng>();
    ArrayList<LatLng> PCCSE = new ArrayList<LatLng>();
    ArrayList<LatLng> PCECE = new ArrayList<LatLng>();
    ArrayList<LatLng> PCEEE = new ArrayList<LatLng>();
    ArrayList<LatLng> PCCIVIL = new ArrayList<LatLng>();
    ArrayList<LatLng> PCMECH = new ArrayList<LatLng>();
    ArrayList<LatLng> PCMECHT = new ArrayList<LatLng>();
    ArrayList<LatLng> PCARCH = new ArrayList<LatLng>();
    ArrayList<LatLng> PCSCIENCEBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> PCFRESHERBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> PCNCCBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> PCINDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> PCOUTDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> PCKSAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> PCKMAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> PCGUESTHOUSE = new ArrayList<LatLng>();
    ArrayList<LatLng> PCMAINCANTEEN = new ArrayList<LatLng>();
    ArrayList<LatLng> PCFOODCOURT = new ArrayList<LatLng>();
    ArrayList<LatLng> PCMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> PCWOMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> PCLIBRARY = new ArrayList<LatLng>();
    ArrayList<LatLng> PCBANK = new ArrayList<LatLng>();
    ArrayList<LatLng> PCTEMPLE = new ArrayList<LatLng>();
    ArrayList<LatLng> PCPARKING = new ArrayList<LatLng>();
    //Guest House
    ArrayList<LatLng> GHMAINBUILDING = new ArrayList<LatLng>();
    ArrayList<LatLng> GHIT = new ArrayList<LatLng>();
    ArrayList<LatLng> GHCSE = new ArrayList<LatLng>();
    ArrayList<LatLng> GHECE = new ArrayList<LatLng>();
    ArrayList<LatLng> GHEEE = new ArrayList<LatLng>();
    ArrayList<LatLng> GHCIVIL = new ArrayList<LatLng>();
    ArrayList<LatLng> GHMECH = new ArrayList<LatLng>();
    ArrayList<LatLng> GHMECHT = new ArrayList<LatLng>();
    ArrayList<LatLng> GHARCH = new ArrayList<LatLng>();
    ArrayList<LatLng> GHSCIENCEBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> GHFRESHERBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> GHNCCBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> GHINDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> GHOUTDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> GHKSAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> GHKMAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> GHPLACEMENTCELL = new ArrayList<LatLng>();
    ArrayList<LatLng> GHMAINCANTEEN = new ArrayList<LatLng>();
    ArrayList<LatLng> GHFOODCOURT = new ArrayList<LatLng>();
    ArrayList<LatLng> GHMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> GHWOMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> GHLIBRARY = new ArrayList<LatLng>();
    ArrayList<LatLng> GHBANK = new ArrayList<LatLng>();
    ArrayList<LatLng> GHTEMPLE = new ArrayList<LatLng>();
    ArrayList<LatLng> GHPARKING = new ArrayList<LatLng>();
    //Main Canteen
    ArrayList<LatLng> MCMAINBUILDING = new ArrayList<LatLng>();
    ArrayList<LatLng> MCIT = new ArrayList<LatLng>();
    ArrayList<LatLng> MCCSE = new ArrayList<LatLng>();
    ArrayList<LatLng> MCECE = new ArrayList<LatLng>();
    ArrayList<LatLng> MCEEE = new ArrayList<LatLng>();
    ArrayList<LatLng> MCCIVIL = new ArrayList<LatLng>();
    ArrayList<LatLng> MCMECH = new ArrayList<LatLng>();
    ArrayList<LatLng> MCMECHT = new ArrayList<LatLng>();
    ArrayList<LatLng> MCARCH = new ArrayList<LatLng>();
    ArrayList<LatLng> MCSCIENCEBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> MCFRESHERBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> MCNCCBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> MCINDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> MCOUTDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> MCKSAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> MCKMAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> MCPLACEMENTCELL = new ArrayList<LatLng>();
    ArrayList<LatLng> MCGUESTHOUSE = new ArrayList<LatLng>();
    ArrayList<LatLng> MCFOODCOURT = new ArrayList<LatLng>();
    ArrayList<LatLng> MCMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> MCWOMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> MCLIBRARY = new ArrayList<LatLng>();
    ArrayList<LatLng> MCBANK = new ArrayList<LatLng>();
    ArrayList<LatLng> MCTEMPLE = new ArrayList<LatLng>();
    ArrayList<LatLng> MCPARKING = new ArrayList<LatLng>();
    //Food Court
    ArrayList<LatLng> FCMAINBUILDING = new ArrayList<LatLng>();
    ArrayList<LatLng> FCIT = new ArrayList<LatLng>();
    ArrayList<LatLng> FCCSE = new ArrayList<LatLng>();
    ArrayList<LatLng> FCECE = new ArrayList<LatLng>();
    ArrayList<LatLng> FCEEE = new ArrayList<LatLng>();
    ArrayList<LatLng> FCCIVIL = new ArrayList<LatLng>();
    ArrayList<LatLng> FCMECH = new ArrayList<LatLng>();
    ArrayList<LatLng> FCMECHT = new ArrayList<LatLng>();
    ArrayList<LatLng> FCARCH = new ArrayList<LatLng>();
    ArrayList<LatLng> FCSCIENCEBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> FCFRESHERBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> FCNCCBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> FCINDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> FCOUTDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> FCKSAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> FCKMAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> FCPLACEMENTCELL = new ArrayList<LatLng>();
    ArrayList<LatLng> FCGUESTHOUSE = new ArrayList<LatLng>();
    ArrayList<LatLng> FCMAINCANTEEN = new ArrayList<LatLng>();
    ArrayList<LatLng> FCMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> FCWOMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> FCLIBRARY = new ArrayList<LatLng>();
    ArrayList<LatLng> FCBANK = new ArrayList<LatLng>();
    ArrayList<LatLng> FCTEMPLE = new ArrayList<LatLng>();
    ArrayList<LatLng> FCPARKING = new ArrayList<LatLng>();
    //Mens Hostel
    ArrayList<LatLng> MHMAINBUILDING = new ArrayList<LatLng>();
    ArrayList<LatLng> MHIT = new ArrayList<LatLng>();
    ArrayList<LatLng> MHCSE = new ArrayList<LatLng>();
    ArrayList<LatLng> MHECE = new ArrayList<LatLng>();
    ArrayList<LatLng> MHEEE = new ArrayList<LatLng>();
    ArrayList<LatLng> MHCIVIL = new ArrayList<LatLng>();
    ArrayList<LatLng> MHMECH = new ArrayList<LatLng>();
    ArrayList<LatLng> MHMECHT = new ArrayList<LatLng>();
    ArrayList<LatLng> MHARCH = new ArrayList<LatLng>();
    ArrayList<LatLng> MHSCIENCEBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> MHFRESHERBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> MHNCCBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> MHINDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> MHOUTDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> MHKSAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> MHKMAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> MHPLACEMENTCELL = new ArrayList<LatLng>();
    ArrayList<LatLng> MHGUESTHOUSE = new ArrayList<LatLng>();
    ArrayList<LatLng> MHMAINCANTEEN = new ArrayList<LatLng>();
    ArrayList<LatLng> MHFOODCOURT = new ArrayList<LatLng>();
    ArrayList<LatLng> MHWOMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> MHLIBRARY = new ArrayList<LatLng>();
    ArrayList<LatLng> MHBANK = new ArrayList<LatLng>();
    ArrayList<LatLng> MHTEMPLE = new ArrayList<LatLng>();
    ArrayList<LatLng> MHPARKING = new ArrayList<LatLng>();
    //Womens Hostel
    ArrayList<LatLng> WHMAINBUILDING = new ArrayList<LatLng>();
    ArrayList<LatLng> WHIT = new ArrayList<LatLng>();
    ArrayList<LatLng> WHCSE = new ArrayList<LatLng>();
    ArrayList<LatLng> WHECE = new ArrayList<LatLng>();
    ArrayList<LatLng> WHEEE = new ArrayList<LatLng>();
    ArrayList<LatLng> WHCIVIL = new ArrayList<LatLng>();
    ArrayList<LatLng> WHMECH = new ArrayList<LatLng>();
    ArrayList<LatLng> WHMECHT = new ArrayList<LatLng>();
    ArrayList<LatLng> WHSCIENCEBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> WHARCH = new ArrayList<LatLng>();
    ArrayList<LatLng> WHFRESHERBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> WHNCCBLOCK = new ArrayList<LatLng>();
    ArrayList<LatLng> WHINDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> WHOUTDOOR = new ArrayList<LatLng>();
    ArrayList<LatLng> WHKSAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> WHKMAUDITORIUM = new ArrayList<LatLng>();
    ArrayList<LatLng> WHPLACEMENTCELL = new ArrayList<LatLng>();
    ArrayList<LatLng> WHGUESTHOUSE = new ArrayList<LatLng>();
    ArrayList<LatLng> WHMAINCANTEEN = new ArrayList<LatLng>();
    ArrayList<LatLng> WHFOODCOURT = new ArrayList<LatLng>();
    ArrayList<LatLng> WHMENSHOSTEL = new ArrayList<LatLng>();
    ArrayList<LatLng> WHLIBRARY = new ArrayList<LatLng>();
    ArrayList<LatLng> WHBANK = new ArrayList<LatLng>();
    ArrayList<LatLng> WHTEMPLE = new ArrayList<LatLng>();
    ArrayList<LatLng> WHPARKING = new ArrayList<LatLng>();
    public double lat = 9.882881;
    public double lon = 78.082511;
    public TextToSpeech textToSpeech;
    String fromArr,toArr;

    public LatLng main=new LatLng(9.882881,78.082511);
    public LatLng it1=new LatLng(9.882399,78.083630);
    public LatLng cs=new LatLng(9.882797,78.083739);
    public LatLng ece=new LatLng(9.882820,78.082338);
    public LatLng eee=new LatLng(9.882433,78.082086);
    public LatLng cvl=new LatLng(9.882278,78.082855);
    public LatLng mec=new LatLng(9.882365,78.081429);
    public LatLng mect=new LatLng(9.882365,78.081428);
    public LatLng arch=new LatLng(9.878790,78.082110);
    public LatLng ks=new LatLng(9.882820,78.082337);
    public LatLng km=new LatLng(9.882480,78.082541);
    public LatLng out=new LatLng(9.883842,78.081407);
    public LatLng pc=new LatLng(9.885026,78.080954);
    public LatLng lib=new LatLng(9.882854,78.081243);
    public LatLng par=new LatLng(9.882769,78.080846);
    public LatLng sci=new LatLng(9.881876,78.083152);
    public LatLng bhalls=new LatLng(9.88172,78.082617);
    public LatLng ind=new LatLng(9.882838,78.082683);
    public LatLng gh=new LatLng(9.885211,78.080632);
    public LatLng ncc=new LatLng(9.883560,78.079803);
    public LatLng mhos=new LatLng(9.884738,78.080071);
    public LatLng ghos=new LatLng(9.878201,78.082072);
    public LatLng mcan=new LatLng(9.883264,78.079857);
    public LatLng fc=new LatLng(9.883282,78.083236);
    public LatLng ban=new LatLng(9.883496,78.079848);
    public LatLng temple=new LatLng(9.885459,78.080574);

    Polyline route;
    public String tittle = "Thiagarajar College of Engineering";
    final boolean checked_state[] = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false}; //The array that holds the checked state of the checkbox items
    final CharSequence[] day_check = {"Main Building", "IT", "CSE","ECE","EEE","CIVIL","MECH","MECHT","ARCH","Science Block","Freshers Block","NCC Block","Indoor","Outdoor","KS Auditorium","KM Auditorium","Placement Cell","Guest House","Main Canteen","Food Court","Mens Hostel","Womens Hostel","Library","Bank","Temple","Parking"}; //items in the alertdialog that displays checkboxes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.app_bar_home_id);
        setSupportActionBar(toolbar);
        searchIntent = getIntent();
        initMainBuildingCoordinates();
        initITCoordinates();
        initCSECoordinates();
        initECECoordinates();
        initEEECoordinates();
        initCivilCoordinates();
        initMechanicalCoordinates();
        initMechatronicsCoordinates();
        initArchCoordinates();
        initKMCoordinates();
        initScienceBlockCoordinates();
        initFreshersBlockCoordinates();
        initNCCBlockCoordinates();
        initIndoorCoordinates();
        initOutdoorCoordinates();
        initPlacementCellCoordinates();
        initGuestHouseCoordinates();
        initMainCanteenCoordinates();
        initFoodCourtCoordinates();
        initMensHostelCoordinates();
        initWomensHostelCoordinates();

        /*locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        provider = locationManager.getBestProvider(criteria, true);
        if (provider != null && !provider.equals(""))
        {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                return;
            }
            else
            {
                Location location = locationManager.getLastKnownLocation(provider);

                locationManager.requestLocationUpdates(provider, 20000, 1,this);

                if(location!=null)
                    onLocationChanged(location);
                else
                    Toast.makeText(getBaseContext(), "Location can't be retrieved", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(getBaseContext(), "No Provider Found", Toast.LENGTH_SHORT).show();
        }*/

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coord_id);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        if (Intent.ACTION_SEARCH.equals(searchIntent.getAction())) {
            try {
                searchQuery = searchIntent.getStringExtra(SearchManager.QUERY);
                if (searchQuery != null) {
                    Toast.makeText(getApplicationContext(),searchQuery,Toast.LENGTH_LONG).show();
                    toSearch(searchQuery);
                }
            } catch (Exception e) {
            }
        }
        textToSpeech=new TextToSpeech(this,this);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.dept_id1:
                        gotoIT();
                        break;
                    case R.id.dept_id2:
                        gotoCSE();
                        break;
                    case R.id.dept_id3:
                        gotoECE();
                        break;
                    case R.id.dept_id4:
                        gotoEEE();
                        break;
                    case R.id.dept_id5:
                        gotoCIVIL();
                        break;
                    case R.id.dept_id6:
                        gotoMECH();
                        break;
                    case R.id.dept_id7:
                        gotoMECHATRONICS();
                        break;
                    case R.id.dept_id8:
                        gotoARCH();
                        break;
                    case R.id.block_id1:
                        gotoSCIENCE_BLOCK();
                        break;
                    case R.id.block_id2:
                        gotoFRESHERS_BLOCK();
                        break;
                    case R.id.block_id3:
                        gotoNCC_BLOCK();
                        break;
                    case R.id.phy_edu_id1:
                        gotoINDOOR();
                        break;
                    case R.id.phy_edu_id2:
                        gotoOUTDOOR();
                        break;
                    case R.id.audi_id1:
                        gotoKS_AUDI();
                        break;
                    case R.id.audi_id2:
                        gotoKM_AUDI();
                        break;
                    case R.id.placement_id1:
                        gotoPLACEMENT_CELL();
                        break;
                    case R.id.placement_id2:
                        gotoGUEST_HOUSE();
                        break;
                    case R.id.canteen_id1:
                        gotoMAIN_CANTEEN();
                        break;
                    case R.id.canteen_id2:
                        gotoFOOD_COURT();
                        break;
                    case R.id.hostel_id1:
                        gotoMENS_HOSTEL();
                        break;
                    case R.id.hostel_id2:
                        gotoWOMENS_HOSTEL();
                        break;
                    case R.id.library_id:
                        gotoLIBRARY();
                        break;
                    case R.id.bank_id:
                        gotoBANK();
                        break;
                    case R.id.temple_id:
                        gotoTEMPLE();
                        break;
                    case R.id.parking_id:
                        gotoPARKING();
                        break;
                }
                mark.hideInfoWindow();
                mMap.clear();
                drawerLayout.closeDrawers();
                onMapReady(mMap);
                voiceInfo(tittle);
                return true;
            }
        });
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        fabtn = (FloatingActionButton) findViewById(R.id.fab_btn);
        fabtn2 = (FloatingActionButton) findViewById(R.id.fab_btn2);
        fabtn3 = (FloatingActionButton) findViewById(R.id.fab_btn3);
        fabbtn4=(FloatingActionButton)findViewById(R.id.fab_btn4);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        fab_clockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clock_wise);
        fab_anti_clockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anti_clockwise);
        fabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOPEN) {
                    fabtn2.startAnimation(fab_close);
                    fabtn3.startAnimation(fab_close);
                    fabbtn4.startAnimation(fab_close);
                    fabtn.startAnimation(fab_anti_clockwise);
                    fabtn2.setClickable(false);
                    fabtn3.setClickable(false);
                    fabbtn4.setClickable(false);
                    if(route!=null) {
                        route.remove();
                    }
                    if(to!=null) {
                        to.remove();
                    }
                    gotoMainBuilding();
                    onMapReady(mMap);
                    isOPEN = false;
                } else {
                    fabtn2.startAnimation(fab_open);
                    fabtn3.startAnimation(fab_open);
                    fabbtn4.startAnimation(fab_open);
                    fabtn.startAnimation(fab_clockwise);
                    fabtn2.setClickable(true);
                    fabtn3.setClickable(true);
                    fabbtn4.setClickable(true);
                    isOPEN = true;
                    fabtn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                            i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                            i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                            i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Search Place!!");
                            try {
                                startActivityForResult(i, 100);
                            } catch (ActivityNotFoundException a)
                            {
                                Snackbar snackbar = Snackbar.make(coordinatorLayout, "Sorry ur device doesn't support speech language", Snackbar.LENGTH_LONG);
                                snackbar.show();
                            }
                        }
                    });

                    fabtn3.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            showDialog(1);

                        }
                    });
                    fabbtn4.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v) {

                            Intent intent=new Intent(Home.this,NavigateScreen.class);
                            intent.putExtra("fromarray",fromArr);
                            startActivity(intent);
                        }
                    });


                }
            }
        }
        );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.refresh_id:
                if(mark!=null) {
                    mark.remove();
                }
                if(from!=null) {
                    from.remove();
                }
                if(to!=null) {
                    to.remove();
                }
                gotoMainBuilding();
                onMapReady(mMap);
                break;
        }
        return true;
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(Home.this)
                .setTitle("Choose From and To ")
                .setMultiChoiceItems(day_check,null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        //storing the checked state of the items in an array
                        checked_state[which] = isChecked;
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        String loc = "";
                        for (int i = 0; i < day_check.length; i++) {
                            if (checked_state[i]) {
                                loc = loc + "" + day_check[i];
                            }
                        }
                        Toast.makeText(Home.this, "selected locations " + loc, Toast.LENGTH_LONG).show();
                        //clears the array used to store checked state
                        for (int i = 0; i < checked_state.length; i++) {
                            if (checked_state[i]) {
                                checked_state[i] = false;
                            }
                        }
                        //used to dismiss the dialog upon user selection.
                        dialog.dismiss();
                        drawRoute(loc);
                    }
                });
        return builder1.create();
    }

    public void drawRoute(String choice)
    {
        switch (choice) {
            case "Main BuildingECE":
                drawPath(main,ece,"Main Building","ECE",MECE);
                break;
            case "Main BuildingIT":
                drawPath(main,it1,"Main Building","IT",MIT);
                break;
            case "Main BuildingLibrary":
                drawPath(main,lib,"Main Building","Library",MLIB);
                break;
            case "Main BuildingParking":
                drawPath(main,par,"Main Building","Parking",MPAR);
                break;
            case "Main BuildingMECH":
                drawPath(main,mec,"Main Building","Mechanical",MMECH);
                break;
            case "Main BuildingEEE":
                drawPath(main,eee,"Main Building","EEE",MEEE);
                break;
            case "Main BuildingKM Auditorium":
                drawPath(main,km,"Main Building","KM Auditorium",MKM);
                break;
            case "Main BuildingCIVIL":
                drawPath(main,cvl,"Main Building","Civil",MCVL);
                break;
            case "Main BuildingCSE":
                drawPath(main,cs,"Main Building","CSE",MCS);
                break;
            case "ITMain Building":
                drawPath(it1,main,"Information Technology","Main Building",IMAINBUILDING);
                break;
            case "ITMECH":
                drawPath(it1,mec,"Information Technology","Mechanical",IMECH);
                break;
            case "ITCSE":
                drawPath(it1,cs,"Information Technology","CSE",ICSE);
                break;
            case "ITECE":
                drawPath(it1,ece,"Information Technology","ECE",IECE);
                break;
            case "ITEEE":
                drawPath(it1,eee,"Information Technology","EEE",IEEE);
                break;
            case "ITCIVIL":
                drawPath(it1,cvl,"Information Technology","Civil",ICIVIL);
                break;
            case "ITMECHT":
                drawPath(it1,mect,"Information Technology","Mechatronics",IMECHT);
                break;
            case "ITARCH":
                drawPath(it1,arch,"Information Technology","Architecture",IARCH);
                break;
            case "ITScience Block":
                drawPath(it1,sci,"Information Technology","Science Block",ISCIENCEBLOCK);
                break;
            case "ITFreshers Block":
                drawPath(it1,bhalls,"Information Technology","Freshers Block",IFRESHERBLOCK);
                break;
            case "ITNCC Block":
                drawPath(it1,ncc,"Information Technology","NCC Block",INCCBLOCK);
                break;
            case "ITIndoor":
                drawPath(it1,ind,"Information Technology","Indoor",IINDOOR);
                break;
            case "ITOutdoor":
                drawPath(it1,out,"Information Technology","Outdoor",IOUTDOOR);
                break;
            case "ITKS Auditorium":
                drawPath(it1,ks,"Information Technology","KS Auditorium",IKSAUDITORIUM);
                break;
            case "ITKM Auditorium":
                drawPath(it1,km,"Information Technology","KM Auditorium",IKMAUDITORIUM);
                break;
            case "ITPlacement Cell":
                drawPath(it1,pc,"Information Technology","Placement Cell",IPLACEMENTCELL);
                break;
            case "ITGuest House":
                drawPath(it1,gh,"Information Technology","Guest House",IGUESTHOUSE);
                break;
            case "ITMens Hostel":
                drawPath(it1,mhos,"Information Technology","Mens Hostel",IMENSHOSTEL);
                break;
            case "ITWomens Hostel":
                drawPath(it1,ghos,"Information Technology","Womens Hostel",IWOMENSHOSTEL);
                break;
            case "ITMain Canteen":
                drawPath(it1,mcan,"Information Technology","Main Canteen",IMAINCANTEEN);
                break;
            case "ITFood Court":

                drawPath(it1,fc,"Information Technology","Food Court",IFOODCOURT);
                break;
            case "ITLibrary":
                drawPath(it1,lib,"Information Technology","Library",ILIBRARY);
                break;
            case "ITBank":
                drawPath(it1,ban,"Information Technology","Bank",IBANK);
                break;
            case "ITTemple":
                drawPath(it1,temple,"Information Technology","Temple",ITEMPLE);
                break;
            case "ITParking":
                drawPath(it1,par,"Information Technology","Parking",IPARKING);
                break;
            case "CSEMain Building":
                drawPath(cs,main,"CSE","Main Building",CMAINBUILDING);
                break;
            case "CSEMECH":
                drawPath(cs,mec,"CSE","Mechanical",CMECH);
                break;
            case "CSEIT":
                drawPath(cs,it1,"CSE","Information Technology",CIT);
                break;
            case "CSEECE":
                drawPath(cs,ece,"CSE","ECE",CECE);
                break;
            case "CSEEEE":
                drawPath(cs,eee,"CSE","EEE",CEEE);
                break;
            case "CSECIVIL":
                drawPath(cs,cvl,"CSE","Civil",CCIVIL);
                break;
            case "CSEMECHT":
                drawPath(cs,mect,"CSE","Mechatronics",CMECHT);
                break;
            case "CSEARCH":
                drawPath(cs,arch,"CSE","Architecture",CARCH);
                break;
            case "CSEScience Block":
                drawPath(cs,sci,"CSE","Science Block",CSCIENCEBLOCK);
                break;
            case "CSEFreshers Block":
                drawPath(cs,bhalls,"CSE","Freshers Block",CFRESHERBLOCK);
                break;
            case "CSENCC Block":
                drawPath(cs,ncc,"CSE","NCC Block",CNCCBLOCK);
                break;
            case "CSEIndoor":
                drawPath(cs,ind,"CSE","Indoor",CINDOOR);
                break;
            case "CSEOutdoor":
                drawPath(cs,out,"CSE","Outdoor",COUTDOOR);
                break;
            case "CSEKS Auditorium":
                drawPath(cs,ks,"CSE","KS Auditorium",CKSAUDITORIUM);
                break;
            case "CSEKM Auditorium":
                drawPath(cs,km,"CSE","KM Auditorium",CKMAUDITORIUM);
                break;
            case "CSEPlacement Cell":
                drawPath(cs,pc,"CSE","Placement Cell",CPLACEMENTCELL);
                break;
            case "CSEGuest House":
                drawPath(cs,gh,"CSE","Guest House",CGUESTHOUSE);
                break;
            case "CSEMens Hostel":
                drawPath(cs,mhos,"CSE","Mens Hostel",CMENSHOSTEL);
                break;
            case "CSEWomens Hostel":
                drawPath(cs,ghos,"CSE","Womens Hostel",CWOMENSHOSTEL);
                break;
            case "CSEMain Canteen":
                drawPath(cs,mcan,"CSE","Main Canteen",CMAINCANTEEN);
                break;
            case "CSEFood Court":
                drawPath(cs,fc,"CSE","Food Court",CFOODCOURT);
                break;
            case "CSELibrary":
                drawPath(cs,lib,"CSE","Library",CLIBRARY);
                break;
            case "CSEBank":
                drawPath(cs,ban,"CSE","Bank",CBANK);
                break;
            case "CSETemple":
                drawPath(cs,temple,"CSE","Temple",CTEMPLE);
                break;
            case "CSEParking":
                drawPath(cs,par,"CSE","Parking",CPARKING);
                break;
            case "ECEMain Building":
                drawPath(ece,main,"ECE","Main Building",ECMAINBUILDING);
                break;
            case "ECEMECH":
                drawPath(ece,mec,"ECE","Mechanical",ECMECH);
                break;
            case "ECEIT":
                drawPath(ece,it1,"ECE","Information Technology",ECIT);
                break;
            case "ECECSE":
                drawPath(ece,cs,"ECE","CSE",ECCSE);
                break;
            case "ECEEEE":
                drawPath(ece,eee,"ECE","EEE",ECEEE);
                break;
            case "ECECIVIL":
                drawPath(ece,cvl,"ECE","Civil",ECCIVIL);
                break;
            case "ECEMECHT":
                drawPath(ece,mect,"ECE","Mechatronics",ECMECHT);
                break;
            case "ECEARCH":
                drawPath(ece,arch,"ECE","Architecture",ECARCH);
                break;
            case "ECEScience Block":
                drawPath(ece,sci,"ECE","Science Block",ECSCIENCEBLOCK);
                break;
            case "ECEFreshers Block":
                drawPath(ece,bhalls,"ECE","Freshers Block",ECFRESHERBLOCK);
                break;
            case "ECENCC Block":
                drawPath(ece,ncc,"ECE","NCC Block",ECNCCBLOCK);
                break;
            case "ECEIndoor":
                drawPath(ece,ind,"ECE","Indoor",ECINDOOR);
                break;
            case "ECEOutdoor":
                drawPath(ece,out,"ECE","Outdoor",ECOUTDOOR);
                break;
            case "ECEKS Auditorium":
                drawPath(ece,ks,"ECE","KS Auditorium",ECKSAUDITORIUM);
                break;
            case "ECEKM Auditorium":
                drawPath(ece,km,"ECE","KM Auditorium",ECKMAUDITORIUM);
                break;
            case "ECEPlacement Cell":
                drawPath(ece,pc,"ECE","Placement Cell",ECPLACEMENTCELL);
                break;
            case "ECEGuest House":
                drawPath(ece,gh,"ECE","Guest House",ECGUESTHOUSE);
                break;
            case "ECEMens Hostel":
                drawPath(ece,mhos,"ECE","Mens Hostel",ECMENSHOSTEL);
                break;
            case "ECEWomens Hostel":
                drawPath(ece,ghos,"ECE","Womens Hostel",ECWOMENSHOSTEL);
                break;
            case "ECEMain Canteen":
                drawPath(ece,mcan,"ECE","Main Canteen",ECMAINCANTEEN);
                break;
            case "ECEFood Court":
                drawPath(ece,fc,"ECE","Food Court",ECFOODCOURT);
                break;
            case "ECELibrary":
                drawPath(ece,lib,"ECE","Library",ECLIBRARY);
                break;
            case "ECEBank":
                drawPath(ece,ban,"ECE","Bank",ECBANK);
                break;
            case "ECETemple":
                drawPath(ece,temple,"ECE","Temple",ECTEMPLE);
                break;
            case "ECEParking":
                drawPath(ece,par,"ECE","Parking",ECPARKING);
                break;
            case "EEEMain Building":
                drawPath(eee,main,"EEE","Main Building",EEMAINBUILDING);
                break;
            case "EEEMECH":
                drawPath(eee,mec,"EEE","Mechanical",EEMECH);
                break;
            case "EEEIT":
                drawPath(eee,it1,"EEE","Information Technology",EEIT);
                break;
            case "EEECSE":
                drawPath(eee,cs,"EEE","CSE",EECSE);
                break;
            case "EEEECE":
                drawPath(eee,ece,"EEE","ECE",EEECE);
                break;
            case "EEECIVIL":
                drawPath(eee,cvl,"EEE","Civil",EECIVIL);
                break;
            case "EEEMECHT":
                drawPath(eee,mect,"EEE","Mechatronics",EEMECHT);
                break;
            case "EEEARCH":
                drawPath(eee,arch,"EEE","Architecture",EEARCH);
                break;
            case "EEEScience Block":
                drawPath(eee,sci,"EEE","Science Block",EESCIENCEBLOCK);
                break;
            case "EEEFreshers Block":
                drawPath(eee,bhalls,"EEE","Freshers Block",EEFRESHERBLOCK);
                break;
            case "EEENCC Block":
                drawPath(eee,ncc,"EEE","NCC Block",EENCCBLOCK);
                break;
            case "EEEIndoor":
                drawPath(eee,ind,"EEE","Indoor",EEINDOOR);
                break;
            case "EEEOutdoor":
                drawPath(eee,out,"EEE","Outdoor",EEOUTDOOR);
                break;
            case "EEEKS Auditorium":
                drawPath(eee,ks,"EEE","KS Auditorium",EEKSAUDITORIUM);
                break;
            case "EEEKM Auditorium":
                drawPath(eee,km,"EEE","KM Auditorium",EEKMAUDITORIUM);
                break;
            case "EEEPlacement Cell":
                drawPath(eee,pc,"EEE","Placement cell",EEPLACEMENTCELL);
                break;
            case "EEEGuest House":
                drawPath(eee,gh,"EEE","Guest House",EEGUESTHOUSE);
                break;
            case "EEEMens Hostel":
                drawPath(eee,mhos,"EEE","Mens Hostel",EEMENSHOSTEL);
                break;
            case "EEEWomens Hostel":
                drawPath(eee,ghos,"EEE","Womens Hostel",EEWOMENSHOSTEL);
                break;
            case "EEEMain Canteen":
                drawPath(eee,mcan,"EEE","Main Canteen",EEMAINCANTEEN);
                break;
            case "EEEFood Court":
                drawPath(eee,fc,"EEE","Food Court",EEFOODCOURT);
                break;
            case "EEELibrary":
                drawPath(eee,lib,"EEE","Library",EELIBRARY);
                break;
            case "EEEBank":
                drawPath(eee,ban,"EEE","Bank",EEBANK);
                break;
            case "EEETemple":
                drawPath(eee,temple,"EEE","Temple",EETEMPLE);
                break;
            case "EEEParking":
                drawPath(eee,par,"EEE","Parking",EEPARKING);
                break;
            case "CIVILMain Building":
                drawPath(cvl,main,"Civil","Main Building",CIMAINBUILDING);
                break;
            case "CIVILMECH":
                drawPath(cvl,mec,"Civil","Mechanical",CIMECH);
                break;
            case "CIVILIT":
                drawPath(cvl,it1,"Civil","Information Technology",CIIT);
                break;
            case "CIVILCSE":
                drawPath(cvl,cs,"Civil","Computer Sciense",CICSE);
                break;
            case "CIVILECE":
                drawPath(cvl,ece,"Civil","ECE",CIECE);
                break;
            case "CIVILEEE":
                drawPath(cvl,eee,"Civil","EEE",CIEEE);
                break;
            case "CIVILMECHT":
                drawPath(cvl,mect,"Civil","Mechatronics",CIMECHT);
                break;
            case "CIVILARCH":
                drawPath(cvl,arch,"Civil","Architecture",CIARCH);
                break;
            case "CIVILScience Block":
                drawPath(cvl,sci,"Civil","Science Block",CISCIENCEBLOCK);
                break;
            case "CIVILFreshers Block":
                drawPath(cvl,bhalls,"Civil","Freshers Block",CIFRESHERBLOCK);
                break;
            case "CIVILNCC Block":
                drawPath(cvl,ncc,"Civil","NCC Block",CINCCBLOCK);
                break;
            case "CIVILIndoor":
                drawPath(cvl,ind,"Civil","Indoor",CIINDOOR);
                break;
            case "CIVILOutdoor":
                drawPath(cvl,out,"Civil","Outdoor",CIOUTDOOR);
                break;
            case "CIVILKS Auditorium":
                drawPath(cvl,ks,"Civil","KS Auditorium",CIKSAUDITORIUM);
                break;
            case "CIVILKM Auditorium":
                drawPath(cvl,km,"Civil","KM Auditorium",CIKMAUDITORIUM);
                break;
            case "CIVILPlacement Cell":
                drawPath(cvl,pc,"Civil","Placement Cell",CIPLACEMENTCELL);
                break;
            case "CIVILGuest House":
                drawPath(cvl,gh,"Civil","Guest House",CIGUESTHOUSE);
                break;
            case "CIVILMens Hostel":
                drawPath(cvl,mhos,"Civil","Mens Hostel",CIMENSHOSTEL);
                break;
            case "CIVILWomens Hostel":
                drawPath(cvl,ghos,"Civil","Womens Hostel",CIWOMENSHOSTEL);
                break;
            case "CIVILMain Canteen":
                drawPath(cvl,mcan,"Civil","Main Canteen",CIMAINCANTEEN);
                break;
            case "CIVILFood Court":
                drawPath(cvl,fc,"Civil","Food Court",CIFOODCOURT);
                break;
            case "CIVILLibrary":
                drawPath(cvl,lib,"Civil","Library",CILIBRARY);
                break;
            case "CIVILBank":
                drawPath(cvl,ban,"Civil","Bank",CIBANK);
                break;
            case "CIVILTemple":
                drawPath(cvl,temple,"Civil","Temple",CITEMPLE);
                break;
            case "CIVILParking":
                drawPath(cvl,par,"Civil","Parking",CIPARKING);
                break;
            case "MECHMain Building":
                drawPath(mec,main,"Mechanical","Main Building",MEMAINBUILDING);
                break;
            case "MECHCIVIL":
                drawPath(mec,cvl,"Mechanical","Civil",MECIVIL);
                break;
            case "MECHIT":
                drawPath(mec,it1,"Mechanical","Information Technology",MEIT);
                break;
            case "MECHCSE":
                drawPath(mec,cs,"Mechanical","CSE",MECE);
                break;
            case "MECHECE":
                drawPath(mec,ece,"Mechanical","ECE",MEECE);
                break;
            case "MECHEEE":
                drawPath(mec,eee,"Mechanical","EEE",MEEEE);
                break;
            case "MECHMECHT":
                drawPath(mec,mect,"Mechanical","Mechatronics",MEMECHT);
                break;
            case "MECHARCH":
                drawPath(mec,arch,"Mechanical","Architecture",MEARCH);
                break;
            case "MECHScience Block":
                drawPath(mec,sci,"Mechanical","Science Block",MESCIENCEBLOCK);
                break;
            case "MECHFreshers Block":
                drawPath(mec,bhalls,"Mechanical","Frehers Block",MEFRESHERBLOCK);
                break;
            case "MECHNCC Block":
                drawPath(mec,ncc,"Mechanical","NCC Block",MENCCBLOCK);
                break;
            case "MECHIndoor":
                drawPath(mec,ind,"Mechanical","Indoor",MEINDOOR);
                break;
            case "MECHOutdoor":
                drawPath(mec,out,"Mechanical","Outdoor",MEOUTDOOR);
                break;
            case "MECHKS Auditorium":
                drawPath(mec,ks,"Mechanical","KS Auditorium",MEKSAUDITORIUM);
                break;
            case "MECHKM Auditorium":
                drawPath(mec,km,"Mechanical","KM Aduitorium",MEKMAUDITORIUM);
                break;
            case "MECHPlacement Cell":
                drawPath(mec,pc,"Mechanical","Placement Cell",MEPLACEMENTCELL);
                break;
            case "MECHGuest House":
                drawPath(mec,gh,"Mechanical","Guest House",MEGUESTHOUSE);
                break;
            case "MECHMens Hostel":
                drawPath(mec,mhos,"Mechanical","Mens Hostel",MEMENSHOSTEL);
                break;
            case "MECHWomens Hostel":
                drawPath(mec,ghos,"Mechanical","Womens Hostel",MEWOMENSHOSTEL);
                break;
            case "MECHMain Canteen":
                drawPath(mec,mcan,"Mechanical","Main Canteen",MEMAINCANTEEN);
                break;
            case "MECHFood Court":
                drawPath(mec,fc,"Mechanical","Food Court",MEFOODCOURT);
                break;
            case "MECHLibrary":
                drawPath(mec,lib,"Mechanical","Library",MELIBRARY);
                break;
            case "MECHBank":
                drawPath(mec,ban,"Mechanical","Bank",MEBANK);
                break;
            case "MECHTemple":
                drawPath(mec,temple,"Mechanical","Temple",METEMPLE);
                break;
            case "MECHParking":
                drawPath(mec,par,"Mechanical","Parking",MEPARKING);
                break;
            case "MECHTMain Building":
                drawPath(mect,main,"Mechatronics","Main Building",MTMAINBUILDING);
                break;
            case "MECHTCIVIL":
                drawPath(mect,cvl,"Mechatronics","Civil",MTCIVIL);
                break;
            case "MECHTIT":
                drawPath(mect,it1,"Mechatronics","Information Technology",MTIT);
                break;
            case "MECHTCSE":
                drawPath(mect,cs,"Mechatronics","Computer Science",MTCSE);
                break;
            case "MECHTECE":
                drawPath(mect,ece,"Mechatronics","ECE",MTECE);
                break;
            case "MECHTEEE":
                drawPath(mect,eee,"Mechatronics","EEE",MTEEE);
                break;
            case "MECHTMECH":
                drawPath(mect,mec,"Mechatronics","Mechanical",MTMECH);
                break;
            case "MECHTARCH":
                drawPath(mect,arch,"Mechatronics","Architecture",MTARCH);
                break;
            case "MECHTScience Block":
                drawPath(mect,sci,"Mechatronics","Science Block",MTSCIENCEBLOCK);
                break;
            case "MECHTFreshers Block":
                drawPath(mect,bhalls,"Mechatronics","Freshers Block",MTFRESHERBLOCK);
                break;
            case "MECHTNCC Block":
                drawPath(mect,ncc,"Mechatronics","NCC Block",MTNCCBLOCK);
                break;
            case "MECHTIndoor":
                drawPath(mect,ind,"Mechatronics","Indoor",MTINDOOR);
                break;
            case "MECHTOutdoor":
                drawPath(mect,out,"Mechatronics","Outdoor",MTOUTDOOR);
                break;
            case "MECHTKS Auditorium":
                drawPath(mect,ks,"Mechatronics","KS Auditorium",MTKSAUDITORIUM);
                break;
            case "MECHTKM Auditorium":
                drawPath(mect,km,"Mechatronics","KM Auditorium",MTKMAUDITORIUM);
                break;
            case "MECHTPlacement Cell":
                drawPath(mect,pc,"Mechatronics","Placement Cell",MTPLACEMENTCELL);
                break;
            case "MECHTGuest House":
                drawPath(mect,gh,"Mechatronics","Guest Housing",MTGUESTHOUSE);
                break;
            case "MECHTMens Hostel":
                drawPath(mect,mhos,"Mechatronics","Mens Hostel",MTMENSHOSTEL);
                break;
            case "MECHTWomens Hostel":
                drawPath(mect,ghos,"Mechatronics","Womens Hostel",MTWOMENSHOSTEL);
                break;
            case "MECHTMain Canteen":
                drawPath(mect,mcan,"Mechatronics","Main Canteen",MTMAINCANTEEN);
                break;
            case "MECHTFood Court":
                drawPath(mect,fc,"Mechatronics","Food Court",MTFOODCOURT);
                break;
            case "MECHTLibrary":
                drawPath(mect,lib,"Mechatronics","Library",MTLIBRARY);
                break;
            case "MECHTBank":
                drawPath(mect,ban,"Mechatronics","Bank",MTBANK);
                break;
            case "MECHTTemple":
                drawPath(mect,temple,"Mechatronics","Temple",MTTEMPLE);
                break;
            case "MECHTParking":
                drawPath(mect,par,"Mechatronics","Parking",MTPARKING);
                break;
            case "ARCHMain Building":
                drawPath(arch,main,"Architecture","Main Building",AMAINBUILDING);
                break;
            case "ARCHCIVIL":
                drawPath(arch,cvl,"Architecture","Civil",ACIVIL);
                break;
            case "ARCHIT":
                drawPath(arch,it1,"Architecture","Information Technology",AIT);
                break;
            case "ARCHCSE":
                drawPath(arch,cs,"Architecture","Computer Science",ACSE);
                break;
            case "ARCHECE":
                drawPath(arch,ece,"Architecture","ECE",AECE);
                break;
            case "ARCHEEE":
                drawPath(arch,eee,"Architecture","EEE",AEEE);
                break;
            case "ARCHMECH":
                drawPath(arch,mec,"Architecture","Mechanical",AMECH);
                break;
            case "ARCHMECT":
                drawPath(arch,mect,"Architecture","Civil",AMECHT);
                break;
            case "ARCHScience Block":
                drawPath(arch,sci,"Architecture","Science Block",ASCIENCEBLOCK);
                break;
            case "ARCHFreshers Block":
                drawPath(arch,bhalls,"Architecture","Freshers Block",AFRESHERBLOCK);
                break;
            case "ARCHNCC Block":
                drawPath(arch,ncc,"Architecture","NCC Block",ANCCBLOCK);
                break;
            case "ARCHIndoor":
                drawPath(arch,ind,"Architecture","Indoor",AINDOOR);
                break;
            case "ARCHOutdoor":
                drawPath(arch,out,"Architecture","Outdoor",AOUTDOOR);
                break;
            case "ARCHKS Auditorium":
                drawPath(arch,ks,"Architecture","KS Auditorium",AKSAUDITORIUM);
                break;
            case "ARCHKM Auditorium":
                drawPath(arch,km,"Architecture","KM Auditorium",AKMAUDITORIUM);
                break;
            case "ARCHPlacement Cell":
                drawPath(arch,pc,"Architecture","Placement Cell",APLACEMENTCELL);
                break;
            case "ARCHGuest House":
                drawPath(arch,gh,"Architecture","Guest House",AGUESTHOUSE);
                break;
            case "ARCHMens Hostel":
                drawPath(arch,mhos,"Architecture","Mens Hostel",AMENSHOSTEL);
                break;
            case "ARCHWomens Hostel":
                drawPath(arch,ghos,"Architecture","Womens Hostel",AWOMENSHOSTEL);
                break;
            case "ARCHMain Canteen":
                drawPath(arch,mcan,"Architecture","Main Canteen",AMAINCANTEEN);
                break;
            case "ARCHFood Court":
                drawPath(arch,fc,"Architecture","Food Court",AFOODCOURT);
                break;
            case "ARCHLibrary":
                drawPath(arch,lib,"Architecture","Library",ALIBRARY);
                break;
            case "ARCHBank":
                drawPath(arch,ban,"Architecture","Bank",ABANK);
                break;
            case "ARCHTemple":
                drawPath(arch,temple,"Architecture","Temple",ATEMPLE);
                break;
            case "ARCHParking":
                drawPath(arch,par,"Architecture","Parking",APARKING);
                break;
            case "KM AuditoriumMain Building":
                drawPath(km,main,"KM Auditorium","Main Building",KMMAINBUILDING);
                break;
            case "KM AuditoriumCIVIL":
                drawPath(km,cvl,"KM Auditorium","Civil",KMCIVIL);
                break;
            case "KM AuditoriumIT":
                drawPath(km,it1,"KM Auditorium","Information Technology",KMIT);
                break;
            case "KM AuditoriumCSE":
                drawPath(km,sci,"KM Auditorium","Computer Science",KMCSE);
                break;
            case "KM AuditoriumECE":
                drawPath(km,ece,"KM Auditorium","ECE",KMECE);
                break;
            case "KM AuditoriumEEE":
                drawPath(km,eee,"KM Auditorium","EEE",KMEEE);
                break;
            case "KM AuditoriumMECH":
                drawPath(km,mec,"KM Auditorium","Mechanical",KMMECH);
                break;
            case "KM AuditoriumMECHT":
                drawPath(km,mect,"KM Auditorium","Mechatronics",KMMECHT);
                break;
            case "KM AuditoriumScience Block":
                drawPath(km,sci,"KM Auditorium","Science Block",KMSCIENCEBLOCK);
                break;
            case "KM AuditoriumFreshers Block":
                drawPath(km,bhalls,"KM Auditorium","Freshers Block",KMFRESHERBLOCK);
                break;
            case "KM AuditoriumNCC Block":
                drawPath(km,ncc,"KM Auditorium","NCC Block",KMNCCBLOCK);
                break;
            case "KM AuditoriumIndoor":
                drawPath(km,ind,"KM Auditorium","Indoor",KMINDOOR);
                break;
            case "KM AuditoriumOutdoor":
                drawPath(km,out,"KM Auditorium","Outdoor",KMOUTDOOR);
                break;
            case "KM AuditoriumARCH":
                drawPath(km,arch,"KM Auditorium","Architecture",KMARCH);
                break;
            case "KM AuditoriumKS Auditorium":
                drawPath(km,ks,"KM Auditorium","KS Auditorium",KMKSAUDITORIUM);
                break;
            case "KM AuditoriumPlacement Cell":
                drawPath(km,pc,"KM Auditorium","Placement Cell",KMPLACEMENTCELL);
                break;
            case "KM AuditoriumGuest House":
                drawPath(km,gh,"KM Auditorium","Guest House",KMGUESTHOUSE);
                break;
            case "KM AuditoriumMens Hostel":
                drawPath(km,mhos,"KM Auditorium","Mens Hostel",KMMENSHOSTEL);
                break;
            case "KM AuditoriumWomens Hostel":
                drawPath(km,ghos,"KM Auditorium","Womens Hostel",KMWOMENSHOSTEL);
                break;
            case "KM AuditoriumMain Canteen":
                drawPath(km,mcan,"KM Auditorium","Main Canteen",KMMAINCANTEEN);
                break;
            case "KM AuditoriumFood Court":
                drawPath(km,fc,"KM Auditorium","Food Court",KMFOODCOURT);
                break;
            case "KM AuditoriumLibrary":
                drawPath(km,lib,"KM Auditorium","Library",KMLIBRARY);
                break;
            case "KM AuditoriumBank":
                drawPath(km,ban,"KM Auditorium","Bank",KMBANK);
                break;
            case "KM AuditoriumTemple":
                drawPath(km,temple,"KM Auditorium","Temple",KMTEMPLE);
                break;
            case "KM AuditoriumParking":
                drawPath(km,par,"KM Auditorium","Parking",KMPARKING);
                break;
            case "KS AuditoriumMain Building":
                drawPath(ks,main,"KS Auditorium","MAin Building",KSMAINBUILDING);
                break;
            case "KS AuditoriumCIVIL":
                drawPath(ks,cvl,"KS Auditorium","Civil",KSCIVIL);
                break;
            case "KS AuditoriumIT":
                drawPath(ks,it1,"KS Auditorium","Information Technology",KSIT);
                break;
            case "KS AuditoriumCSE":
                drawPath(ks,cs,"KS Auditorium","Computer Science",KSCSE);
                break;
            case "KS AuditoriumECE":
                drawPath(ks,ece,"KS Auditorium","ECE",KSECE);
                break;
            case "KS AuditoriumEEE":
                drawPath(ks,eee,"KS Auditorium","EEE",KSEEE);
                break;
            case "KS AuditoriumMECH":
                drawPath(ks,mec,"KS Auditorium","Mechanical",KSMECH);
                break;
            case "KS AuditoriumMECHT":
                drawPath(ks,mect,"KS Auditorium","Mechatronics",KSMECHT);
                break;
            case "KS AuditoriumScience Block":
                drawPath(ks,sci,"KS Auditorium","Science Block",KSSCIENCEBLOCK);
                break;
            case "KS AuditoriumFreshers Block":
                drawPath(ks,bhalls,"KS Auditorium","Freshers Block",KSFRESHERBLOCK);
                break;
            case "KS AuditoriumNCC Block":
                drawPath(ks,ncc,"KS Auditorium","NCC Block",KSNCCBLOCK);
                break;
            case "KS AuditoriumIndoor":
                drawPath(ks,ind,"KS Auditorium","Indoor",KSINDOOR);
                break;
            case "KS AuditoriumOutdoor":
                drawPath(ks,out,"KS Auditorium","Outdoor",KSOUTDOOR);
                break;
            case "KS AuditoriumARCH":
                drawPath(ks,arch,"KS Auditorium","Architecture",KSARCH);
                break;
            case "KS AuditoriumKM Auditorium":
                drawPath(ks,km,"KS Auditorium","KM Auditorium",KSKMAUDITORIUM);
                break;
            case "KS AuditoriumPlacement Cell":
                drawPath(ks,pc,"KS Auditorium","Placement Cell",KSPLACEMENTCELL);
                break;
            case "KS AuditoriumGuest House":
                drawPath(ks,gh,"KS Auditorium","Guest House",KSGUESTHOUSE);
                break;
            case "KS AuditoriumMens Hostel":
                drawPath(ks,mhos,"KS Auditorium","Mens Hostel",KSMENSHOSTEL);
                break;
            case "KS AuditoriumWomens Hostel":
                drawPath(ks,ghos,"KS Auditorium","Womens Hostel",KSWOMENSHOSTEL);
                break;
            case "KS AuditoriumMain Canteen":
                drawPath(ks,mcan,"KS Auditorium","Main Canteen",KSMAINCANTEEN);
                break;
            case "KS AuditoriumFood Court":
                drawPath(ks,fc,"KS Auditorium","Food Court",KSFOODCOURT);
                break;
            case "KS AuditoriumLibrary":
                drawPath(ks,lib,"KS Auditorium","Library",KSLIBRARY);
                break;
            case "KS AuditoriumBank":
                drawPath(ks,ban,"KS Auditorium","Bank",KSBANK);
                break;
            case "KS AuditoriumTemple":
                drawPath(ks,temple,"KS Auditorium","Temple",KSTEMPLE);
                break;
            case "KS AuditoriumParking":
                drawPath(ks,par,"KS Auditorium","Parking",KSPARKING);
                break;
            case "Science BlockMain Building":
                drawPath(sci,main,"Science Block","Main Building",SBMAINBUILDING);
                break;
            case "Science BlockCIVIL":
                drawPath(sci,cvl,"Science Block","Civil",SBCIVIL);
                break;
            case "Science BlockIT":
                drawPath(sci,it1,"Science Block","Information Technology",SBIT);
                break;
            case "Science BlockCSE":
                drawPath(sci,cs,"Science Block","Computer Science",SBCSE);
                break;
            case "Science BlockECE":
                drawPath(sci,ece,"Science Block","ECE",SBECE);
                break;
            case "Science BlockEEE":
                drawPath(sci,eee,"Science Block","EEE",SBEEE);
                break;
            case "Science BlockMECH":
                drawPath(sci,mec,"Science Block","Mechanical",SBMECH);
                break;
            case "Science BlockMECHT":
                drawPath(sci,main,"Science Block","Main Building",SBMECHT);
                break;
            case "Science BlockFreshers Block":
                drawPath(sci,bhalls,"Science Block","Freshers Block",SBFRESHERBLOCK);
                break;
            case "Science BlockLibrary":
                drawPath(sci,lib,"Science Block","Library",SBLIBRARY);
                break;
            case "Science BlockNCC Block":
                drawPath(sci,ncc,"Science Block","NCC Block",SBNCCBLOCK);
                break;
            case "Science BlockIndoor":
                drawPath(sci,ind,"Science Block","Indoor",SBINDOOR);
                break;
            case "Science BlockKS Auditorium":
                drawPath(sci,ks,"Science Block","KS Auditorium",SBKSAUDITORIUM);
                break;
            case "Science BlockARCH":
                drawPath(sci,arch,"Science Block","Architecture",SBARCH);
                break;
            case "Science BlockKM Auditorium":
                drawPath(sci,km,"Science Block","KM Auditorium",SBKMAUDITORIUM);
                break;
            case "Science BlockOutdoor":
                drawPath(sci,out,"Science Block","Outdoor",SBOUTDOOR);
                break;
            case "Science BlockGuest House":
                drawPath(sci,gh,"Science Block","Guest House",SBGUESTHOUSE);
                break;
            case "Science BlockMens Hostel":
                drawPath(sci,mhos,"Science Block","Mens Hostel",SBMENSHOSTEL);
                break;
            case "Science BlockWomens Hostel":
                drawPath(sci,ghos,"Science Block","Womens Hostel",SBWOMENSHOSTEL);
                break;
            case "Science BlockMain Canteen":
                drawPath(sci,mcan,"Science Block","Main Canteen",SBMAINCANTEEN);
                break;
            case "Science BlockFood Court":
                drawPath(sci,fc,"Science Block","Food Court",SBFOODCOURT);
                break;
            case "Science BlockPlacement Cell":
                drawPath(sci,pc,"Science Block","Placement Cell",SBPLACEMENTCELL);
                break;
            case "Science BlockBank":
                drawPath(sci,ban,"Science Block","Bank",SBBANK);
                break;
            case "Science BlockTemple":
                drawPath(sci,temple,"Science Block","Temple",SBTEMPLE);
                break;
            case "Science BlockParking":
                drawPath(sci,par,"Science Block","Parking",SBPARKING);
                break;
            case "Freshers BlockMain Building":
                drawPath(bhalls,main,"Freshers Block","Main Building",FBMAINBUILDING);
                break;
            case "Freshers BlockCIVIL":
                drawPath(bhalls,cvl,"Freshers Block","Civil",FBCIVIL);
                break;
            case "Freshers BlockIT":
                drawPath(bhalls,it1,"Freshers Block","Information Technology",FBIT);
                break;
            case "Freshers BlockCSE":
                drawPath(bhalls,cs,"Freshers Block","Computer Science",FBCSE);
                break;
            case "Freshers BlockECE":
                drawPath(bhalls,ece,"Freshers Block","ECE",FBECE);
                break;
            case "Freshers BlockEEE":
                drawPath(bhalls,eee,"Freshers Block","EEE",FBEEE);
                break;
            case "Freshers BlockMECH":
                drawPath(bhalls,mec,"Freshers Block","Mechanical",FBMECH);
                break;
            case "Freshers BlockMECHT":
                drawPath(bhalls,mect,"Freshers Block","Mechatronics",FBMECHT);
                break;
            case "Freshers BlockScience Block":
                drawPath(bhalls,sci,"Freshers Block","Science Block",FBSCIENCEBLOCK);
                break;
            case "Freshers BlockLibrary":
                drawPath(bhalls,lib,"Freshers Block","Library",FBLIBRARY);
                break;
            case "Freshers BlockNCC Block":
                drawPath(bhalls,ncc,"Freshers Block","NCC Block",FBNCCBLOCK);
                break;
            case "Freshers BlockIndoor":
                drawPath(bhalls,ind,"Freshers Block","Indoor",FBINDOOR);
                break;
            case "Freshers BlockKS Auditorium":
                drawPath(bhalls,ks,"Freshers Block","KS Auditorium",FBKSAUDITORIUM);
                break;
            case "Freshers BlockARCH":
                drawPath(bhalls,arch,"Freshers Block","Architecture",FBARCH);
                break;
            case "Freshers BlockKM Auditorium":
                drawPath(bhalls,km,"Freshers Block","KM Auditorium",FBKMAUDITORIUM);
                break;
            case "Freshers BlockOutdoor":
                drawPath(bhalls,out,"Freshers Block","Outdoor",FBOUTDOOR);
                break;
            case "Freshers BlockGuest House":
                drawPath(bhalls,gh,"Freshers Block","Guest House",FBGUESTHOUSE);
                break;
            case "Freshers BlockMens Hostel":
                drawPath(bhalls,mhos,"Freshers Block","Mens Hostel",FBMENSHOSTEL);
                break;
            case "Freshers BlockWomens Hostel":
                drawPath(bhalls,ghos,"Freshers Block","Womens Hostel",FBWOMENSHOSTEL);
                break;
            case "Freshers BlockMain Canteen":
                drawPath(bhalls,mcan,"Freshers Block","Main Canteen",FBMAINCANTEEN);
                break;
            case "Freshers BlockFood Court":
                drawPath(bhalls,fc,"Freshers Block","Food Court",FBFOODCOURT);
                break;
            case "Freshers BlockPlacement Cell":
                drawPath(bhalls,main,"Freshers Block","Placement Cell",FBPLACEMENTCELL);
                break;
            case "Freshers BlockBank":
                drawPath(bhalls,ban,"Freshers Block","Bank",FBBANK);
                break;
            case "Freshers BlockTemple":
                drawPath(bhalls,temple,"Freshers Block","Temple",FBTEMPLE);
                break;
            case "Freshers BlockParking":
                drawPath(bhalls,par,"Freshers Block","Parking",FBPARKING);
                break;
            case "NCC BlockMain Building":
                drawPath(ncc,main,"NCC Block","Main Building",NCCBMAINBUILDING);
                break;
            case "NCC BlockCIVIL":
                drawPath(ncc,cvl,"NCC Block","Civil",NCCBCIVIL);
                break;
            case "NCC BlockIT":
                drawPath(ncc,it1,"NCC Block","Information Technology",NCCBIT);
                break;
            case "NCC BlockCSE":
                drawPath(ncc,cs,"NCC Block","Computer Science",NCCBCSE);
                break;
            case "NCC BlockECE":
                drawPath(ncc,ece,"NCC Block","ECE",NCCBECE);
                break;
            case "NCC BlockEEE":
                drawPath(ncc,eee,"NCC Block","EEE",NCCBEEE);
                break;
            case "NCC BlockMECH":
                drawPath(ncc,mec,"NCC Block","Mechanical",NCCBMECH);
                break;
            case "NCC BlockMECHT":
                drawPath(ncc,mect,"NCC Block","Mechatronics",NCCBMECHT);
                break;
            case "NCC BlockScience Block":
                drawPath(ncc,sci,"NCC Block","Science Block",NCCBSCIENCEBLOCK);
                break;
            case "NCC BlockLibrary":
                drawPath(ncc,lib,"NCC Block","Library",NCCBLIBRARY);
                break;
            case "NCC BlockFreshers Block":
                drawPath(ncc,fc,"NCC Block","Freshers Block",NCCBFRESHERBLOCK);
                break;
            case "NCC BlockIndoor":
                drawPath(ncc,ind,"NCC Block","Indoor",NCCBINDOOR);
                break;
            case "NCC BlockKS Auditorium":
                drawPath(ncc,ks,"NCC Block","KS Auditorium",NCCBKSAUDITORIUM);
                break;
            case "NCC BlockARCH":
                drawPath(ncc,ncc,"NCC Block","Architecture",NCCBARCH);
                break;
            case "NCC BlockKM Auditorium":
                drawPath(ncc,km,"NCC Block","KM Auditorium",NCCBKMAUDITORIUM);
                break;
            case "NCC BlockOutdoor":
                drawPath(ncc,out,"NCC Block","Outdoor",NCCBOUTDOOR);
                break;
            case "NCC BlockGuest House":
                drawPath(ncc,gh,"NCC Block","Guest House",NCCBGUESTHOUSE);
                break;
            case "NCC BlockMens Hostel":
                drawPath(ncc,mhos,"NCC Block","Mens Hostel",NCCBMENSHOSTEL);
                break;
            case "NCC BlockWomens Hostel":
                drawPath(ncc,ghos,"NCC Block","Womens Hostel",NCCBWOMENSHOSTEL);
                break;
            case "NCC BlockMain Canteen":
                drawPath(ncc,mcan,"NCC Block","Main Canteen",NCCBMAINCANTEEN);
                break;
            case "NCC BlockFood Court":
                drawPath(ncc,fc,"NCC Block","Food Court",NCCBFOODCOURT);
                break;
            case "NCC BlockPlacement Cell":
                drawPath(ncc,pc,"NCC Block","Placement Cell",NCCBPLACEMENTCELL);
                break;
            case "NCC BlockBank":
                drawPath(ncc,ban,"NCC Block","Bank",NCCBBANK);
                break;
            case "NCC BlockTemple":
                drawPath(ncc,temple,"NCC Block","Temple",NCCBTEMPLE);
                break;
            case "NCC BlockParking":
                drawPath(ncc,par,"NCC Block","Parking",NCCBPARKING);
                break;
            case "IndoorMain Building":
                drawPath(ind,main,"Indoor","Main Building",INMAINBUILDING);
                break;
            case "IndoorCIVIL":
                drawPath(ind,cvl,"Indoor","Civil",INCIVIL);
                break;
            case "IndoorIT":
                drawPath(ind,it1,"Indoor","Information Technology",INIT);
                break;
            case "IndoorCSE":
                drawPath(ind,sci,"Indoor","Computer Science",INCSE);
                break;
            case "IndoorECE":
                drawPath(ind,ece,"Indoor","ECE",INECE);
                break;
            case "IndoorEEE":
                drawPath(ind,eee,"Indoor","EEE",INEEE);
                break;
            case "IndoorMECH":
                drawPath(ind,mec,"Indoor","Mechanical",INMECH);
                break;
            case "IndoorMECHT":
                drawPath(ind,mect,"Indoor","Mechatronics",INMECHT);
                break;
            case "IndoorScience Block":
                drawPath(ind,sci,"Indoor","Science Block",INSCIENCEBLOCK);
                break;
            case "IndoorLibrary":
                drawPath(ind,lib,"Indoor","Library",INLIBRARY);
                break;
            case "IndoorNCC Block":
                drawPath(ind,ncc,"Indoor","NCC Block",INNCCBLOCK);
                break;
            case "IndoorFreshers Block":
                drawPath(ind,bhalls,"Indoor","Freshers Block",INFRESHERBLOCK);
                break;
            case "IndoorKS Auditorium":
                drawPath(ind,ks,"Indoor","KS Auditorium",INKSAUDITORIUM);
                break;
            case "IndoorARCH":
                drawPath(ind,arch,"Indoor","Architecture",INARCH);
                break;
            case "IndoorKM Auditorium":
                drawPath(ind,km,"Indoor","KM Auditorium",INKMAUDITORIUM);
                break;
            case "IndoorOutdoor":
                drawPath(ind,out,"Indoor","Outdoor",INOUTDOOR);
                break;
            case "IndoorGuest House":
                drawPath(ind,gh,"Indoor","Guest House",INGUESTHOUSE);
                break;
            case "IndoorMens Hostel":
                drawPath(ind,mhos,"Indoor","Mens Hostel",INMENSHOSTEL);
                break;
            case "IndoorWomens Hostel":
                drawPath(ind,ghos,"Indoor","Womens Hostel",INWOMENSHOSTEL);
                break;
            case "IndoorMain Canteen":
                drawPath(ind,mcan,"Indoor","Main Canteen",INMAINCANTEEN);
                break;
            case "IndoorFood Court":
                drawPath(ind,fc,"Indoor","Food Court",INFOODCOURT);
                break;
            case "IndoorPlacement Cell":
                drawPath(ind,pc,"Indoor","Placement Cell",INPLACEMENTCELL);
                break;
            case "IndoorBank":
                drawPath(ind,ban,"Indoor","Bank",INBANK);
                break;
            case "IndoorTemple":
                drawPath(ind,temple,"Indoor","Temple",INTEMPLE);
                break;
            case "IndoorParking":
                drawPath(ind,par,"Indoor","Civil",INPARKING);
                break;
            case "OutdoorMain Building":
                drawPath(out,main,"Outdoor","Main Building",OUTMAINBUILDING);
                break;
            case "OutdoorCIVIL":
                drawPath(out,cvl,"Outdoor","Civil",OUTCIVIL);
                break;
            case "OutdoorIT":
                drawPath(out,it1,"Outdoor","Information Technology",OUTIT);
                break;
            case "OutdoorCSE":
                drawPath(out,cs,"Outdoor","Computer Science",OUTCSE);
                break;
            case "OutdoorECE":
                drawPath(out,ece,"Outdoor","ECE",OUTECE);
                break;
            case "OutdoorEEE":
                drawPath(out,eee,"Outdoor","EEE",OUTEEE);
                break;
            case "OutdoorMECH":
                drawPath(out,mec,"Outdoor","Mechanical",OUTMECH);
                break;
            case "OutdoorMECHT":
                drawPath(out,mect,"Outdoor","Mechatronics",OUTMECHT);
                break;
            case "OutdoorScience Block":
                drawPath(out,sci,"Outdoor","Science Block",OUTSCIENCEBLOCK);
                break;
            case "OutdoorFreshers Block":
                drawPath(out,bhalls,"Outdoor","Freshers Block",OUTFRESHERBLOCK);
                break;
            case "OutdoorNCC Block":
                drawPath(out,ncc,"Outdoor","NCC Block",OUTNCCBLOCK);
                break;
            case "OutdoorIndoor":
                drawPath(out,ind,"Outdoor","Indoor",OUTINDOOR);
                break;
            case "OutdoorKS Auditorium":
                drawPath(out,ks,"Outdoor","KS Auditorium",OUTKSAUDITORIUM);
                break;
            case "OutdoorARCH":
                drawPath(out,arch,"Outdoor","Architecture",OUTARCH);
                break;
            case "OutdoorKM Auditorium":
                drawPath(out,km,"Outdoor","KM Auditorium",OUTKMAUDITORIUM);
                break;
            case "OutdoorPlacement Cell":
                drawPath(out,pc,"Outdoor","Placement Cell",OUTPLACEMENTCELL);
                break;
            case "OutdoorGuest House":
                drawPath(out,gh,"Outdoor","Guest House",OUTGUESTHOUSE);
                break;
            case "OutdoorMens Hostel":
                drawPath(out,mhos,"Outdoor","Mens Hostel",OUTMENSHOSTEL);
                break;
            case "OutdoorWomens Hostel":
                drawPath(out,ghos,"Outdoor","Womens Hostel",OUTWOMENSHOSTEL);
                break;
            case "OutdoorMain Canteen":
                drawPath(out,mcan,"Outdoor","Main Canteen",OUTMAINCANTEEN);
                break;
            case "OutdoorFood Court":
                drawPath(out,fc,"Outdoor","Food Court",OUTFOODCOURT);
                break;
            case "OutdoorLibrary":
                drawPath(out,lib,"Outdoor","Library",OUTLIBRARY);
                break;
            case "OutdoorBank":
                drawPath(out,ban,"Outdoor","Bank",OUTBANK);
                break;
            case "OutdoorTemple":
                drawPath(out,temple,"Outdoor","Temple",OUTTEMPLE);
                break;
            case "OutdoorParking":
                drawPath(out,par,"Outdoor","Parking",OUTPARKING);
                break;
            case "Placement CellMain Building":
                drawPath(pc,main,"Placement Cell","Main Building",PCMAINBUILDING);
                break;
            case "Placement CellCIVIL":
                drawPath(pc,cvl,"Placement Cell","Civil",PCCIVIL);
                break;
            case "Placement CellIT":
                drawPath(pc,it1,"Placement Cell","Information Technology",PCIT);
                break;
            case "Placement CellCSE":
                drawPath(pc,cs,"Placement Cell","Computer Science",PCCSE);
                break;
            case "Placement CellECE":
                drawPath(pc,ece,"Placement Cell","ECE",PCECE);
                break;
            case "Placement CellEEE":
                drawPath(pc,eee,"Placement Cell","EEE",PCEEE);
                break;
            case "Placement CellMECH":
                drawPath(pc,mec,"Placement Cell","Mechanical",PCMECH);
                break;
            case "Placement CellMECHT":
                drawPath(pc,mec,"Placement Cell","Mechatronics",PCMECHT);
                break;
            case "Placement CellScience Block":
                drawPath(pc,sci,"Placement Cell","Science Block",PCSCIENCEBLOCK);
                break;
            case "Placement CellFreshers Block":
                drawPath(pc,bhalls,"Placement Cell","Freshers Block",PCFRESHERBLOCK);
                break;
            case "Placement CellNCC Block":
                drawPath(pc,ncc,"Placement Cell","NCC Block",PCNCCBLOCK);
                break;
            case "Placement CellIndoor":
                drawPath(pc,ind,"Placement Cell","Indoor",PCINDOOR);
                break;
            case "Placement CellKS Auditorium":
                drawPath(pc,ks,"Placement Cell","KS Auditorium",PCKSAUDITORIUM);
                break;
            case "Placement CellARCH":
                drawPath(pc,arch,"Placement Cell","Architecture",PCARCH);
                break;
            case "Placement CellKM Auditorium":
                drawPath(pc,km,"Placement Cell","KM Auditorium",PCKMAUDITORIUM);
                break;
            case "Placement CellOutdoor":
                drawPath(pc,out,"Placement Cell","Outdoor",PCOUTDOOR);
                break;
            case "Placement CellGuest House":
                drawPath(pc,gh,"Placement Cell","Guest House",PCGUESTHOUSE);
                break;
            case "Placement CellMens Hostel":
                drawPath(pc,mhos,"Placement Cell","Mens Hostel",PCMENSHOSTEL);
                break;
            case "Placement CellWomens Hostel":
                drawPath(pc,ghos,"Placement Cell","Womens Hostel",PCWOMENSHOSTEL);
                break;
            case "Placement CellMain Canteen":
                drawPath(pc,mcan,"Placement Cell","Main Canteen",PCMAINCANTEEN);
                break;
            case "Placement CellFood Court":
                drawPath(pc,fc,"Placement Cell","Food Court",PCFOODCOURT);
                break;
            case "Placement CellLibrary":
                drawPath(pc,lib,"Placement Cell","Library",PCLIBRARY);
                break;
            case "Placement CellBank":
                drawPath(pc,ban,"Placement Cell","Bank",PCBANK);
                break;
            case "Placement CellTemple":
                drawPath(pc,temple,"Placement Cell","Temple",PCTEMPLE);
                break;
            case "Placement CellParking":
                drawPath(pc,par,"Placement Cell","Parking",PCPARKING);
                break;
            case "Guest HouseMain Building":
                drawPath(gh,main,"Guest House","Main Building",GHMAINBUILDING);
                break;
            case "Guest HouseCIVIL":
                drawPath(gh,cvl,"Guest House","Civil",GHCIVIL);
                break;
            case "Guest HouseIT":
                drawPath(gh,it1,"Guest House","Information Technology",GHIT);
                break;
            case "Guest HouseCSE":
                drawPath(gh,cs,"Guest House","Computer Science",GHCSE);
                break;
            case "Guest HouseECE":
                drawPath(gh,ece,"Guest House","ECE",GHECE);
                break;
            case "Guest HouseEEE":
                drawPath(gh,eee,"Guest House","EEE",GHEEE);
                break;
            case "Guest HouseMECH":
                drawPath(gh,mec,"Guest House","Mechanical",GHMECH);
                break;
            case "Guest HouseMECHT":
                drawPath(gh,mect,"Guest House","MEchatronics",GHMECHT);
                break;
            case "Guest HouseScience Block":
                drawPath(gh,sci,"Guest House","Science Block",GHSCIENCEBLOCK);
                break;
            case "Guest HouseLibrary":
                drawPath(gh,lib,"Guest House","Library",GHLIBRARY);
                break;
            case "Guest HouseNCC Block":
                drawPath(gh,ncc,"Guest House","NCC Block",GHNCCBLOCK);
                break;
            case "Guest HouseFreshers Block":
                drawPath(gh,bhalls,"Guest House","Freshers Block",GHFRESHERBLOCK);
                break;
            case "Guest HouseKS Auditorium":
                drawPath(gh,ks,"Guest House","KS Auditorium",GHKSAUDITORIUM);
                break;
            case "Guest HouseARCH":
                drawPath(gh,arch,"Guest House","Architecture",GHARCH);
                break;
            case "Guest HouseKM Auditorium":
                drawPath(gh,km,"Guest House","KM Auditorium",GHKMAUDITORIUM);
                break;
            case "Guest HouseOutdoor":
                drawPath(gh,out,"Guest House","Outdoor",GHOUTDOOR);
                break;
            case "Guest HouseIndoor":
                drawPath(gh,ind,"Guest House","Indoor",GHINDOOR);
                break;
            case "Guest HouseMens Hostel":
                drawPath(gh,mhos,"Guest House","Mens Hostel",GHMENSHOSTEL);
                break;
            case "Guest HouseWomens Hostel":
                drawPath(gh,ghos,"Guest House","Womens Hostel",GHWOMENSHOSTEL);
                break;
            case "Guest HouseMain Canteen":
                drawPath(gh,mcan,"Guest House","Main Canteen",GHMAINCANTEEN);
                break;
            case "Guest HouseFood Court":
                drawPath(gh,fc,"Guest House","Food Court",GHFOODCOURT);
                break;
            case "Guest HousePlacement Cell":
                drawPath(gh,pc,"Guest House","Placement Cell",GHPLACEMENTCELL);
                break;
            case "Guest HouseBank":
                drawPath(gh,ban,"Guest House","Bank",GHBANK);
                break;
            case "Guest HouseTemple":
                drawPath(gh,temple,"Guest House","Temple",GHTEMPLE);
                break;
            case "Guest HouseParking":
                drawPath(gh,par,"Guest House","Parking",GHPARKING);
                break;
            case "Main CanteenMain Building":
                drawPath(mcan,main,"Main Canteen","Main Building",MCMAINBUILDING);
                break;
            case "Main CanteenCIVIL":
                drawPath(mcan,cvl,"Main Canteen","Civil",MCCIVIL);
                break;
            case "Main CanteenIT":
                drawPath(mcan,it1,"Main Canteen","Information Technology",MCIT);
                break;
            case "Main CanteenCSE":
                drawPath(mcan,cs,"Main Canteen","Computer Science",MCCSE);
                break;
            case "Main CanteenECE":
                drawPath(mcan,ece,"Main Canteen","ECE",MCECE);
                break;
            case "Main CanteenEEE":
                drawPath(mcan,eee,"Main Canteen","EEE",MCEEE);
                break;
            case "Main CanteenMECH":
                drawPath(mcan,mec,"Main Canteen","Mechanical",MCMECH);
                break;
            case "Main CanteenMECHT":
                drawPath(mcan,mect,"Main Canteen","Mechatronics",MCMECHT);
                break;
            case "Main CanteenScience Block":
                drawPath(mcan,sci,"Main Canteen","Science Block",MCSCIENCEBLOCK);
                break;
            case "Main CanteenLibrary":
                drawPath(mcan,lib,"Main Canteen","Library",MCLIBRARY);
                break;
            case "Main CanteenNCC Block":
                drawPath(mcan,ncc,"Main Canteen","NCC Block",MCNCCBLOCK);
                break;
            case "Main CanteenIndoor":
                drawPath(mcan,ind,"Main Canteen","Indoor",MCINDOOR);
                break;
            case "Main CanteenKS Auditorium":
                drawPath(mcan,ks,"Main Canteen","KS Auditorium",MCKSAUDITORIUM);
                break;
            case "Main CanteenARCH":
                drawPath(mcan,arch,"Main Canteen","Architecture",MCARCH);
                break;
            case "Main CanteenKM Auditorium":
                drawPath(mcan,km,"Main Canteen","KM Auditorium",MCKMAUDITORIUM);
                break;
            case "Main CanteenOutdoor":
                drawPath(mcan,out,"Main Canteen","ECE",MCOUTDOOR);
                break;
            case "Main CanteenGuest House":
                drawPath(mcan,gh,"Main Canteen","Guest Hostel",MCGUESTHOUSE);
                break;
            case "Main CanteenMens Hostel":
                drawPath(mcan,mhos,"Main Canteen","Mens Hostel",MCMENSHOSTEL);
                break;
            case "Main CanteenWomens Hostel":
                drawPath(mcan,ghos,"Main Canteen","Womens Hostel",MCWOMENSHOSTEL);
                break;
            case "Main CanteenFreshers Block":
                drawPath(mcan,bhalls,"Main Canteen","Freshers Block",MCFRESHERBLOCK);
                break;
            case "Main CanteenFood Court":
                drawPath(mcan,fc,"Main Canteen","Food Court",MCFOODCOURT);
                break;
            case "Main CanteenPlacement Cell":
                drawPath(mcan,pc,"Main Canteen","Placement Cell",MCPLACEMENTCELL);
                break;
            case "Main CanteenBank":
                drawPath(mcan,ban,"Main Canteen","Bank",MCBANK);
                break;
            case "Main CanteenTemple":
                drawPath(mcan,temple,"Main Canteen","Temple",MCTEMPLE);
                break;
            case "Main CanteenParking":
                drawPath(mcan,par,"Main Canteen","Parking",MCPARKING);
                break;
            case "Food CourtMain Building":
                drawPath(fc,main,"Food Court","Main Building",FCMAINBUILDING);
                break;
            case "Food CourtCIVIL":
                drawPath(fc,cvl,"Food Court","Civil",FCCIVIL);
                break;
            case "Food CourtIT":
                drawPath(fc,it1,"Food Court","Information Technology",FCIT);
                break;
            case "Food CourtCSE":
                drawPath(fc,cs,"Food Court","Computer Science",FCCSE);
                break;
            case "Food CourtECE":
                drawPath(fc,ece,"Food Court","ECE",FCECE);
                break;
            case "Food CourtEEE":
                drawPath(fc,eee,"Food Court","EEE",FCEEE);
                break;
            case "Food CourtMECH":
                drawPath(fc,mec,"Food Court","Mechanical",FCMECH);
                break;
            case "Food CourtMECHT":
                drawPath(fc,mect,"Food Court","Mechatronics",FCMECHT);
                break;
            case "Food CourtScience Block":
                drawPath(fc,sci,"Food Court","Science Block",FCSCIENCEBLOCK);
                break;
            case "Food CourtLibrary":
                drawPath(fc,lib,"Food Court","Library",FCLIBRARY);
                break;
            case "Food CourtNCC Block":
                drawPath(fc,ncc,"Food Court","NCC Block",FCNCCBLOCK);
                break;
            case "Food CourtIndoor":
                drawPath(fc,ind,"Food Court","Indoor",FCINDOOR);
                break;
            case "Food CourtKS Auditorium":
                drawPath(fc,ks,"Food Court","KS Auditorium",FCKSAUDITORIUM);
                break;
            case "Food CourtARCH":
                drawPath(fc,arch,"Food Court","Architecture",FCARCH);
                break;
            case "Food CourtKM Auditorium":
                drawPath(fc,km,"Food Court","KM Auditorium",FCKMAUDITORIUM);
                break;
            case "Food CourtOutdoor":
                drawPath(fc,out,"Food Court","Outdoor",FCOUTDOOR);
                break;
            case "Food CourtGuest House":
                drawPath(fc,gh,"Food Court","Guest House",FCGUESTHOUSE);
                break;
            case "Food CourtMens Hostel":
                drawPath(fc,mhos,"Food Court","Mens Hostel",FCMENSHOSTEL);
                break;
            case "Food CourtWomens Hostel":
                drawPath(fc,ghos,"Food Court","Womens Hostel",FCWOMENSHOSTEL);
                break;
            case "Food CourtMain Canteen":
                drawPath(fc,mcan,"Food Court","Main Canteen",FCMAINCANTEEN);
                break;
            case "Food CourtPlacement Cell":
                drawPath(fc,pc,"Food Court","Placement Cell",FCPLACEMENTCELL);
                break;
            case "Food CourtBank":
                drawPath(fc,ban,"Food Court","Bank",FCBANK);
                break;
            case "Food CourtTemple":
                drawPath(fc,temple,"Food Court","Temple",FCTEMPLE);
                break;
            case "Food CourtParking":
                drawPath(fc,par,"Food Court","Parking",FCPARKING);
                break;
            case "Mens HostelMain Building":
                drawPath(mhos,main,"Mens Hostel","Main Building",MHMAINBUILDING);
                break;
            case "Mens HostelCIVIL":
                drawPath(mhos,cvl,"Mens Hostel","Civil",MHCIVIL);
                break;
            case "Mens HostelIT":
                drawPath(mhos,it1,"Mens Hostel","Information Technology",MHIT);
                break;
            case "Mens HostelCSE":
                drawPath(mhos,cs,"Mens Hostel","Computer Science",MHCSE);
                break;
            case "Mens HostelECE":
                drawPath(mhos,ece,"Mens Hostel","ECE",MHECE);
                break;
            case "Mens HostelEEE":
                drawPath(mhos,eee,"Mens Hostel","EEE",MHEEE);
                break;
            case "Mens HostelMECH":
                drawPath(mhos,mec,"Mens Hostel","Mechanical",MHMECH);
                break;
            case "Mens HostelMECHT":
                drawPath(mhos,mect,"Mens Hostel","Mechatronics",MHMECHT);
                break;
            case "Mens HostelScience Block":
                drawPath(mhos,sci,"Mens Hostel","Science Block",MHSCIENCEBLOCK);
                break;
            case "Mens HostelLibrary":
                drawPath(mhos,lib,"Mens Hostel","Library",MHLIBRARY);
                break;
            case "Mens HostelNCC Block":
                drawPath(mhos,cvl,"Mens Hostel","NCC Block",MHNCCBLOCK);
                break;
            case "Mens HostelIndoor":
                drawPath(mhos,ind,"Mens Hostel","Indoor",MHINDOOR);
                break;
            case "Mens HostelKS Auditorium":
                drawPath(mhos,ks,"Mens Hostel","KS Auditorium",MHKSAUDITORIUM);
                break;
            case "Mens HostelARCH":
                drawPath(mhos,arch,"Mens Hostel","Architecture",MHARCH);
                break;
            case "Mens HostelKM Auditorium":
                drawPath(mhos,km,"Mens Hostel","KM Auditorium",MHKMAUDITORIUM);
                break;
            case "Mens HostelOutdoor":
                drawPath(mhos,out,"Mens Hostel","Outdoor",MHOUTDOOR);
                break;
            case "Mens HostelGuest House":
                drawPath(mhos,gh,"Mens Hostel","Guest House",MHGUESTHOUSE);
                break;
            case "Mens HostelFreshers Block":
                drawPath(mhos,bhalls,"Mens Hostel","Freshers Block",MHFRESHERBLOCK);
                break;
            case "Mens HostelWomens Hostel":
                drawPath(mhos,ghos,"Mens Hostel","Womens Hostel",MHWOMENSHOSTEL);
                break;
            case "Mens HostelMain Canteen":
                drawPath(mhos,mcan,"Mens Hostel","Main Canteen",MHMAINCANTEEN);
                break;
            case "Mens HostelFood Court":
                drawPath(mhos,fc,"Mens Hostel","Food Court",MHFOODCOURT);
                break;
            case "Mens HostelPlacement Cell":
                drawPath(mhos,pc,"Mens Hostel","Placement Cell",MHPLACEMENTCELL);
                break;
            case "Mens HostelBank":
                drawPath(mhos,ban,"Mens Hostel","Bank",MHBANK);
                break;
            case "Mens HostelTemple":
                drawPath(mhos,temple,"Mens Hostel","Temple",MHTEMPLE);
                break;
            case "Mens HostelParking":
                drawPath(mhos,par,"Mens Hostel","Parking",MHPARKING);
                break;
            case "Womens HostelMain Building":
                drawPath(ghos,main,"Womens Hostel","Main Building",WHMAINBUILDING);
                break;
            case "Womens HostelCIVIL":
                drawPath(ghos,cvl,"Womens Hostel","Civil",WHCIVIL);
                break;
            case "Womens HostelIT":
                drawPath(ghos,it1,"Womens Hostel","Information Technology",WHIT);
                break;
            case "Womens HostelCSE":
                drawPath(ghos,cs,"Womens Hostel","Computer Science",WHCSE);
                break;
            case "Womens HostelECE":
                drawPath(ghos,ece,"Womens Hostel","ECE",WHECE);
                break;
            case "Womens HostelEEE":
                drawPath(ghos,eee,"Womens Hostel","EEE",WHEEE);
                break;
            case "Womens HostelMECH":
                drawPath(ghos,mec,"Womens Hostel","Mechanical",WHMECH);
                break;
            case "Womens HostelMECHT":
                drawPath(ghos,mect,"Womens Hostel","Mechatronics",WHMECHT);
                break;
            case "Womens HostelScience Block":
                drawPath(ghos,sci,"Womens Hostel","Science Block",WHSCIENCEBLOCK);
                break;
            case "Womens HostelLibrary":
                drawPath(ghos,lib,"Womens Hostel","Library",WHLIBRARY);
                break;
            case "Womens HostelNCC Block":
                drawPath(ghos,ncc,"Womens Hostel","NCC Block",WHNCCBLOCK);
                break;
            case "Womens HostelIndoor":
                drawPath(ghos,ind,"Womens Hostel","Indoor",WHINDOOR);
                break;
            case "Womens HostelKS Auditorium":
                drawPath(ghos,ks,"Womens Hostel","KS Auditorium",WHKSAUDITORIUM);
                break;
            case "Womens HostelARCH":
                drawPath(ghos,arch,"Womens Hostel","Architecture",WHARCH);
                break;
            case "Womens HostelKM Auditorium":
                drawPath(ghos,km,"Womens Hostel","KM Auditorium",WHKMAUDITORIUM);
                break;
            case "Womens HostelOutdoor":
                drawPath(ghos,out,"Womens Hostel","Outdoor",WHOUTDOOR);
                break;
            case "Womens HostelGuest House":
                drawPath(ghos,gh,"Womens Hostel","Guest House",WHGUESTHOUSE);
                break;
            case "Womens HostelMens Hostel":
                drawPath(ghos,mhos,"Womens Hostel","Mens Hostel",WHMENSHOSTEL);
                break;
            case "Womens HostelFreshers Block":
                drawPath(ghos,bhalls,"Womens Hostel","Freshers Block",WHFRESHERBLOCK);
                break;
            case "Womens HostelMain Canteen":
                drawPath(ghos,mcan,"Womens Hostel","Main Canteen",WHMAINCANTEEN);
                break;
            case "Womens HostelFood Court":
                drawPath(ghos,fc,"Womens Hostel","Food Court",WHFOODCOURT);
                break;
            case "Womens HostelPlacement Cell":
                drawPath(ghos,pc,"Womens Hostel","Placement Cell",WHPLACEMENTCELL);
                break;
            case "Womens HostelBank":
                drawPath(ghos,ban,"Womens Hostel","Bank",WHBANK);
                break;
            case "Womens HostelTemple":
                drawPath(ghos,temple,"Womens Hostel","Temple",WHTEMPLE);
                break;
            case "Womens HostelParking":
                drawPath(ghos,par,"Womens Hostel","Parking",WHPARKING);
                break;
            default:
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "Plz choose a valid From and To locations", Snackbar.LENGTH_LONG);
                snackbar.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search_menu).getActionView();
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return true;
    }
    public void onActivityResult(int requestCode, int resultCode, Intent i)
    {
        super.onActivityResult(requestCode, resultCode, i);
        switch (requestCode) {
            case 100:
                if (resultCode == RESULT_OK && i != null) {
                    ArrayList<String> result = i.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    Toast.makeText(getApplicationContext(), result.get(0), Toast.LENGTH_LONG).show();
                    toSearch(result.get(0));
                }
                break;
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Add a marker in Thiagarajar College of Engineering and move the camera
        mMap = googleMap;
        LatLng tce = new LatLng(lat, lon);
        mark=mMap.addMarker(new MarkerOptions().position(tce).title(tittle).snippet("TCE Campus"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lon), 19.0f));
        mark.showInfoWindow();
    }

    private void voiceInfo(String voice) {
        textToSpeech.speak(voice,TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    protected void onDestroy() {
        if(textToSpeech!=null)
        {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = textToSpeech.setLanguage(Locale.US);
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                voiceInfo(voice);
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }

    public void toSearch(String searchQuery)
    {
        mUtility mUtil=new mUtility();
        String tempSearch=searchQuery.toLowerCase();
        if(mUtil.isIT(tempSearch))
        {
            gotoIT();
        }
        else if(mUtil.isCSE(tempSearch))
        {
            gotoCSE();
        }
        else if(mUtil.isCIVIL(tempSearch))
        {
            gotoCIVIL();
        }
        else if(mUtil.isECE(tempSearch))
        {
            gotoECE();
        }
        else if(mUtil.isEEE(tempSearch))
        {
            gotoEEE();
        }
        else if(mUtil.isMECH(tempSearch))
        {
            gotoMECH();
        }
        else if(mUtil.isBARCH(tempSearch))
        {
            gotoARCH();
        }
        else
        {
            Snackbar snackbar=Snackbar.make(coordinatorLayout,"Sorry plz pick Correct Place",Snackbar.LENGTH_LONG);
            snackbar.setActionTextColor(Color.RED);
            snackbar.show();
        }
        mMap.clear();
        mark.hideInfoWindow();
        onMapReady(mMap);
        voiceInfo(tittle);
    }

    public void gotoMainBuilding()
    {
         lat = 9.882881;
         lon = 78.082511;
        tittle="Thiagarajar College of Engineering";

    }
    public void gotoIT()
    {
        lat=9.882399;
        lon=78.083630;
        tittle="Information Technology";
    }
    public void gotoCSE()
    {
        lat=9.882797;
        lon=78.083739;
        tittle="Computer Science Engineering";
    }
    public void gotoECE()
    {
        lat=9.882820;
        lon=78.082338;
        tittle="Electronics and Communication";
    }
    public void gotoEEE()
    {
        lat=9.882433;
        lon=78.082086;
        tittle="Electrical and Electronics";
    }
    public void gotoCIVIL()
    {
        lat=9.882278;
        lon=78.082855;
        tittle="Civil Engineering";
    }
    public void gotoMECH()
    {
        lat=9.882365;
        lon=78.081429;
        tittle="Mechanical Engineering";
    }
    public void gotoARCH()
    {
        lat=9.878790;
        lon=78.082110;
        tittle="Architecture";
    }
    public void gotoMECHATRONICS()
    {
        lat=9.882365;
        lon=78.081428;
        tittle="Mechatronics Engineering";
    }
    public void gotoSCIENCE_BLOCK()
    {
        lat=9.881876;
        lon=78.083152;
        tittle="Science Block";
    }
    public void gotoFRESHERS_BLOCK()
    {
        lat=9.88172;
        lon=78.082617;
        tittle="Freshers Block";
    }
    public void gotoNCC_BLOCK()
    {
        lat=9.883560;
        lon=78.079803;
        tittle="NCC Block";
    }
    public void gotoINDOOR()
    {
        lat=9.877382;
        lon=78.081013;
        tittle="Indoor Stadium";
    }
    public void gotoOUTDOOR()
    {
        lat=9.883842;
        lon=78.081407;
        tittle="Outdoor Ground";
    }
    public void gotoKS_AUDI()
    {
        lat=9.882820;
        lon=78.082337;
        tittle="KS Auditorium";
    }
    public void gotoKM_AUDI()
    {
        lat=9.882480;
        lon=78.082541;
        tittle="KM Auditorium";
    }
    public void gotoPLACEMENT_CELL()
    {
        lat=9.885026;
        lon=78.080954;
        tittle="Placement Cell";
    }
    public void gotoGUEST_HOUSE()
    {
        lat=9.885211;
        lon=78.080632;
        tittle="Guest House";
    }
    public void gotoMAIN_CANTEEN()
    {
        lat=9.883264;
        lon=78.079857;
        tittle="Main Canteen";
    }
    public void gotoFOOD_COURT()
    {
        lat=9.883282;
        lon=78.083236;
        tittle="Food Court";
    }
    public void gotoMENS_HOSTEL()
    {
        lat=9.884738;
        lon=78.080071;
        tittle="Mens Hostel";
    }
    public void gotoWOMENS_HOSTEL()
    {
        lat=9.878201;
        lon=78.082072;
        tittle="Womens Hostel";
    }
    public void gotoLIBRARY()
    {
        lat=9.882854;
        lon=78.081243;
        tittle="Library";
    }
    public void gotoBANK()
    {
        lat=9.883496;
        lon=78.079848;
        tittle="Bank";
    }
    public void gotoTEMPLE()
    {
        lat=9.885459;
        lon=78.080574;
        tittle="Temple";
    }
    public void gotoPARKING()
    {
        lat=9.882769;
        lon=78.080846;
        tittle="Parking";
    }

    public void drawPath(LatLng fromLatLong,LatLng toLatLong,String fromTittle,String toTittle,ArrayList<LatLng> pathCoordinates)
    {
        from = mMap.addMarker(new MarkerOptions().position(fromLatLong).title(fromTittle));
        to = mMap.addMarker(new MarkerOptions().position(toLatLong).title(toTittle));
        to.showInfoWindow();
        route = mMap.addPolyline(new PolylineOptions().addAll(pathCoordinates).width(25).color(Color.YELLOW));
        fromArr=fromTittle;
        builder.include(fromLatLong);
        builder.include(toLatLong);
        LatLngBounds bounds=builder.build();
        mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds,16));
    }

    public void initMainBuildingCoordinates()
    {
        MECE.add(new LatLng(9.882881,78.082511));
        MECE.add(new LatLng(9.882874,78.082480));
        MECE.add(new LatLng(9.882859,78.082492));
        MECE.add(new LatLng(9.882843,78.082387));
        MECE.add(new LatLng(9.882820,78.082338));

        MIT.add(new LatLng(9.882881,78.082511));
        MIT.add(new LatLng(9.882838,78.082683));
        MIT.add(new LatLng(9.882820,78.082913));
        MIT.add(new LatLng(9.882811,78.083130));
        MIT.add(new LatLng(9.882811,78.083270));
        MIT.add(new LatLng(9.882611,78.083270));
        MIT.add(new LatLng(9.882611,78.083342));
        MIT.add(new LatLng(9.882504,78.083346));
        MIT.add(new LatLng(9.882442,78.083410));
        MIT.add(new LatLng(9.882442,78.083540));
        MIT.add(new LatLng(9.882399,78.083630));

        MLIB.add(new LatLng(9.882881,78.082511));
        MLIB.add(new LatLng(9.882885,78.082453));
        MLIB.add(new LatLng(9.883031,78.082423));
        MLIB.add(new LatLng(9.883154,78.082400));
        MLIB.add(new LatLng(9.883225,78.082389));
        MLIB.add(new LatLng(9.883248,78.082006));
        MLIB.add(new LatLng(9.883251,78.081721));
        MLIB.add(new LatLng(9.883248,78.081581));
        MLIB.add(new LatLng(9.883248,78.081232));
        MLIB.add(new LatLng(9.883106,78.081224));
        MLIB.add(new LatLng(9.882997,78.081236));
        MLIB.add(new LatLng(9.882854,78.081243));

        MPAR.add(new LatLng(9.882881,78.082511));
        MPAR.add(new LatLng(9.882885,78.082453));
        MPAR.add(new LatLng(9.883031,78.082423));
        MPAR.add(new LatLng(9.883154,78.082400));
        MPAR.add(new LatLng(9.883225,78.082389));
        MPAR.add(new LatLng(9.883248,78.082006));
        MPAR.add(new LatLng(9.883251,78.081721));
        MPAR.add(new LatLng(9.883248,78.081581));
        MPAR.add(new LatLng(9.883248,78.081232));
        MPAR.add(new LatLng(9.883259,78.081054));
        MPAR.add(new LatLng(9.883257,78.080853));
        MPAR.add(new LatLng(9.883277,78.080781));
        MPAR.add(new LatLng(9.883282,78.080737));
        MPAR.add(new LatLng(9.883162,78.080721));
        MPAR.add(new LatLng(9.883044,78.080710));
        MPAR.add(new LatLng(9.882954,78.080702));
        MPAR.add(new LatLng(9.882952,78.080745));
        MPAR.add(new LatLng(9.882953,78.080790));
        MPAR.add(new LatLng(9.882769,78.080846));

        MMECH.add(new LatLng(9.882881,78.082511));
        MMECH.add(new LatLng(9.882885,78.082453));
        MMECH.add(new LatLng(9.883031,78.082423));
        MMECH.add(new LatLng(9.883154,78.082400));
        MMECH.add(new LatLng(9.883225,78.082389));
        MMECH.add(new LatLng(9.883259,78.081076));
        MMECH.add(new LatLng(9.883106,78.081076));
        MMECH.add(new LatLng(9.883001,78.081076));
        MMECH.add(new LatLng(9.882881,78.081076));
        MMECH.add(new LatLng(9.882365,78.081429));

        MEEE.add(new LatLng(9.882881,78.082511));
        MEEE.add(new LatLng(9.882880,78.082453));
        MEEE.add(new LatLng(9.882838,78.082433));
        MEEE.add(new LatLng(9.882787,78.082426));
        MEEE.add(new LatLng(9.882749,78.082423));
        MEEE.add(new LatLng(9.882730,78.082446));
        MEEE.add(new LatLng(9.882695,78.082433));
        MEEE.add(new LatLng(9.882653,78.082431));
        MEEE.add(new LatLng(9.882629,78.082430));
        MEEE.add(new LatLng(9.882583,78.082428));
        MEEE.add(new LatLng(9.882511,78.082425));
        MEEE.add(new LatLng(9.882488,78.082421));
        MEEE.add(new LatLng(9.882490,78.082379));
        MEEE.add(new LatLng(9.882492,78.082326));
        MEEE.add(new LatLng(9.882471,78.082324));
        MEEE.add(new LatLng(9.882433,78.082086));

        MKM.add(new LatLng(9.882881,78.082511));
        MKM.add(new LatLng(9.882880,78.082453));
        MKM.add(new LatLng(9.882838,78.082433));
        MKM.add(new LatLng(9.882787,78.082426));
        MKM.add(new LatLng(9.882749,78.082423));
        MKM.add(new LatLng(9.882730,78.082446));
        MKM.add(new LatLng(9.882723,78.082487));
        MKM.add(new LatLng(9.882480,78.082541));

        MCVL.add(new LatLng(9.882881,78.082511));
        MCVL.add(new LatLng(9.882880,78.082453));
        MCVL.add(new LatLng(9.882838,78.082433));
        MCVL.add(new LatLng(9.882787,78.082426));
        MCVL.add(new LatLng(9.882749,78.082423));
        MCVL.add(new LatLng(9.882730,78.082446));
        MCVL.add(new LatLng(9.882695,78.082433));
        MCVL.add(new LatLng(9.882653,78.082431));
        MCVL.add(new LatLng(9.882629,78.082430));
        MCVL.add(new LatLng(9.882583,78.082428));
        MCVL.add(new LatLng(9.882511,78.082425));
        MCVL.add(new LatLng(9.882488,78.082421));
        MCVL.add(new LatLng(9.882453,78.082415));
        MCVL.add(new LatLng(9.882413,78.082410));
        MCVL.add(new LatLng(9.882388,78.082408));
        MCVL.add(new LatLng(9.882356,78.082403));
        MCVL.add(new LatLng(9.882278,78.082855));

        MCS.add(new LatLng(9.882881,78.082511));
        MCS.add(new LatLng(9.882872,78.082803));
        MCS.add(new LatLng(9.882872,78.082943));
        MCS.add(new LatLng(9.882855,78.083149));
        MCS.add(new LatLng(9.882844,78.083294));
        MCS.add(new LatLng(9.882819,78.083356));
        MCS.add(new LatLng(9.882819,78.083428));
        MCS.add(new LatLng(9.882819,78.083527));
        MCS.add(new LatLng(9.882767,78.083527));
        MCS.add(new LatLng(9.882767,78.083582));
        MCS.add(new LatLng(9.882767,78.083617));
        MCS.add(new LatLng(9.882797,78.083739));
    }

    public void initITCoordinates()
    {
        IMAINBUILDING.add(new LatLng(9.882399,78.083630));
        IMAINBUILDING.add(new LatLng(9.882397,78.083569));
        IMAINBUILDING.add(new LatLng(9.882397,78.083506));
        IMAINBUILDING.add(new LatLng(9.882397,78.083426));
        IMAINBUILDING.add(new LatLng(9.882692,78.083426));
        IMAINBUILDING.add(new LatLng(9.882710,78.083130));
        IMAINBUILDING.add(new LatLng(9.882731,78.082759));
        IMAINBUILDING.add(new LatLng(9.882750,78.082536));
        IMAINBUILDING.add(new LatLng(9.882829,78.082341));
        IMAINBUILDING.add(new LatLng(9.882855,78.082530));

        IMECH.add(new LatLng(9.882399,78.083630));
        IMECH.add(new LatLng(9.882397,78.083569));
        IMECH.add(new LatLng(9.882397,78.083506));
        IMECH.add(new LatLng(9.882397,78.083426));
        IMECH.add(new LatLng(9.882326,78.083423));
        IMECH.add(new LatLng(9.882324,78.083199));
        IMECH.add(new LatLng(9.882324,78.082820));
        IMECH.add(new LatLng(9.882324,78.082409));
        IMECH.add(new LatLng(9.882324,78.081958));
        IMECH.add(new LatLng(9.882324,78.081691));
        IMECH.add(new LatLng(9.882437,78.081691));
        IMECH.add(new LatLng(9.882467,78.081483));
        IMECH.add(new LatLng(9.882488,78.081320));
        IMECH.add(new LatLng(9.882704,78.081311));
        IMECH.add(new LatLng(9.882365,78.081429));

        ICSE.add(new LatLng(9.882399,78.083630));
        ICSE.add(new LatLng(9.882397,78.083569));
        ICSE.add(new LatLng(9.882513,78.083545));
        ICSE.add(new LatLng(9.882692,78.083572));
        ICSE.add(new LatLng(9.882884,78.083593));
        ICSE.add(new LatLng(9.882896,78.083745));
        ICSE.add(new LatLng(9.882797,78.083739));

        IECE.add(new LatLng(9.882399,78.083630));
        IECE.add(new LatLng(9.882397,78.083569));
        IECE.add(new LatLng(9.882397,78.083506));
        IECE.add(new LatLng(9.882397,78.083426));
        IECE.add(new LatLng(9.882692,78.083426));
        IECE.add(new LatLng(9.882710,78.083130));
        IECE.add(new LatLng(9.882731,78.082759));
        IECE.add(new LatLng(9.882750,78.082536));
        IECE.add(new LatLng(9.882820,78.082338));

        IEEE.add(new LatLng(9.882399,78.083630));
        IEEE.add(new LatLng(9.882397,78.083569));
        IEEE.add(new LatLng(9.882397,78.083506));
        IEEE.add(new LatLng(9.882397,78.083426));
        IEEE.add(new LatLng(9.882326,78.083423));
        IEEE.add(new LatLng(9.882324,78.083199));
        IEEE.add(new LatLng(9.882324,78.082820));
        IEEE.add(new LatLng(9.882324,78.082409));
        IEEE.add(new LatLng(9.882469,78.082409));
        IEEE.add(new LatLng(9.882469,78.082222));
        IEEE.add(new LatLng(9.882469,78.082038));
        IEEE.add(new LatLng(9.882433,78.082086));

        ICIVIL.add(new LatLng(9.882399,78.083630));
        ICIVIL.add(new LatLng(9.882397,78.083569));
        ICIVIL.add(new LatLng(9.882397,78.083506));
        ICIVIL.add(new LatLng(9.882397,78.083426));
        ICIVIL.add(new LatLng(9.882326,78.083423));
        ICIVIL.add(new LatLng(9.882324,78.083199));
        ICIVIL.add(new LatLng(9.882324,78.082764));
        ICIVIL.add(new LatLng(9.882278,78.082855));

        IMECHT.add(new LatLng(9.882399,78.083630));
        IMECHT.add(new LatLng(9.882397,78.083569));
        IMECHT.add(new LatLng(9.882397,78.083506));
        IMECHT.add(new LatLng(9.882397,78.083426));
        IMECHT.add(new LatLng(9.882326,78.083423));
        IMECHT.add(new LatLng(9.882324,78.083199));
        IMECHT.add(new LatLng(9.882324,78.082820));
        IMECHT.add(new LatLng(9.882324,78.082409));
        IMECHT.add(new LatLng(9.882324,78.081958));
        IMECHT.add(new LatLng(9.882324,78.081691));
        IMECHT.add(new LatLng(9.882437,78.081691));
        IMECHT.add(new LatLng(9.882467,78.081483));
        IMECHT.add(new LatLng(9.882488,78.081320));
        IMECHT.add(new LatLng(9.882704,78.081311));
        IMECHT.add(new LatLng(9.882365,78.081428));

        IARCH.add(new LatLng(9.882399,78.083630));
        IARCH.add(new LatLng(9.882397,78.083569));
        IARCH.add(new LatLng(9.882397,78.083506));
        IARCH.add(new LatLng(9.882397,78.083426));
        IARCH.add(new LatLng(9.881682,78.083426));
        IARCH.add(new LatLng(9.881301,78.083517));
        IARCH.add(new LatLng(9.880672,78.083442));
        IARCH.add(new LatLng(9.880558,78.083080));
        IARCH.add(new LatLng(9.880201,78.083158));
        IARCH.add(new LatLng(9.878790,78.082110));

        ISCIENCEBLOCK.add(new LatLng(9.882399,78.083630));
        ISCIENCEBLOCK.add(new LatLng(9.882397,78.083569));
        ISCIENCEBLOCK.add(new LatLng(9.882397,78.083506));
        ISCIENCEBLOCK.add(new LatLng(9.882397,78.083426));
        ISCIENCEBLOCK.add(new LatLng(9.882178,78.083423));
        ISCIENCEBLOCK.add(new LatLng(9.882173,78.083195));
        ISCIENCEBLOCK.add(new LatLng(9.882160,78.083029));
        ISCIENCEBLOCK.add(new LatLng(9.881816,78.083021));
        ISCIENCEBLOCK.add(new LatLng(9.881876,78.083152));

        IFRESHERBLOCK.add(new LatLng(9.882399,78.083630));
        IFRESHERBLOCK.add(new LatLng(9.882397,78.083569));
        IFRESHERBLOCK.add(new LatLng(9.882397,78.083506));
        IFRESHERBLOCK.add(new LatLng(9.882397,78.083426));
        IFRESHERBLOCK.add(new LatLng(9.882178,78.083423));
        IFRESHERBLOCK.add(new LatLng(9.882173,78.083195));
        IFRESHERBLOCK.add(new LatLng(9.882160,78.083029));
        IFRESHERBLOCK.add(new LatLng(9.881950,78.083021));
        IFRESHERBLOCK.add(new LatLng(9.881946,78.082825));
        IFRESHERBLOCK.add(new LatLng(9.88172,78.082617));

        INCCBLOCK.add(new LatLng(9.882399,78.083630));
        INCCBLOCK.add(new LatLng(9.882397,78.083569));
        INCCBLOCK.add(new LatLng(9.882397,78.083506));
        INCCBLOCK.add(new LatLng(9.882397,78.083426));
        INCCBLOCK.add(new LatLng(9.882982,78.083423));
        INCCBLOCK.add(new LatLng(9.883168,78.083267));
        INCCBLOCK.add(new LatLng(9.883211,78.082630));
        INCCBLOCK.add(new LatLng(9.883236,78.081833));
        INCCBLOCK.add(new LatLng(9.883262,78.080870));
        INCCBLOCK.add(new LatLng(9.883286,78.080765));
        INCCBLOCK.add(new LatLng(9.883458,78.080706));
        INCCBLOCK.add(new LatLng(9.883560,78.079803));
        // IT TO INDOOR (IT=9.882399,78.083630) (INDOOR=9.877326,78.080994)
        IINDOOR.add(new LatLng(9.882399,78.083630));
        IINDOOR.add(new LatLng(9.882397,78.083569));
        IINDOOR.add(new LatLng(9.882397,78.083506));
        IINDOOR.add(new LatLng(9.882397,78.083426));
        IINDOOR.add(new LatLng(9.881682,78.083426));
        IINDOOR.add(new LatLng(9.881452,78.083488));
        IINDOOR.add(new LatLng(9.881540,78.082662));
        IINDOOR.add(new LatLng(9.880959,78.082606));
        IINDOOR.add(new LatLng(9.880761,78.082324));
        IINDOOR.add(new LatLng(9.880621,78.082225));
        IINDOOR.add(new LatLng(9.879701,78.081978));
        IINDOOR.add(new LatLng(9.879215,78.081785));
        IINDOOR.add(new LatLng(9.878496,78.081654));
        IINDOOR.add(new LatLng(9.877774,78.081405));
        IINDOOR.add(new LatLng(9.877578,78.081330));
        IINDOOR.add(new LatLng(9.877596,78.080995));
        IINDOOR.add(new LatLng(9.877326,78.080994));
// IT TO OUTDOOR (IT=9.882399,78.083630) (OUTDOOR=9.883759,78.081539)
        IOUTDOOR.add(new LatLng(9.882399,78.083630));
        IOUTDOOR.add(new LatLng(9.882397,78.083569));
        IOUTDOOR.add(new LatLng(9.882397,78.083506));
        IOUTDOOR.add(new LatLng(9.882397,78.083426));
        IOUTDOOR.add(new LatLng(9.882982,78.083423));
        IOUTDOOR.add(new LatLng(9.883168,78.083267));
        IOUTDOOR.add(new LatLng(9.883211,78.082630));
        IOUTDOOR.add(new LatLng(9.883236,78.081833));
        IOUTDOOR.add(new LatLng(9.883759,78.081539));
// IT TO IKSAUDITORIUM (IT=9.882399,78.083630) (IKSAUDITORIUM=9.882849,78.081976)
        IKSAUDITORIUM.add(new LatLng(9.882399,78.083630));
        IKSAUDITORIUM.add(new LatLng(9.882397,78.083569));
        IKSAUDITORIUM.add(new LatLng(9.882397,78.083506));
        IKSAUDITORIUM.add(new LatLng(9.882397,78.083426));
        IKSAUDITORIUM.add(new LatLng(9.882692,78.083426));
        IKSAUDITORIUM.add(new LatLng(9.882710,78.083130));
        IKSAUDITORIUM.add(new LatLng(9.882731,78.082759));
        IKSAUDITORIUM.add(new LatLng(9.882750,78.082536));
        IKSAUDITORIUM.add(new LatLng(9.882770,78.082258));
        IKSAUDITORIUM.add(new LatLng(9.882783,78.082046));
        IKSAUDITORIUM.add(new LatLng(9.882849,78.081976));
// IT TO KMAUDITORIUM (IT=9.882399,78.083630) (KMAUDITORIUM=9.882505,78.082540)
        IKMAUDITORIUM.add(new LatLng(9.882399,78.083630));
        IKMAUDITORIUM.add(new LatLng(9.882397,78.083569));
        IKMAUDITORIUM.add(new LatLng(9.882397,78.083506));
        IKMAUDITORIUM.add(new LatLng(9.882397,78.083426));
        IKMAUDITORIUM.add(new LatLng(9.882692,78.083426));
        IKMAUDITORIUM.add(new LatLng(9.882710,78.083130));
        IKMAUDITORIUM.add(new LatLng(9.882731,78.082759));
        IKMAUDITORIUM.add(new LatLng(9.882750,78.082536));
        IKMAUDITORIUM.add(new LatLng(9.882626,78.082537));
        IKMAUDITORIUM.add(new LatLng(9.882505,78.082540));
// IT TO PLACEMENTCELL (IT=9.882399,78.083630) (PLACEMENTCELL=9.885033,78.080967)
        IPLACEMENTCELL.add(new LatLng(9.882399,78.083630));
        IPLACEMENTCELL.add(new LatLng(9.882397,78.083569));
        IPLACEMENTCELL.add(new LatLng(9.882397,78.083506));
        IPLACEMENTCELL.add(new LatLng(9.882397,78.083426));
        IPLACEMENTCELL.add(new LatLng(9.882982,78.083423));
        IPLACEMENTCELL.add(new LatLng(9.883168,78.083267));
        IPLACEMENTCELL.add(new LatLng(9.883211,78.082630));
        IPLACEMENTCELL.add(new LatLng(9.883236,78.081833));
        IPLACEMENTCELL.add(new LatLng(9.883262,78.080870));
        IPLACEMENTCELL.add(new LatLng(9.883286,78.080765));
        IPLACEMENTCELL.add(new LatLng(9.883368,78.080711));
        IPLACEMENTCELL.add(new LatLng(9.883896,78.080727));
        IPLACEMENTCELL.add(new LatLng(9.884735,78.080781));
        IPLACEMENTCELL.add(new LatLng(9.885035,78.080792));
        IPLACEMENTCELL.add(new LatLng(9.885033,78.080967));
// IT TO GUESTHOUSE (IT=9.882399,78.083630) (GUESTHOUSE=9.885219,78.080608)
        IGUESTHOUSE.add(new LatLng(9.882399,78.083630));
        IGUESTHOUSE.add(new LatLng(9.882397,78.083569));
        IGUESTHOUSE.add(new LatLng(9.882397,78.083506));
        IGUESTHOUSE.add(new LatLng(9.882397,78.083426));
        IGUESTHOUSE.add(new LatLng(9.882982,78.083423));
        IGUESTHOUSE.add(new LatLng(9.883168,78.083267));
        IGUESTHOUSE.add(new LatLng(9.883211,78.082630));
        IGUESTHOUSE.add(new LatLng(9.883236,78.081833));
        IGUESTHOUSE.add(new LatLng(9.883262,78.080870));
        IGUESTHOUSE.add(new LatLng(9.883286,78.080765));
        IGUESTHOUSE.add(new LatLng(9.883368,78.080711));
        IGUESTHOUSE.add(new LatLng(9.883896,78.080727));
        IGUESTHOUSE.add(new LatLng(9.884735,78.080781));
        IGUESTHOUSE.add(new LatLng(9.885035,78.080792));
        IGUESTHOUSE.add(new LatLng(9.885210,78.080791));
        IGUESTHOUSE.add(new LatLng(9.885219,78.080608));
// IT TO MAINCANTEEN (IT=9.882399,78.083630) (MAINCANTEEN=9.883294,78.079839)
        IMAINCANTEEN.add(new LatLng(9.882399,78.083630));
        IMAINCANTEEN.add(new LatLng(9.882397,78.083569));
        IMAINCANTEEN.add(new LatLng(9.882397,78.083506));
        IMAINCANTEEN.add(new LatLng(9.882397,78.083426));
        IMAINCANTEEN.add(new LatLng(9.882982,78.083423));
        IMAINCANTEEN.add(new LatLng(9.883168,78.083267));
        IMAINCANTEEN.add(new LatLng(9.883211,78.082630));
        IMAINCANTEEN.add(new LatLng(9.883236,78.081833));
        IMAINCANTEEN.add(new LatLng(9.883262,78.080870));
        IMAINCANTEEN.add(new LatLng(9.883286,78.080765));
        IMAINCANTEEN.add(new LatLng(9.883277,78.080255));
        IMAINCANTEEN.add(new LatLng(9.883294,78.079839));
// IT TO FOODCOURT (IT=9.882399,78.083630) (FOODCOURT=9.883344,78.083246)
        IFOODCOURT.add(new LatLng(9.882399,78.083630));
        IFOODCOURT.add(new LatLng(9.882397,78.083569));
        IFOODCOURT.add(new LatLng(9.882397,78.083506));
        IFOODCOURT.add(new LatLng(9.882397,78.083426));
        IFOODCOURT.add(new LatLng(9.882982,78.083423));
        IFOODCOURT.add(new LatLng(9.883168,78.083267));
        IFOODCOURT.add(new LatLng(9.883198,78.083240));
        IFOODCOURT.add(new LatLng(9.883344,78.083246));
// IT TO MENSHOSTEL (IT=9.882399,78.083630) (MENSHOSTEL=9.884778,78.080063)
        IMENSHOSTEL.add(new LatLng(9.882399,78.083630));
        IMENSHOSTEL.add(new LatLng(9.882397,78.083569));
        IMENSHOSTEL.add(new LatLng(9.882397,78.083506));
        IMENSHOSTEL.add(new LatLng(9.882397,78.083426));
        IMENSHOSTEL.add(new LatLng(9.882982,78.083423));
        IMENSHOSTEL.add(new LatLng(9.883168,78.083267));
        IMENSHOSTEL.add(new LatLng(9.883211,78.082630));
        IMENSHOSTEL.add(new LatLng(9.883236,78.081833));
        IMENSHOSTEL.add(new LatLng(9.883262,78.080870));
        IMENSHOSTEL.add(new LatLng(9.883286,78.080765));
        IMENSHOSTEL.add(new LatLng(9.883368,78.080711));
        IMENSHOSTEL.add(new LatLng(9.883896,78.080727));
        IMENSHOSTEL.add(new LatLng(9.884735,78.080781));
        IMENSHOSTEL.add(new LatLng(9.884765,78.080405));
        IMENSHOSTEL.add(new LatLng(9.884778,78.080063));
// IT TO WOMENSHOSTEL (IT=9.882399,78.083630) (WOMENSHOSTEL=9.878231,78.082057)
        IWOMENSHOSTEL.add(new LatLng(9.882399,78.083630));
        IWOMENSHOSTEL.add(new LatLng(9.882397,78.083569));
        IWOMENSHOSTEL.add(new LatLng(9.882397,78.083506));
        IWOMENSHOSTEL.add(new LatLng(9.882397,78.083426));
        IWOMENSHOSTEL.add(new LatLng(9.881682,78.083426));
        IWOMENSHOSTEL.add(new LatLng(9.881301,78.083517));
        IWOMENSHOSTEL.add(new LatLng(9.880672,78.083442));
        IWOMENSHOSTEL.add(new LatLng(9.880375,78.083386));
        IWOMENSHOSTEL.add(new LatLng(9.879979,78.083493));
        IWOMENSHOSTEL.add(new LatLng(9.879832,78.083329));
        IWOMENSHOSTEL.add(new LatLng(9.879632,78.083372));
        IWOMENSHOSTEL.add(new LatLng(9.879518,78.082975));
        IWOMENSHOSTEL.add(new LatLng(9.879373,78.082685));
        IWOMENSHOSTEL.add(new LatLng(9.879288,78.082626));
        IWOMENSHOSTEL.add(new LatLng(9.878910,78.082653));
        IWOMENSHOSTEL.add(new LatLng(9.878479,78.082776));
        IWOMENSHOSTEL.add(new LatLng(9.878434,78.082095));
        IWOMENSHOSTEL.add(new LatLng(9.878231,78.082057));
// IT TO LIBRARY (IT=9.882399,78.083630) (LIBRARY=9.882929,78.081264)
        ILIBRARY.add(new LatLng(9.882399,78.083630));
        ILIBRARY.add(new LatLng(9.882397,78.083569));
        ILIBRARY.add(new LatLng(9.882397,78.083506));
        ILIBRARY.add(new LatLng(9.882397,78.083426));
        ILIBRARY.add(new LatLng(9.882982,78.083423));
        ILIBRARY.add(new LatLng(9.883168,78.083267));
        ILIBRARY.add(new LatLng(9.883211,78.082630));
        ILIBRARY.add(new LatLng(9.883236,78.081833));
        ILIBRARY.add(new LatLng(9.883236,78.081264));
        ILIBRARY.add(new LatLng(9.882929,78.081264));
// IT TO BANK (IT=9.882399,78.083630) (BANK=9.883489,78.079822)
        IBANK.add(new LatLng(9.882399,78.083630));
        IBANK.add(new LatLng(9.882397,78.083569));
        IBANK.add(new LatLng(9.882397,78.083506));
        IBANK.add(new LatLng(9.882397,78.083426));
        IBANK.add(new LatLng(9.882982,78.083423));
        IBANK.add(new LatLng(9.883168,78.083267));
        IBANK.add(new LatLng(9.883211,78.082630));
        IBANK.add(new LatLng(9.883236,78.081833));
        IBANK.add(new LatLng(9.883262,78.080870));
        IBANK.add(new LatLng(9.883286,78.080765));
        IBANK.add(new LatLng(9.883458,78.080706));
        IBANK.add(new LatLng(9.883489,78.079822));
// IT TO TEMPLE (IT=9.882399,78.083630) (TEMPLE=9.885444,78.080565)
        ITEMPLE.add(new LatLng(9.882399,78.083630));
        ITEMPLE.add(new LatLng(9.882397,78.083569));
        ITEMPLE.add(new LatLng(9.882397,78.083506));
        ITEMPLE.add(new LatLng(9.882397,78.083426));
        ITEMPLE.add(new LatLng(9.882982,78.083423));
        ITEMPLE.add(new LatLng(9.883168,78.083267));
        ITEMPLE.add(new LatLng(9.883211,78.082630));
        ITEMPLE.add(new LatLng(9.883236,78.081833));
        ITEMPLE.add(new LatLng(9.883262,78.080870));
        ITEMPLE.add(new LatLng(9.883286,78.080765));
        ITEMPLE.add(new LatLng(9.883368,78.080711));
        ITEMPLE.add(new LatLng(9.883896,78.080727));
        ITEMPLE.add(new LatLng(9.884735,78.080781));
        ITEMPLE.add(new LatLng(9.885035,78.080792));
        ITEMPLE.add(new LatLng(9.885443,78.080804));
        ITEMPLE.add(new LatLng(9.885444,78.080565));
// IT TO PARKING (IT=9.882399,78.083630) (PARKING=9.883104,78.080942)
        IPARKING.add(new LatLng(9.882399,78.083630));
        IPARKING.add(new LatLng(9.882397,78.083569));
        IPARKING.add(new LatLng(9.882397,78.083506));
        IPARKING.add(new LatLng(9.882397,78.083426));
        IPARKING.add(new LatLng(9.882982,78.083423));
        IPARKING.add(new LatLng(9.883168,78.083267));
        IPARKING.add(new LatLng(9.883211,78.082630));
        IPARKING.add(new LatLng(9.883236,78.081833));
        IPARKING.add(new LatLng(9.883252,78.081003));
        IPARKING.add(new LatLng(9.883106,78.080998));
        IPARKING.add(new LatLng(9.883104,78.080942));

    }
    public void initCSECoordinates()
    {
        //CSE
        CMAINBUILDING.add(new LatLng(9.882797,78.083739));
        CMAINBUILDING.add(new LatLng(9.882896,78.083745));
        CMAINBUILDING.add(new LatLng(9.882884,78.083593));
        CMAINBUILDING.add(new LatLng(9.882893,78.083421));
        CMAINBUILDING.add(new LatLng(9.882891,78.083151));
        CMAINBUILDING.add(new LatLng(9.882904,78.082674));
        CMAINBUILDING.add(new LatLng(9.882881,78.082511));

        CIT.add(new LatLng(9.882797,78.083739));
        CIT.add(new LatLng(9.882896,78.083745));
        CIT.add(new LatLng(9.882884,78.083593));
        CIT.add(new LatLng(9.882692,78.083572));
        CIT.add(new LatLng(9.882513,78.083545));
        CIT.add(new LatLng(9.882397,78.083569));
        CIT.add(new LatLng(9.882399,78.083630));

        CECE.add(new LatLng(9.882797,78.083739));
        CECE.add(new LatLng(9.882896,78.083745));
        CECE.add(new LatLng(9.882884,78.083593));
        CECE.add(new LatLng(9.882893,78.083421));
        CECE.add(new LatLng(9.882891,78.083151));
        CECE.add(new LatLng(9.882904,78.082674));
        CECE.add(new LatLng(9.882820,78.082338));

        CEEE.add(new LatLng(9.882797,78.083739));
        CEEE.add(new LatLng(9.882896,78.083745));
        CEEE.add(new LatLng(9.882884,78.083593));
        CEEE.add(new LatLng(9.882893,78.083421));
        CEEE.add(new LatLng(9.882688,78.083418));
        CEEE.add(new LatLng(9.882711,78.083131));
        CEEE.add(new LatLng(9.882751,78.082437));
        CEEE.add(new LatLng(9.882712,78.082434));
        CEEE.add(new LatLng(9.882612,78.082431));
        CEEE.add(new LatLng(9.882497,78.082425));
        CEEE.add(new LatLng(9.882476,78.082333));
        CEEE.add(new LatLng(9.882466,78.082148));
        CEEE.add(new LatLng(9.882433,78.082086));

        CCIVIL.add(new LatLng(9.882797,78.083739));
        CCIVIL.add(new LatLng(9.882896,78.083745));
        CCIVIL.add(new LatLng(9.882884,78.083593));
        CCIVIL.add(new LatLng(9.882893,78.083421));
        CCIVIL.add(new LatLng(9.882688,78.083418));
        CCIVIL.add(new LatLng(9.882332,78.083411));
        CCIVIL.add(new LatLng(9.882323,78.083187));
        CCIVIL.add(new LatLng(9.882329,78.082917));
        CCIVIL.add(new LatLng(9.882278,78.082855));

        CMECH.add(new LatLng(9.882797,78.083739));
        CMECH.add(new LatLng(9.882896,78.083745));
        CMECH.add(new LatLng(9.882884,78.083593));
        CMECH.add(new LatLng(9.882893,78.083421));
        CMECH.add(new LatLng(9.882688,78.083418));
        CMECH.add(new LatLng(9.882332,78.083411));
        CMECH.add(new LatLng(9.882323,78.083187));
        CMECH.add(new LatLng(9.882329,78.082917));
        CMECH.add(new LatLng(9.882332,78.082360));
        CMECH.add(new LatLng(9.882347,78.081990));
        CMECH.add(new LatLng(9.882376,78.081669));
        CMECH.add(new LatLng(9.882431,78.081627));
        CMECH.add(new LatLng(9.882471,78.081301));
        CMECH.add(new LatLng(9.882602,78.081292));
        CMECH.add(new LatLng(9.882365,78.081429));

        CMECHT.add(new LatLng(9.882797,78.083739));
        CMECHT.add(new LatLng(9.882896,78.083745));
        CMECHT.add(new LatLng(9.882884,78.083593));
        CMECHT.add(new LatLng(9.882893,78.083421));
        CMECHT.add(new LatLng(9.882688,78.083418));
        CMECHT.add(new LatLng(9.882332,78.083411));
        CMECHT.add(new LatLng(9.882323,78.083187));
        CMECHT.add(new LatLng(9.882329,78.082917));
        CMECHT.add(new LatLng(9.882332,78.082360));
        CMECHT.add(new LatLng(9.882347,78.081990));
        CMECHT.add(new LatLng(9.882376,78.081669));
        CMECHT.add(new LatLng(9.882431,78.081627));
        CMECHT.add(new LatLng(9.882471,78.081301));
        CMECHT.add(new LatLng(9.882602,78.081292));
        CMECHT.add(new LatLng(9.882365,78.081428));

        CARCH.add(new LatLng(9.882797,78.083739));
        CARCH.add(new LatLng(9.882896,78.083745));
        CARCH.add(new LatLng(9.882884,78.083593));
        CARCH.add(new LatLng(9.882893,78.083421));
        CARCH.add(new LatLng(9.882397,78.083426));
        CARCH.add(new LatLng(9.881682,78.083426));
        CARCH.add(new LatLng(9.881301,78.083517));
        CARCH.add(new LatLng(9.880672,78.083442));
        CARCH.add(new LatLng(9.880558,78.083080));
        CARCH.add(new LatLng(9.880201,78.083158));
        CARCH.add(new LatLng(9.878790,78.082110));

        CSCIENCEBLOCK.add(new LatLng(9.882797,78.083739));
        CSCIENCEBLOCK.add(new LatLng(9.882896,78.083745));
        CSCIENCEBLOCK.add(new LatLng(9.882884,78.083593));
        CSCIENCEBLOCK.add(new LatLng(9.882893,78.083421));
        CSCIENCEBLOCK.add(new LatLng(9.882397,78.083426));
        CSCIENCEBLOCK.add(new LatLng(9.882178,78.083423));
        CSCIENCEBLOCK.add(new LatLng(9.882173,78.083195));
        CSCIENCEBLOCK.add(new LatLng(9.882160,78.083029));
        CSCIENCEBLOCK.add(new LatLng(9.881816,78.083021));
        CSCIENCEBLOCK.add(new LatLng(9.881876,78.083152));

        CFRESHERBLOCK.add(new LatLng(9.882797,78.083739));
        CFRESHERBLOCK.add(new LatLng(9.882896,78.083745));
        CFRESHERBLOCK.add(new LatLng(9.882884,78.083593));
        CFRESHERBLOCK.add(new LatLng(9.882893,78.083421));
        CFRESHERBLOCK.add(new LatLng(9.882397,78.083426));
        CFRESHERBLOCK.add(new LatLng(9.882178,78.083423));
        CFRESHERBLOCK.add(new LatLng(9.882173,78.083195));
        CFRESHERBLOCK.add(new LatLng(9.882160,78.083029));
        CFRESHERBLOCK.add(new LatLng(9.881950,78.083021));
        CFRESHERBLOCK.add(new LatLng(9.881946,78.082825));
        CFRESHERBLOCK.add(new LatLng(9.88172,78.082617));

        CNCCBLOCK.add(new LatLng(9.882797,78.083739));
        CNCCBLOCK.add(new LatLng(9.882896,78.083745));
        CNCCBLOCK.add(new LatLng(9.882884,78.083593));
        CNCCBLOCK.add(new LatLng(9.882893,78.083421));
        CNCCBLOCK.add(new LatLng(9.882982,78.083423));
        CNCCBLOCK.add(new LatLng(9.883168,78.083267));
        CNCCBLOCK.add(new LatLng(9.883211,78.082630));
        CNCCBLOCK.add(new LatLng(9.883236,78.081833));
        CNCCBLOCK.add(new LatLng(9.883262,78.080870));
        CNCCBLOCK.add(new LatLng(9.883286,78.080765));
        CNCCBLOCK.add(new LatLng(9.883458,78.080706));
        CNCCBLOCK.add(new LatLng(9.883560,78.079803));

        CINDOOR.add(new LatLng(9.882797,78.083739));
        CINDOOR.add(new LatLng(9.882896,78.083745));
        CINDOOR.add(new LatLng(9.882884,78.083593));
        CINDOOR.add(new LatLng(9.882893,78.083421));
        CINDOOR.add(new LatLng(9.882397,78.083426));
        CINDOOR.add(new LatLng(9.881682,78.083426));
        CINDOOR.add(new LatLng(9.881452,78.083488));
        CINDOOR.add(new LatLng(9.881540,78.082662));
        CINDOOR.add(new LatLng(9.880959,78.082606));
        CINDOOR.add(new LatLng(9.880761,78.082324));
        CINDOOR.add(new LatLng(9.880621,78.082225));
        CINDOOR.add(new LatLng(9.879701,78.081978));
        CINDOOR.add(new LatLng(9.879215,78.081785));
        CINDOOR.add(new LatLng(9.878496,78.081654));
        CINDOOR.add(new LatLng(9.877774,78.081405));
        CINDOOR.add(new LatLng(9.877578,78.081330));
        CINDOOR.add(new LatLng(9.877596,78.080995));
        CINDOOR.add(new LatLng(9.882838,78.082683));

        COUTDOOR.add(new LatLng(9.882797,78.083739));
        COUTDOOR.add(new LatLng(9.882896,78.083745));
        COUTDOOR.add(new LatLng(9.882884,78.083593));
        COUTDOOR.add(new LatLng(9.882893,78.083421));
        COUTDOOR.add(new LatLng(9.882982,78.083423));
        COUTDOOR.add(new LatLng(9.883168,78.083267));
        COUTDOOR.add(new LatLng(9.883211,78.082630));
        COUTDOOR.add(new LatLng(9.883236,78.081833));
        COUTDOOR.add(new LatLng(9.883842,78.081407));

        CKSAUDITORIUM.add(new LatLng(9.882797,78.083739));
        CKSAUDITORIUM.add(new LatLng(9.882896,78.083745));
        CKSAUDITORIUM.add(new LatLng(9.882884,78.083593));
        CKSAUDITORIUM.add(new LatLng(9.882893,78.083421));
        CKSAUDITORIUM.add(new LatLng(9.882891,78.083151));
        CKSAUDITORIUM.add(new LatLng(9.882904,78.082674));
        CKSAUDITORIUM.add(new LatLng(9.882904,78.082272));
        CKSAUDITORIUM.add(new LatLng(9.882914,78.081975));
        CKSAUDITORIUM.add(new LatLng(9.882820,78.082337));

        CKMAUDITORIUM.add(new LatLng(9.882797,78.083739));
        CKMAUDITORIUM.add(new LatLng(9.882896,78.083745));
        CKMAUDITORIUM.add(new LatLng(9.882884,78.083593));
        CKMAUDITORIUM.add(new LatLng(9.882893,78.083421));
        CKMAUDITORIUM.add(new LatLng(9.882688,78.083418));
        CKMAUDITORIUM.add(new LatLng(9.882711,78.083131));
        CKMAUDITORIUM.add(new LatLng(9.882737,78.082534));
        CKMAUDITORIUM.add(new LatLng(9.882480,78.082541));

        CPLACEMENTCELL.add(new LatLng(9.882797,78.083739));
        CPLACEMENTCELL.add(new LatLng(9.882896,78.083745));
        CPLACEMENTCELL.add(new LatLng(9.882884,78.083593));
        CPLACEMENTCELL.add(new LatLng(9.882893,78.083421));
        CPLACEMENTCELL.add(new LatLng(9.882982,78.083423));
        CPLACEMENTCELL.add(new LatLng(9.883168,78.083267));
        CPLACEMENTCELL.add(new LatLng(9.883211,78.082630));
        CPLACEMENTCELL.add(new LatLng(9.883236,78.081833));
        CPLACEMENTCELL.add(new LatLng(9.883262,78.080870));
        CPLACEMENTCELL.add(new LatLng(9.883286,78.080765));
        CPLACEMENTCELL.add(new LatLng(9.883368,78.080711));
        CPLACEMENTCELL.add(new LatLng(9.883896,78.080727));
        CPLACEMENTCELL.add(new LatLng(9.884735,78.080781));
        CPLACEMENTCELL.add(new LatLng(9.885035,78.080792));
        CPLACEMENTCELL.add(new LatLng(9.885026,78.080954));

        CGUESTHOUSE.add(new LatLng(9.882797,78.083739));
        CGUESTHOUSE.add(new LatLng(9.882896,78.083745));
        CGUESTHOUSE.add(new LatLng(9.882884,78.083593));
        CGUESTHOUSE.add(new LatLng(9.882893,78.083421));
        CGUESTHOUSE.add(new LatLng(9.882982,78.083423));
        CGUESTHOUSE.add(new LatLng(9.883168,78.083267));
        CGUESTHOUSE.add(new LatLng(9.883211,78.082630));
        CGUESTHOUSE.add(new LatLng(9.883236,78.081833));
        CGUESTHOUSE.add(new LatLng(9.883262,78.080870));
        CGUESTHOUSE.add(new LatLng(9.883286,78.080765));
        CGUESTHOUSE.add(new LatLng(9.883368,78.080711));
        CGUESTHOUSE.add(new LatLng(9.883896,78.080727));
        CGUESTHOUSE.add(new LatLng(9.884735,78.080781));
        CGUESTHOUSE.add(new LatLng(9.885035,78.080792));
        CGUESTHOUSE.add(new LatLng(9.885210,78.080791));
        CGUESTHOUSE.add(new LatLng(9.885211,78.080632));

        CMAINCANTEEN.add(new LatLng(9.882797,78.083739));
        CMAINCANTEEN.add(new LatLng(9.882896,78.083745));
        CMAINCANTEEN.add(new LatLng(9.882884,78.083593));
        CMAINCANTEEN.add(new LatLng(9.882893,78.083421));
        CMAINCANTEEN.add(new LatLng(9.882982,78.083423));
        CMAINCANTEEN.add(new LatLng(9.883168,78.083267));
        CMAINCANTEEN.add(new LatLng(9.883211,78.082630));
        CMAINCANTEEN.add(new LatLng(9.883236,78.081833));
        CMAINCANTEEN.add(new LatLng(9.883262,78.080870));
        CMAINCANTEEN.add(new LatLng(9.883286,78.080765));
        CMAINCANTEEN.add(new LatLng(9.883277,78.080255));
        CMAINCANTEEN.add(new LatLng(9.883264,78.079857));

        CFOODCOURT.add(new LatLng(9.882797,78.083739));
        CFOODCOURT.add(new LatLng(9.882896,78.083745));
        CFOODCOURT.add(new LatLng(9.882884,78.083593));
        CFOODCOURT.add(new LatLng(9.882893,78.083421));
        CFOODCOURT.add(new LatLng(9.882982,78.083423));
        CFOODCOURT.add(new LatLng(9.883168,78.083267));
        CFOODCOURT.add(new LatLng(9.883198,78.083240));
        CFOODCOURT.add(new LatLng(9.883282,78.083236));

        CMENSHOSTEL.add(new LatLng(9.882797,78.083739));
        CMENSHOSTEL.add(new LatLng(9.882896,78.083745));
        CMENSHOSTEL.add(new LatLng(9.882884,78.083593));
        CMENSHOSTEL.add(new LatLng(9.882893,78.083421));
        CMENSHOSTEL.add(new LatLng(9.882982,78.083423));
        CMENSHOSTEL.add(new LatLng(9.883168,78.083267));
        CMENSHOSTEL.add(new LatLng(9.883211,78.082630));
        CMENSHOSTEL.add(new LatLng(9.883236,78.081833));
        CMENSHOSTEL.add(new LatLng(9.883262,78.080870));
        CMENSHOSTEL.add(new LatLng(9.883286,78.080765));
        CMENSHOSTEL.add(new LatLng(9.883368,78.080711));
        CMENSHOSTEL.add(new LatLng(9.883896,78.080727));
        CMENSHOSTEL.add(new LatLng(9.884735,78.080781));
        CMENSHOSTEL.add(new LatLng(9.884765,78.080405));
        CMENSHOSTEL.add(new LatLng(9.884738,78.080071));

        CWOMENSHOSTEL.add(new LatLng(9.882797,78.083739));
        CWOMENSHOSTEL.add(new LatLng(9.882896,78.083745));
        CWOMENSHOSTEL.add(new LatLng(9.882884,78.083593));
        CWOMENSHOSTEL.add(new LatLng(9.882893,78.083421));
        CWOMENSHOSTEL.add(new LatLng(9.882397,78.083426));
        CWOMENSHOSTEL.add(new LatLng(9.881682,78.083426));
        CWOMENSHOSTEL.add(new LatLng(9.881301,78.083517));
        CWOMENSHOSTEL.add(new LatLng(9.880672,78.083442));
        CWOMENSHOSTEL.add(new LatLng(9.880375,78.083386));
        CWOMENSHOSTEL.add(new LatLng(9.879979,78.083493));
        CWOMENSHOSTEL.add(new LatLng(9.879832,78.083329));
        CWOMENSHOSTEL.add(new LatLng(9.879632,78.083372));
        CWOMENSHOSTEL.add(new LatLng(9.879518,78.082975));
        CWOMENSHOSTEL.add(new LatLng(9.879373,78.082685));
        CWOMENSHOSTEL.add(new LatLng(9.879288,78.082626));
        CWOMENSHOSTEL.add(new LatLng(9.878910,78.082653));
        CWOMENSHOSTEL.add(new LatLng(9.878479,78.082776));
        CWOMENSHOSTEL.add(new LatLng(9.878434,78.082095));
        CWOMENSHOSTEL.add(new LatLng(9.878201,78.082072));

        CLIBRARY.add(new LatLng(9.882797,78.083739));
        CLIBRARY.add(new LatLng(9.882896,78.083745));
        CLIBRARY.add(new LatLng(9.882884,78.083593));
        CLIBRARY.add(new LatLng(9.882893,78.083421));
        CLIBRARY.add(new LatLng(9.882982,78.083423));
        CLIBRARY.add(new LatLng(9.883168,78.083267));
        CLIBRARY.add(new LatLng(9.883211,78.082630));
        CLIBRARY.add(new LatLng(9.883236,78.081833));
        CLIBRARY.add(new LatLng(9.883236,78.081264));
        CLIBRARY.add(new LatLng(9.882854,78.081243));

        CBANK.add(new LatLng(9.882797,78.083739));
        CBANK.add(new LatLng(9.882896,78.083745));
        CBANK.add(new LatLng(9.882884,78.083593));
        CBANK.add(new LatLng(9.882893,78.083421));
        CBANK.add(new LatLng(9.882982,78.083423));
        CBANK.add(new LatLng(9.883168,78.083267));
        CBANK.add(new LatLng(9.883211,78.082630));
        CBANK.add(new LatLng(9.883236,78.081833));
        CBANK.add(new LatLng(9.883262,78.080870));
        CBANK.add(new LatLng(9.883286,78.080765));
        CBANK.add(new LatLng(9.883458,78.080706));
        CBANK.add(new LatLng(9.883496,78.079848));

        CTEMPLE.add(new LatLng(9.882797,78.083739));
        CTEMPLE.add(new LatLng(9.882896,78.083745));
        CTEMPLE.add(new LatLng(9.882884,78.083593));
        CTEMPLE.add(new LatLng(9.882893,78.083421));
        CTEMPLE.add(new LatLng(9.882982,78.083423));
        CTEMPLE.add(new LatLng(9.883168,78.083267));
        CTEMPLE.add(new LatLng(9.883211,78.082630));
        CTEMPLE.add(new LatLng(9.883236,78.081833));
        CTEMPLE.add(new LatLng(9.883262,78.080870));
        CTEMPLE.add(new LatLng(9.883286,78.080765));
        CTEMPLE.add(new LatLng(9.883368,78.080711));
        CTEMPLE.add(new LatLng(9.883896,78.080727));
        CTEMPLE.add(new LatLng(9.884735,78.080781));
        CTEMPLE.add(new LatLng(9.885035,78.080792));
        CTEMPLE.add(new LatLng(9.885443,78.080804));
        CTEMPLE.add(new LatLng(9.885459,78.080574));

        CPARKING.add(new LatLng(9.882797,78.083739));
        CPARKING.add(new LatLng(9.882896,78.083745));
        CPARKING.add(new LatLng(9.882884,78.083593));
        CPARKING.add(new LatLng(9.882893,78.083421));
        CPARKING.add(new LatLng(9.882982,78.083423));
        CPARKING.add(new LatLng(9.883168,78.083267));
        CPARKING.add(new LatLng(9.883211,78.082630));
        CPARKING.add(new LatLng(9.883236,78.081833));
        CPARKING.add(new LatLng(9.883252,78.081003));
        CPARKING.add(new LatLng(9.883106,78.080998));
        CPARKING.add(new LatLng(9.882769,78.080846));
    }
    public void initECECoordinates()
    {
        //ECE
        ECMAINBUILDING.add(new LatLng(9.882820,78.082338));
        ECMAINBUILDING.add(new LatLng(9.882881,78.082511));

        ECIT.add(new LatLng(9.882820,78.082338));
        ECIT.add(new LatLng(9.882750,78.082536));
        ECIT.add(new LatLng(9.882731,78.082759));
        ECIT.add(new LatLng(9.882710,78.083130));
        ECIT.add(new LatLng(9.882692,78.083426));
        ECIT.add(new LatLng(9.882397,78.083426));
        ECIT.add(new LatLng(9.882397,78.083506));
        ECIT.add(new LatLng(9.882397,78.083569));
        ECIT.add(new LatLng(9.882399,78.083630));

        ECCSE.add(new LatLng(9.882820,78.082338));
        ECCSE.add(new LatLng(9.882904,78.082674));
        ECCSE.add(new LatLng(9.882891,78.083151));
        ECCSE.add(new LatLng(9.882893,78.083421));
        ECCSE.add(new LatLng(9.882884,78.083593));
        ECCSE.add(new LatLng(9.882896,78.083745));
        ECCSE.add(new LatLng(9.882797,78.083739));

        ECEEE.add(new LatLng(9.882820,78.082338));
        ECEEE.add(new LatLng(9.882759,78.082433));
        ECEEE.add(new LatLng(9.882759,78.082532));
        ECEEE.add(new LatLng(9.882727,78.082532));
        ECEEE.add(new LatLng(9.882727,78.082435));
        ECEEE.add(new LatLng(9.882625,78.082435));
        ECEEE.add(new LatLng(9.882463,78.082426));
        ECEEE.add(new LatLng(9.882463,78.082342));
        ECEEE.add(new LatLng(9.882463,78.082176));
        ECEEE.add(new LatLng(9.882433,78.082086));

        ECCIVIL.add(new LatLng(9.882820,78.082338));
        ECCIVIL.add(new LatLng(9.882820,78.082338));
        ECCIVIL.add(new LatLng(9.882759,78.082433));
        ECCIVIL.add(new LatLng(9.882759,78.082532));
        ECCIVIL.add(new LatLng(9.882727,78.082532));
        ECCIVIL.add(new LatLng(9.882720,78.082638));
        ECCIVIL.add(new LatLng(9.882560,78.082638));
        ECCIVIL.add(new LatLng(9.882345,78.082638));
        ECCIVIL.add(new LatLng(9.882345,78.082764));
        ECCIVIL.add(new LatLng(9.882278,78.082855));

        ECMECH.add(new LatLng(9.882820,78.082338));
        ECMECH.add(new LatLng(9.882820,78.082338));
        ECMECH.add(new LatLng(9.882820,78.082338));
        ECMECH.add(new LatLng(9.882759,78.082433));
        ECMECH.add(new LatLng(9.882759,78.082532));
        ECMECH.add(new LatLng(9.882727,78.082532));
        ECMECH.add(new LatLng(9.882727,78.082312));
        ECMECH.add(new LatLng(9.882727,78.081947));
        ECMECH.add(new LatLng(9.882727,78.081601));
        ECMECH.add(new LatLng(9.882727,78.081303));
        ECMECH.add(new LatLng(9.882365,78.081429));

        ECMECHT.add(new LatLng(9.882820,78.082338));
        ECMECHT.add(new LatLng(9.882820,78.082338));
        ECMECHT.add(new LatLng(9.882820,78.082338));
        ECMECHT.add(new LatLng(9.882759,78.082433));
        ECMECHT.add(new LatLng(9.882759,78.082532));
        ECMECHT.add(new LatLng(9.882727,78.082532));
        ECMECHT.add(new LatLng(9.882727,78.082312));
        ECMECHT.add(new LatLng(9.882727,78.081947));
        ECMECHT.add(new LatLng(9.882727,78.081601));
        ECMECHT.add(new LatLng(9.882727,78.081303));
        ECMECHT.add(new LatLng(9.882365,78.081428));

        ECARCH.add(new LatLng(9.882820,78.082338));
        ECARCH.add(new LatLng(9.882750,78.082536));
        ECARCH.add(new LatLng(9.882731,78.082759));
        ECARCH.add(new LatLng(9.882710,78.083130));
        ECARCH.add(new LatLng(9.882691,78.083267));
        ECARCH.add(new LatLng(9.882554,78.083288));
        ECARCH.add(new LatLng(9.882398,78.083309));
        ECARCH.add(new LatLng(9.882319,78.083360));
        ECARCH.add(new LatLng(9.882208,78.083411));
        ECARCH.add(new LatLng(9.881682,78.083426));
        ECARCH.add(new LatLng(9.881301,78.083517));
        ECARCH.add(new LatLng(9.880672,78.083442));
        ECARCH.add(new LatLng(9.880558,78.083080));
        ECARCH.add(new LatLng(9.880201,78.083158));
        ECARCH.add(new LatLng(9.878790,78.082110));

        ECSCIENCEBLOCK.add(new LatLng(9.882820,78.082338));
        ECSCIENCEBLOCK.add(new LatLng(9.882750,78.082536));
        ECSCIENCEBLOCK.add(new LatLng(9.882731,78.082759));
        ECSCIENCEBLOCK.add(new LatLng(9.882710,78.083130));
        ECSCIENCEBLOCK.add(new LatLng(9.882691,78.083267));
        ECSCIENCEBLOCK.add(new LatLng(9.882493,78.083267));
        ECSCIENCEBLOCK.add(new LatLng(9.882171,78.083267));
        ECSCIENCEBLOCK.add(new LatLng(9.882160,78.083029));
        ECSCIENCEBLOCK.add(new LatLng(9.881816,78.083021));
        ECSCIENCEBLOCK.add(new LatLng(9.881876,78.083152));

        ECFRESHERBLOCK.add(new LatLng(9.882820,78.082338));
        ECFRESHERBLOCK.add(new LatLng(9.882750,78.082536));
        ECFRESHERBLOCK.add(new LatLng(9.882731,78.082759));
        ECFRESHERBLOCK.add(new LatLng(9.882710,78.083130));
        ECFRESHERBLOCK.add(new LatLng(9.882691,78.083267));
        ECFRESHERBLOCK.add(new LatLng(9.882493,78.083267));
        ECFRESHERBLOCK.add(new LatLng(9.882171,78.083267));
        ECFRESHERBLOCK.add(new LatLng(9.882160,78.083029));
        ECFRESHERBLOCK.add(new LatLng(9.881950,78.083021));
        ECFRESHERBLOCK.add(new LatLng(9.881946,78.082825));
        ECFRESHERBLOCK.add(new LatLng(9.88172,78.082617));

        ECNCCBLOCK.add(new LatLng(9.882820,78.082338));
        ECNCCBLOCK.add(new LatLng(9.883016,78.082341));
        ECNCCBLOCK.add(new LatLng(9.883225,78.082341));
        ECNCCBLOCK.add(new LatLng(9.883236,78.081833));
        ECNCCBLOCK.add(new LatLng(9.883262,78.080870));
        ECNCCBLOCK.add(new LatLng(9.883286,78.080765));
        ECNCCBLOCK.add(new LatLng(9.883458,78.080706));
        ECNCCBLOCK.add(new LatLng(9.883560,78.079803));

        ECINDOOR.add(new LatLng(9.882820,78.082338));
        ECINDOOR.add(new LatLng(9.882750,78.082536));
        ECINDOOR.add(new LatLng(9.882731,78.082759));
        ECINDOOR.add(new LatLng(9.882710,78.083130));
        ECINDOOR.add(new LatLng(9.882691,78.083267));
        ECINDOOR.add(new LatLng(9.882554,78.083288));
        ECINDOOR.add(new LatLng(9.882398,78.083309));
        ECINDOOR.add(new LatLng(9.882319,78.083360));
        ECINDOOR.add(new LatLng(9.882208,78.083411));
        ECINDOOR.add(new LatLng(9.881682,78.083426));
        ECINDOOR.add(new LatLng(9.881452,78.083488));
        ECINDOOR.add(new LatLng(9.881540,78.082662));
        ECINDOOR.add(new LatLng(9.880959,78.082606));
        ECINDOOR.add(new LatLng(9.880761,78.082324));
        ECINDOOR.add(new LatLng(9.880621,78.082225));
        ECINDOOR.add(new LatLng(9.879701,78.081978));
        ECINDOOR.add(new LatLng(9.879215,78.081785));
        ECINDOOR.add(new LatLng(9.878496,78.081654));
        ECINDOOR.add(new LatLng(9.877774,78.081405));
        ECINDOOR.add(new LatLng(9.877578,78.081330));
        ECINDOOR.add(new LatLng(9.877596,78.080995));
        ECINDOOR.add(new LatLng(9.882838,78.082683));

        ECOUTDOOR.add(new LatLng(9.882820,78.082338));
        ECOUTDOOR.add(new LatLng(9.883016,78.082341));
        ECOUTDOOR.add(new LatLng(9.883225,78.082341));
        ECOUTDOOR.add(new LatLng(9.883236,78.081833));
        ECOUTDOOR.add(new LatLng(9.883842,78.081407));

        ECKSAUDITORIUM.add(new LatLng(9.882820,78.082338));
        ECKSAUDITORIUM.add(new LatLng(9.882897,78.082341));
        ECKSAUDITORIUM.add(new LatLng(9.882897,78.081976));
        ECKSAUDITORIUM.add(new LatLng(9.882820,78.082337));

        ECKMAUDITORIUM.add(new LatLng(9.882820,78.082338));
        ECKMAUDITORIUM.add(new LatLng(9.882759,78.082433));
        ECKMAUDITORIUM.add(new LatLng(9.882759,78.082532));
        ECKMAUDITORIUM.add(new LatLng(9.882727,78.082532));
        ECKMAUDITORIUM.add(new LatLng(9.882480,78.082541));

        ECPLACEMENTCELL.add(new LatLng(9.882820,78.082338));
        ECPLACEMENTCELL.add(new LatLng(9.883016,78.082341));
        ECPLACEMENTCELL.add(new LatLng(9.883225,78.082341));
        ECPLACEMENTCELL.add(new LatLng(9.883236,78.081833));
        ECPLACEMENTCELL.add(new LatLng(9.883262,78.080870));
        ECPLACEMENTCELL.add(new LatLng(9.883286,78.080765));
        ECPLACEMENTCELL.add(new LatLng(9.883368,78.080711));
        ECPLACEMENTCELL.add(new LatLng(9.883896,78.080727));
        ECPLACEMENTCELL.add(new LatLng(9.884735,78.080781));
        ECPLACEMENTCELL.add(new LatLng(9.885035,78.080792));
        ECPLACEMENTCELL.add(new LatLng(9.885026,78.080954));

        ECGUESTHOUSE.add(new LatLng(9.882820,78.082338));
        ECGUESTHOUSE.add(new LatLng(9.883016,78.082341));
        ECGUESTHOUSE.add(new LatLng(9.883225,78.082341));
        ECGUESTHOUSE.add(new LatLng(9.883236,78.081833));
        ECGUESTHOUSE.add(new LatLng(9.883262,78.080870));
        ECGUESTHOUSE.add(new LatLng(9.883286,78.080765));
        ECGUESTHOUSE.add(new LatLng(9.883368,78.080711));
        ECGUESTHOUSE.add(new LatLng(9.883896,78.080727));
        ECGUESTHOUSE.add(new LatLng(9.884735,78.080781));
        ECGUESTHOUSE.add(new LatLng(9.885035,78.080792));
        ECGUESTHOUSE.add(new LatLng(9.885210,78.080791));
        ECGUESTHOUSE.add(new LatLng(9.885211,78.080632));

        ECMAINCANTEEN.add(new LatLng(9.882820,78.082338));
        ECMAINCANTEEN.add(new LatLng(9.883016,78.082341));
        ECMAINCANTEEN.add(new LatLng(9.883225,78.082341));
        ECMAINCANTEEN.add(new LatLng(9.883236,78.081833));
        ECMAINCANTEEN.add(new LatLng(9.883262,78.080870));
        ECMAINCANTEEN.add(new LatLng(9.883286,78.080765));
        ECMAINCANTEEN.add(new LatLng(9.883277,78.080255));
        ECMAINCANTEEN.add(new LatLng(9.883264,78.079857));

        ECFOODCOURT.add(new LatLng(9.882820,78.082338));
        ECFOODCOURT.add(new LatLng(9.883016,78.082341));
        ECFOODCOURT.add(new LatLng(9.883225,78.082341));
        ECFOODCOURT.add(new LatLng(9.883225,78.082669));
        ECFOODCOURT.add(new LatLng(9.883225,78.083187));
        ECFOODCOURT.add(new LatLng(9.883282,78.083236));

        ECMENSHOSTEL.add(new LatLng(9.882820,78.082338));
        ECMENSHOSTEL.add(new LatLng(9.883016,78.082341));
        ECMENSHOSTEL.add(new LatLng(9.883225,78.082341));
        ECMENSHOSTEL.add(new LatLng(9.883236,78.081833));
        ECMENSHOSTEL.add(new LatLng(9.883262,78.080870));
        ECMENSHOSTEL.add(new LatLng(9.883286,78.080765));
        ECMENSHOSTEL.add(new LatLng(9.883368,78.080711));
        ECMENSHOSTEL.add(new LatLng(9.883896,78.080727));
        ECMENSHOSTEL.add(new LatLng(9.884735,78.080781));
        ECMENSHOSTEL.add(new LatLng(9.884765,78.080405));
        ECMENSHOSTEL.add(new LatLng(9.884738,78.080071));

        ECWOMENSHOSTEL.add(new LatLng(9.882820,78.082338));
        ECWOMENSHOSTEL.add(new LatLng(9.882750,78.082536));
        ECWOMENSHOSTEL.add(new LatLng(9.882731,78.082759));
        ECWOMENSHOSTEL.add(new LatLng(9.882710,78.083130));
        ECWOMENSHOSTEL.add(new LatLng(9.882691,78.083267));
        ECWOMENSHOSTEL.add(new LatLng(9.882554,78.083288));
        ECWOMENSHOSTEL.add(new LatLng(9.882398,78.083309));
        ECWOMENSHOSTEL.add(new LatLng(9.882319,78.083360));
        ECWOMENSHOSTEL.add(new LatLng(9.882208,78.083411));
        ECWOMENSHOSTEL.add(new LatLng(9.881682,78.083426));
        ECWOMENSHOSTEL.add(new LatLng(9.881301,78.083517));
        ECWOMENSHOSTEL.add(new LatLng(9.880672,78.083442));
        ECWOMENSHOSTEL.add(new LatLng(9.880375,78.083386));
        ECWOMENSHOSTEL.add(new LatLng(9.879979,78.083493));
        ECWOMENSHOSTEL.add(new LatLng(9.879832,78.083329));
        ECWOMENSHOSTEL.add(new LatLng(9.879632,78.083372));
        ECWOMENSHOSTEL.add(new LatLng(9.879518,78.082975));
        ECWOMENSHOSTEL.add(new LatLng(9.879373,78.082685));
        ECWOMENSHOSTEL.add(new LatLng(9.879288,78.082626));
        ECWOMENSHOSTEL.add(new LatLng(9.878910,78.082653));
        ECWOMENSHOSTEL.add(new LatLng(9.878479,78.082776));
        ECWOMENSHOSTEL.add(new LatLng(9.878434,78.082095));
        ECWOMENSHOSTEL.add(new LatLng(9.878201,78.082072));

        ECLIBRARY.add(new LatLng(9.882820,78.082338));
        ECLIBRARY.add(new LatLng(9.883016,78.082341));
        ECLIBRARY.add(new LatLng(9.883016,78.081885));
        ECLIBRARY.add(new LatLng(9.883016,78.081264));
        ECLIBRARY.add(new LatLng(9.882854,78.081243));

        ECBANK.add(new LatLng(9.882820,78.082338));
        ECBANK.add(new LatLng(9.883016,78.082341));
        ECBANK.add(new LatLng(9.883225,78.082341));
        ECBANK.add(new LatLng(9.883236,78.081833));
        ECBANK.add(new LatLng(9.883262,78.080870));
        ECBANK.add(new LatLng(9.883286,78.080765));
        ECBANK.add(new LatLng(9.883458,78.080706));
        ECBANK.add(new LatLng(9.883496,78.079848));

        ECTEMPLE.add(new LatLng(9.882820,78.082338));
        ECTEMPLE.add(new LatLng(9.883016,78.082341));
        ECTEMPLE.add(new LatLng(9.883225,78.082341));
        ECTEMPLE.add(new LatLng(9.883236,78.081833));
        ECTEMPLE.add(new LatLng(9.883262,78.080870));
        ECTEMPLE.add(new LatLng(9.883286,78.080765));
        ECTEMPLE.add(new LatLng(9.883368,78.080711));
        ECTEMPLE.add(new LatLng(9.883896,78.080727));
        ECTEMPLE.add(new LatLng(9.884735,78.080781));
        ECTEMPLE.add(new LatLng(9.885035,78.080792));
        ECTEMPLE.add(new LatLng(9.885443,78.080804));
        ECTEMPLE.add(new LatLng(9.885459,78.080574));

        ECPARKING.add(new LatLng(9.882820,78.082338));
        ECPARKING.add(new LatLng(9.883016,78.082341));
        ECPARKING.add(new LatLng(9.883225,78.082341));
        ECPARKING.add(new LatLng(9.883236,78.081833));
        ECPARKING.add(new LatLng(9.883252,78.081003));
        ECPARKING.add(new LatLng(9.883106,78.080998));
        ECPARKING.add(new LatLng(9.882769,78.080846));

    }
    public void initEEECoordinates()
    {
        //EEE
        EEMAINBUILDING.add(new LatLng(9.882436,78.082038));
        EEMAINBUILDING.add(new LatLng(9.882463,78.082176));
        EEMAINBUILDING.add(new LatLng(9.882463,78.082342));
        EEMAINBUILDING.add(new LatLng(9.882463,78.082426));
        EEMAINBUILDING.add(new LatLng(9.882625,78.082435));
        EEMAINBUILDING.add(new LatLng(9.882727,78.082435));
        EEMAINBUILDING.add(new LatLng(9.882727,78.082532));
        EEMAINBUILDING.add(new LatLng(9.882759,78.082532));
        EEMAINBUILDING.add(new LatLng(9.882881,78.082511));

        EEIT.add(new LatLng(9.882436,78.082038));
        EEIT.add(new LatLng(9.882469,78.082038));
        EEIT.add(new LatLng(9.882469,78.082222));
        EEIT.add(new LatLng(9.882469,78.082409));
        EEIT.add(new LatLng(9.882324,78.082409));
        EEIT.add(new LatLng(9.882324,78.082820));
        EEIT.add(new LatLng(9.882324,78.083199));
        EEIT.add(new LatLng(9.882326,78.083423));
        EEIT.add(new LatLng(9.882397,78.083426));
        EEIT.add(new LatLng(9.882397,78.083506));
        EEIT.add(new LatLng(9.882397,78.083569));
        EEIT.add(new LatLng(9.882399,78.083630));

        EECSE.add(new LatLng(9.882436,78.082038));
        EECSE.add(new LatLng(9.882466,78.082148));
        EECSE.add(new LatLng(9.882476,78.082333));
        EECSE.add(new LatLng(9.882497,78.082425));
        EECSE.add(new LatLng(9.882612,78.082431));
        EECSE.add(new LatLng(9.882712,78.082434));
        EECSE.add(new LatLng(9.882751,78.082437));
        EECSE.add(new LatLng(9.882711,78.083131));
        EECSE.add(new LatLng(9.882688,78.083418));
        EECSE.add(new LatLng(9.882893,78.083421));
        EECSE.add(new LatLng(9.882884,78.083593));
        EECSE.add(new LatLng(9.882896,78.083745));
        EECSE.add(new LatLng(9.882797,78.083739));

        EEECE.add(new LatLng(9.882436,78.082038));
        EEECE.add(new LatLng(9.882463,78.082176));
        EEECE.add(new LatLng(9.882463,78.082342));
        EEECE.add(new LatLng(9.882463,78.082426));
        EEECE.add(new LatLng(9.882625,78.082435));
        EEECE.add(new LatLng(9.882727,78.082435));
        EEECE.add(new LatLng(9.882727,78.082532));
        EEECE.add(new LatLng(9.882759,78.082532));
        EEECE.add(new LatLng(9.882759,78.082433));
        EEECE.add(new LatLng(9.882820,78.082338));

        EECIVIL.add(new LatLng(9.882436,78.082038));
        EECIVIL.add(new LatLng(9.882464,78.082037));
        EECIVIL.add(new LatLng(9.882464,78.082333));
        EECIVIL.add(new LatLng(9.882464,78.082422));
        EECIVIL.add(new LatLng(9.882341,78.082422));
        EECIVIL.add(new LatLng(9.882341,78.082764));
        EECIVIL.add(new LatLng(9.882278,78.082855));

        EEMECH.add(new LatLng(9.882436,78.082038));
        EEMECH.add(new LatLng(9.882468,78.082038));
        EEMECH.add(new LatLng(9.882468,78.081753));
        EEMECH.add(new LatLng(9.882432,78.081753));
        EEMECH.add(new LatLng(9.882432,78.081634));
        EEMECH.add(new LatLng(9.882477,78.081317));
        EEMECH.add(new LatLng(9.882707,78.081317));
        EEMECH.add(new LatLng(9.882365,78.081429));

        EEMECHT.add(new LatLng(9.882436,78.082038));
        EEMECHT.add(new LatLng(9.882468,78.082038));
        EEMECHT.add(new LatLng(9.882468,78.081753));
        EEMECHT.add(new LatLng(9.882432,78.081753));
        EEMECHT.add(new LatLng(9.882432,78.081634));
        EEMECHT.add(new LatLng(9.882477,78.081317));
        EEMECHT.add(new LatLng(9.882707,78.081317));
        EEMECHT.add(new LatLng(9.882365,78.081428));

        EEARCH.add(new LatLng(9.882436,78.082038));
        EEARCH.add(new LatLng(9.882464,78.082037));
        EEARCH.add(new LatLng(9.882464,78.082333));
        EEARCH.add(new LatLng(9.882464,78.082422));
        EEARCH.add(new LatLng(9.882341,78.082422));
        EEARCH.add(new LatLng(9.882341,78.082764));
        EEARCH.add(new LatLng(9.882341,78.083190));
        EEARCH.add(new LatLng(9.882341,78.083402));
        EEARCH.add(new LatLng(9.881682,78.083426));
        EEARCH.add(new LatLng(9.881301,78.083517));
        EEARCH.add(new LatLng(9.880672,78.083442));
        EEARCH.add(new LatLng(9.880558,78.083080));
        EEARCH.add(new LatLng(9.880201,78.083158));
        EEARCH.add(new LatLng(9.878790,78.082110));

        EESCIENCEBLOCK.add(new LatLng(9.882436,78.082038));
        EESCIENCEBLOCK.add(new LatLng(9.882436,78.082038));
        EESCIENCEBLOCK.add(new LatLng(9.882464,78.082037));
        EESCIENCEBLOCK.add(new LatLng(9.882464,78.082333));
        EESCIENCEBLOCK.add(new LatLng(9.882464,78.082422));
        EESCIENCEBLOCK.add(new LatLng(9.882341,78.082422));
        EESCIENCEBLOCK.add(new LatLng(9.882341,78.082342));
        EESCIENCEBLOCK.add(new LatLng(9.882238,78.082342));
        EESCIENCEBLOCK.add(new LatLng(9.882066,78.082397));
        EESCIENCEBLOCK.add(new LatLng(9.881912,78.082477));
        EESCIENCEBLOCK.add(new LatLng(9.881912,78.082744));
        EESCIENCEBLOCK.add(new LatLng(9.881912,78.083111));
        EESCIENCEBLOCK.add(new LatLng(9.881876,78.083152));

        EEFRESHERBLOCK.add(new LatLng(9.882436,78.082038));
        EEFRESHERBLOCK.add(new LatLng(9.882436,78.082038));
        EEFRESHERBLOCK.add(new LatLng(9.882464,78.082037));
        EEFRESHERBLOCK.add(new LatLng(9.882464,78.082333));
        EEFRESHERBLOCK.add(new LatLng(9.882464,78.082422));
        EEFRESHERBLOCK.add(new LatLng(9.882341,78.082422));
        EEFRESHERBLOCK.add(new LatLng(9.882341,78.082342));
        EEFRESHERBLOCK.add(new LatLng(9.882238,78.082342));
        EEFRESHERBLOCK.add(new LatLng(9.882066,78.082397));
        EEFRESHERBLOCK.add(new LatLng(9.881912,78.082477));
        EEFRESHERBLOCK.add(new LatLng(9.881912,78.082817));
        EEFRESHERBLOCK.add(new LatLng(9.88172,78.082617));

        EENCCBLOCK.add(new LatLng(9.882436,78.082038));
        EENCCBLOCK.add(new LatLng(9.882466,78.082038));
        EENCCBLOCK.add(new LatLng(9.882466,78.081854));
        EENCCBLOCK.add(new LatLng(9.882816,78.081854));
        EENCCBLOCK.add(new LatLng(9.883225,78.081854));
        EENCCBLOCK.add(new LatLng(9.883262,78.080870));
        EENCCBLOCK.add(new LatLng(9.883286,78.080765));
        EENCCBLOCK.add(new LatLng(9.883458,78.080706));
        EENCCBLOCK.add(new LatLng(9.883560,78.079803));

        EEINDOOR.add(new LatLng(9.882436,78.082038));
        EEINDOOR.add(new LatLng(9.882464,78.082037));
        EEINDOOR.add(new LatLng(9.882464,78.082333));
        EEINDOOR.add(new LatLng(9.882464,78.082422));
        EEINDOOR.add(new LatLng(9.882341,78.082422));
        EEINDOOR.add(new LatLng(9.882341,78.082764));
        EEINDOOR.add(new LatLng(9.882341,78.083190));
        EEINDOOR.add(new LatLng(9.882341,78.083402));
        EEINDOOR.add(new LatLng(9.881682,78.083426));
        EEINDOOR.add(new LatLng(9.881452,78.083488));
        EEINDOOR.add(new LatLng(9.881540,78.082662));
        EEINDOOR.add(new LatLng(9.880959,78.082606));
        EEINDOOR.add(new LatLng(9.880761,78.082324));
        EEINDOOR.add(new LatLng(9.880621,78.082225));
        EEINDOOR.add(new LatLng(9.879701,78.081978));
        EEINDOOR.add(new LatLng(9.879215,78.081785));
        EEINDOOR.add(new LatLng(9.878496,78.081654));
        EEINDOOR.add(new LatLng(9.877774,78.081405));
        EEINDOOR.add(new LatLng(9.877578,78.081330));
        EEINDOOR.add(new LatLng(9.877596,78.080995));
        EEINDOOR.add(new LatLng(9.882838,78.082683));

        EEOUTDOOR.add(new LatLng(9.882436,78.082038));
        EEOUTDOOR.add(new LatLng(9.882466,78.082038));
        EEOUTDOOR.add(new LatLng(9.882466,78.081854));
        EEOUTDOOR.add(new LatLng(9.882816,78.081854));
        EEOUTDOOR.add(new LatLng(9.883225,78.081854));
        EEOUTDOOR.add(new LatLng(9.883842,78.081407));

        EEKSAUDITORIUM.add(new LatLng(9.882436,78.082038));
        EEKSAUDITORIUM.add(new LatLng(9.882463,78.082176));
        EEKSAUDITORIUM.add(new LatLng(9.882463,78.082342));
        EEKSAUDITORIUM.add(new LatLng(9.882463,78.082426));
        EEKSAUDITORIUM.add(new LatLng(9.882625,78.082435));
        EEKSAUDITORIUM.add(new LatLng(9.882727,78.082435));
        EEKSAUDITORIUM.add(new LatLng(9.882783,78.081976));
        EEKSAUDITORIUM.add(new LatLng(9.882820,78.082337));

        EEKMAUDITORIUM.add(new LatLng(9.882436,78.082038));
        EEKMAUDITORIUM.add(new LatLng(9.882463,78.082176));
        EEKMAUDITORIUM.add(new LatLng(9.882463,78.082342));
        EEKMAUDITORIUM.add(new LatLng(9.882463,78.082426));
        EEKMAUDITORIUM.add(new LatLng(9.882625,78.082435));
        EEKMAUDITORIUM.add(new LatLng(9.882727,78.082435));
        EEKMAUDITORIUM.add(new LatLng(9.882727,78.082540));
        EEKMAUDITORIUM.add(new LatLng(9.882480,78.082541));

        EEPLACEMENTCELL.add(new LatLng(9.882436,78.082038));
        EEPLACEMENTCELL.add(new LatLng(9.882466,78.082038));
        EEPLACEMENTCELL.add(new LatLng(9.882466,78.081854));
        EEPLACEMENTCELL.add(new LatLng(9.882816,78.081854));
        EEPLACEMENTCELL.add(new LatLng(9.883225,78.081854));
        EEPLACEMENTCELL.add(new LatLng(9.883262,78.080870));
        EEPLACEMENTCELL.add(new LatLng(9.883286,78.080765));
        EEPLACEMENTCELL.add(new LatLng(9.883368,78.080711));
        EEPLACEMENTCELL.add(new LatLng(9.883896,78.080727));
        EEPLACEMENTCELL.add(new LatLng(9.884735,78.080781));
        EEPLACEMENTCELL.add(new LatLng(9.885035,78.080792));
        EEPLACEMENTCELL.add(new LatLng(9.885026,78.080954));

        EEGUESTHOUSE.add(new LatLng(9.882436,78.082038));
        EEGUESTHOUSE.add(new LatLng(9.882466,78.082038));
        EEGUESTHOUSE.add(new LatLng(9.882466,78.081854));
        EEGUESTHOUSE.add(new LatLng(9.882816,78.081854));
        EEGUESTHOUSE.add(new LatLng(9.883225,78.081854));
        EEGUESTHOUSE.add(new LatLng(9.883262,78.080870));
        EEGUESTHOUSE.add(new LatLng(9.883286,78.080765));
        EEGUESTHOUSE.add(new LatLng(9.883368,78.080711));
        EEGUESTHOUSE.add(new LatLng(9.883896,78.080727));
        EEGUESTHOUSE.add(new LatLng(9.884735,78.080781));
        EEGUESTHOUSE.add(new LatLng(9.885035,78.080792));
        EEGUESTHOUSE.add(new LatLng(9.885210,78.080791));
        EEGUESTHOUSE.add(new LatLng(9.885211,78.080632));

        EEMAINCANTEEN.add(new LatLng(9.882436,78.082038));
        EEMAINCANTEEN.add(new LatLng(9.882466,78.082038));
        EEMAINCANTEEN.add(new LatLng(9.882466,78.081854));
        EEMAINCANTEEN.add(new LatLng(9.882816,78.081854));
        EEMAINCANTEEN.add(new LatLng(9.883225,78.081854));
        EEMAINCANTEEN.add(new LatLng(9.883262,78.080870));
        EEMAINCANTEEN.add(new LatLng(9.883286,78.080765));
        EEMAINCANTEEN.add(new LatLng(9.883277,78.080255));
        EEMAINCANTEEN.add(new LatLng(9.883264,78.079857));

        EEFOODCOURT.add(new LatLng(9.882436,78.082038));
        EEFOODCOURT.add(new LatLng(9.882466,78.082038));
        EEFOODCOURT.add(new LatLng(9.882466,78.081854));
        EEFOODCOURT.add(new LatLng(9.882816,78.081854));
        EEFOODCOURT.add(new LatLng(9.883225,78.081854));
        EEFOODCOURT.add(new LatLng(9.883225,78.082669));
        EEFOODCOURT.add(new LatLng(9.883225,78.083187));
        EEFOODCOURT.add(new LatLng(9.883282,78.083236));

        EEMENSHOSTEL.add(new LatLng(9.882436,78.082038));
        EEMENSHOSTEL.add(new LatLng(9.882466,78.082038));
        EEMENSHOSTEL.add(new LatLng(9.882466,78.081854));
        EEMENSHOSTEL.add(new LatLng(9.882816,78.081854));
        EEMENSHOSTEL.add(new LatLng(9.883225,78.081854));
        EEMENSHOSTEL.add(new LatLng(9.883262,78.080870));
        EEMENSHOSTEL.add(new LatLng(9.883286,78.080765));
        EEMENSHOSTEL.add(new LatLng(9.883368,78.080711));
        EEMENSHOSTEL.add(new LatLng(9.883896,78.080727));
        EEMENSHOSTEL.add(new LatLng(9.884735,78.080781));
        EEMENSHOSTEL.add(new LatLng(9.884765,78.080405));
        EEMENSHOSTEL.add(new LatLng(9.884738,78.080071));

        EEWOMENSHOSTEL.add(new LatLng(9.882436,78.082038));
        EEWOMENSHOSTEL.add(new LatLng(9.882464,78.082037));
        EEWOMENSHOSTEL.add(new LatLng(9.882464,78.082333));
        EEWOMENSHOSTEL.add(new LatLng(9.882464,78.082422));
        EEWOMENSHOSTEL.add(new LatLng(9.882341,78.082422));
        EEWOMENSHOSTEL.add(new LatLng(9.882341,78.082764));
        EEWOMENSHOSTEL.add(new LatLng(9.882341,78.083190));
        EEWOMENSHOSTEL.add(new LatLng(9.882341,78.083402));
        EEWOMENSHOSTEL.add(new LatLng(9.881682,78.083426));
        EEWOMENSHOSTEL.add(new LatLng(9.881301,78.083517));
        EEWOMENSHOSTEL.add(new LatLng(9.880672,78.083442));
        EEWOMENSHOSTEL.add(new LatLng(9.880375,78.083386));
        EEWOMENSHOSTEL.add(new LatLng(9.879979,78.083493));
        EEWOMENSHOSTEL.add(new LatLng(9.879832,78.083329));
        EEWOMENSHOSTEL.add(new LatLng(9.879632,78.083372));
        EEWOMENSHOSTEL.add(new LatLng(9.879518,78.082975));
        EEWOMENSHOSTEL.add(new LatLng(9.879373,78.082685));
        EEWOMENSHOSTEL.add(new LatLng(9.879288,78.082626));
        EEWOMENSHOSTEL.add(new LatLng(9.878910,78.082653));
        EEWOMENSHOSTEL.add(new LatLng(9.878479,78.082776));
        EEWOMENSHOSTEL.add(new LatLng(9.878434,78.082095));
        EEWOMENSHOSTEL.add(new LatLng(9.878201,78.082072));

        EELIBRARY.add(new LatLng(9.882436,78.082038));
        EELIBRARY.add(new LatLng(9.882466,78.082038));
        EELIBRARY.add(new LatLng(9.882466,78.081854));
        EELIBRARY.add(new LatLng(9.882816,78.081854));
        EELIBRARY.add(new LatLng(9.883225,78.081854));
        EELIBRARY.add(new LatLng(9.883236,78.081264));
        EELIBRARY.add(new LatLng(9.882854,78.081243));

        EEBANK.add(new LatLng(9.882436,78.082038));
        EEBANK.add(new LatLng(9.882466,78.082038));
        EEBANK.add(new LatLng(9.882466,78.081854));
        EEBANK.add(new LatLng(9.882816,78.081854));
        EEBANK.add(new LatLng(9.883225,78.081854));
        EEBANK.add(new LatLng(9.883262,78.080870));
        EEBANK.add(new LatLng(9.883286,78.080765));
        EEBANK.add(new LatLng(9.883458,78.080706));
        EEBANK.add(new LatLng(9.883496,78.079848));

        EETEMPLE.add(new LatLng(9.882436,78.082038));
        EETEMPLE.add(new LatLng(9.882466,78.082038));
        EETEMPLE.add(new LatLng(9.882466,78.081854));
        EETEMPLE.add(new LatLng(9.882816,78.081854));
        EETEMPLE.add(new LatLng(9.883225,78.081854));
        EETEMPLE.add(new LatLng(9.883262,78.080870));
        EETEMPLE.add(new LatLng(9.883286,78.080765));
        EETEMPLE.add(new LatLng(9.883368,78.080711));
        EETEMPLE.add(new LatLng(9.883896,78.080727));
        EETEMPLE.add(new LatLng(9.884735,78.080781));
        EETEMPLE.add(new LatLng(9.885035,78.080792));
        EETEMPLE.add(new LatLng(9.885443,78.080804));
        EETEMPLE.add(new LatLng(9.885459,78.080574));

        EEPARKING.add(new LatLng(9.882436,78.082038));
        EEPARKING.add(new LatLng(9.882466,78.082038));
        EEPARKING.add(new LatLng(9.882466,78.081854));
        EEPARKING.add(new LatLng(9.882816,78.081854));
        EEPARKING.add(new LatLng(9.883225,78.081854));
        EEPARKING.add(new LatLng(9.883252,78.081003));
        EEPARKING.add(new LatLng(9.883106,78.080998));
        EEPARKING.add(new LatLng(9.882769,78.080846));

    }
    public void initCivilCoordinates()
    {
        //CIVIL
        CIMAINBUILDING.add(new LatLng(9.882278,78.082855));
        CIMAINBUILDING.add(new LatLng(9.882345,78.082764));
        CIMAINBUILDING.add(new LatLng(9.882345,78.082638));
        CIMAINBUILDING.add(new LatLng(9.882560,78.082638));
        CIMAINBUILDING.add(new LatLng(9.882720,78.082638));
        CIMAINBUILDING.add(new LatLng(9.882727,78.082532));
        CIMAINBUILDING.add(new LatLng(9.882881,78.082511));


        CIIT.add(new LatLng(9.882278,78.082855));
        CIIT.add(new LatLng(9.882324,78.082764));
        CIIT.add(new LatLng(9.882324,78.083199));
        CIIT.add(new LatLng(9.882326,78.083423));
        CIIT.add(new LatLng(9.882397,78.083426));
        CIIT.add(new LatLng(9.882397,78.083506));
        CIIT.add(new LatLng(9.882397,78.083569));
        CIIT.add(new LatLng(9.882399,78.083630));


        CICSE.add(new LatLng(9.882278,78.082855));
        CICSE.add(new LatLng(9.882329,78.082917));
        CICSE.add(new LatLng(9.882323,78.083187));
        CICSE.add(new LatLng(9.882332,78.083411));
        CICSE.add(new LatLng(9.882688,78.083418));
        CICSE.add(new LatLng(9.882893,78.083421));
        CICSE.add(new LatLng(9.882884,78.083593));
        CICSE.add(new LatLng(9.882896,78.083745));
        CICSE.add(new LatLng(9.882797,78.083739));


        CIECE.add(new LatLng(9.882278,78.082855));
        CIECE.add(new LatLng(9.882345,78.082764));
        CIECE.add(new LatLng(9.882345,78.082638));
        CIECE.add(new LatLng(9.882560,78.082638));
        CIECE.add(new LatLng(9.882720,78.082638));
        CIECE.add(new LatLng(9.882727,78.082532));
        CIECE.add(new LatLng(9.882759,78.082532));
        CIECE.add(new LatLng(9.882759,78.082433));
        CIECE.add(new LatLng(9.882829,78.082341));
        CIECE.add(new LatLng(9.882820,78.082338));


        CIEEE.add(new LatLng(9.882278,78.082855));
        CIEEE.add(new LatLng(9.882341,78.082764));
        CIEEE.add(new LatLng(9.882341,78.082422));
        CIEEE.add(new LatLng(9.882464,78.082422));
        CIEEE.add(new LatLng(9.882464,78.082333));
        CIEEE.add(new LatLng(9.882464,78.082037));
        CIEEE.add(new LatLng(9.882433,78.082086));


        CIMECH.add(new LatLng(9.882278,78.082855));
        CIMECH.add(new LatLng(9.882324,78.082764));
        CIMECH.add(new LatLng(9.882324,78.082409));
        CIMECH.add(new LatLng(9.882324,78.081958));
        CIMECH.add(new LatLng(9.882324,78.081691));
        CIMECH.add(new LatLng(9.882437,78.081691));
        CIMECH.add(new LatLng(9.882467,78.081483));
        CIMECH.add(new LatLng(9.882488,78.081320));
        CIMECH.add(new LatLng(9.882704,78.081311));
        CIMECH.add(new LatLng(9.882365,78.081429));


        CIMECHT.add(new LatLng(9.882278,78.082855));
        CIMECHT.add(new LatLng(9.882324,78.082764));
        CIMECHT.add(new LatLng(9.882324,78.082409));
        CIMECHT.add(new LatLng(9.882324,78.081958));
        CIMECHT.add(new LatLng(9.882324,78.081691));
        CIMECHT.add(new LatLng(9.882437,78.081691));
        CIMECHT.add(new LatLng(9.882467,78.081483));
        CIMECHT.add(new LatLng(9.882488,78.081320));
        CIMECHT.add(new LatLng(9.882704,78.081311));
        CIMECHT.add(new LatLng(9.882365,78.081428));


        CIARCH.add(new LatLng(9.882278,78.082855));
        CIARCH.add(new LatLng(9.882324,78.082764));
        CIARCH.add(new LatLng(9.882324,78.083199));
        CIARCH.add(new LatLng(9.882326,78.083423));
        CIARCH.add(new LatLng(9.881682,78.083426));
        CIARCH.add(new LatLng(9.881301,78.083517));
        CIARCH.add(new LatLng(9.880672,78.083442));
        CIARCH.add(new LatLng(9.880558,78.083080));
        CIARCH.add(new LatLng(9.880201,78.083158));
        CIARCH.add(new LatLng(9.878790,78.082110));


        CISCIENCEBLOCK.add(new LatLng(9.882278,78.082855));
        CISCIENCEBLOCK.add(new LatLng(9.882324,78.082764));
        CISCIENCEBLOCK.add(new LatLng(9.882324,78.083199));
        CISCIENCEBLOCK.add(new LatLng(9.882324,78.083278));
        CISCIENCEBLOCK.add(new LatLng(9.882173,78.083278));
        CISCIENCEBLOCK.add(new LatLng(9.882173,78.083195));
        CISCIENCEBLOCK.add(new LatLng(9.882160,78.083029));
        CISCIENCEBLOCK.add(new LatLng(9.881816,78.083021));
        CISCIENCEBLOCK.add(new LatLng(9.881876,78.083152));


        CIFRESHERBLOCK.add(new LatLng(9.882278,78.082855));
        CIFRESHERBLOCK.add(new LatLng(9.882324,78.082764));
        CIFRESHERBLOCK.add(new LatLng(9.882324,78.083199));
        CIFRESHERBLOCK.add(new LatLng(9.882324,78.083278));
        CIFRESHERBLOCK.add(new LatLng(9.882173,78.083278));
        CIFRESHERBLOCK.add(new LatLng(9.882173,78.083195));
        CIFRESHERBLOCK.add(new LatLng(9.882160,78.083029));
        CIFRESHERBLOCK.add(new LatLng(9.881950,78.083021));
        CIFRESHERBLOCK.add(new LatLng(9.881946,78.082825));
        CIFRESHERBLOCK.add(new LatLng(9.88172,78.082617));


        CINCCBLOCK.add(new LatLng(9.882278,78.082855));
        CINCCBLOCK.add(new LatLng(9.882341,78.082764));
        CINCCBLOCK.add(new LatLng(9.882341,78.082422));
        CINCCBLOCK.add(new LatLng(9.882464,78.082422));
        CINCCBLOCK.add(new LatLng(9.882464,78.082333));
        CINCCBLOCK.add(new LatLng(9.882464,78.082037));
        CINCCBLOCK.add(new LatLng(9.882466,78.081854));
        CINCCBLOCK.add(new LatLng(9.882816,78.081854));
        CINCCBLOCK.add(new LatLng(9.883225,78.081854));
        CINCCBLOCK.add(new LatLng(9.883262,78.080870));
        CINCCBLOCK.add(new LatLng(9.883286,78.080765));
        CINCCBLOCK.add(new LatLng(9.883458,78.080706));
        CINCCBLOCK.add(new LatLng(9.883560,78.079803));


        CIINDOOR.add(new LatLng(9.882278,78.082855));
        CIINDOOR.add(new LatLng(9.882324,78.082764));
        CIINDOOR.add(new LatLng(9.882324,78.083199));
        CIINDOOR.add(new LatLng(9.882326,78.083423));
        CIINDOOR.add(new LatLng(9.881682,78.083426));
        CIINDOOR.add(new LatLng(9.881452,78.083488));
        CIINDOOR.add(new LatLng(9.881540,78.082662));
        CIINDOOR.add(new LatLng(9.880959,78.082606));
        CIINDOOR.add(new LatLng(9.880761,78.082324));
        CIINDOOR.add(new LatLng(9.880621,78.082225));
        CIINDOOR.add(new LatLng(9.879701,78.081978));
        CIINDOOR.add(new LatLng(9.879215,78.081785));
        CIINDOOR.add(new LatLng(9.878496,78.081654));
        CIINDOOR.add(new LatLng(9.877774,78.081405));
        CIINDOOR.add(new LatLng(9.877578,78.081330));
        CIINDOOR.add(new LatLng(9.877596,78.080995));
        CIINDOOR.add(new LatLng(9.882838,78.082683));


        CIOUTDOOR.add(new LatLng(9.882278,78.082855));
        CIOUTDOOR.add(new LatLng(9.882341,78.082764));
        CIOUTDOOR.add(new LatLng(9.882341,78.082422));
        CIOUTDOOR.add(new LatLng(9.882464,78.082422));
        CIOUTDOOR.add(new LatLng(9.882464,78.082333));
        CIOUTDOOR.add(new LatLng(9.882464,78.082037));
        CIOUTDOOR.add(new LatLng(9.882466,78.081854));
        CIOUTDOOR.add(new LatLng(9.882816,78.081854));
        CIOUTDOOR.add(new LatLng(9.883225,78.081854));
        CIOUTDOOR.add(new LatLng(9.883842,78.081407));


        CIKSAUDITORIUM.add(new LatLng(9.882278,78.082855));
        CIKSAUDITORIUM.add(new LatLng(9.882345,78.082764));
        CIKSAUDITORIUM.add(new LatLng(9.882345,78.082638));
        CIKSAUDITORIUM.add(new LatLng(9.882560,78.082638));
        CIKSAUDITORIUM.add(new LatLng(9.882720,78.082638));
        CIKSAUDITORIUM.add(new LatLng(9.882727,78.082532));
        CIKSAUDITORIUM.add(new LatLng(9.882759,78.082532));
        CIKSAUDITORIUM.add(new LatLng(9.882759,78.082433));
        CIKSAUDITORIUM.add(new LatLng(9.882759,78.081976));
        CIKSAUDITORIUM.add(new LatLng(9.882820,78.082337));


        CIKMAUDITORIUM.add(new LatLng(9.882278,78.082855));
        CIKMAUDITORIUM.add(new LatLng(9.882345,78.082764));
        CIKMAUDITORIUM.add(new LatLng(9.882345,78.082633));
        CIKMAUDITORIUM.add(new LatLng(9.882538,78.082633));
        CIKMAUDITORIUM.add(new LatLng(9.882715,78.082633));
        CIKMAUDITORIUM.add(new LatLng(9.882715,78.082540));
        CIKMAUDITORIUM.add(new LatLng(9.882480,78.082541));


        CIPLACEMENTCELL.add(new LatLng(9.882278,78.082855));
        CIPLACEMENTCELL.add(new LatLng(9.882341,78.082764));
        CIPLACEMENTCELL.add(new LatLng(9.882341,78.082422));
        CIPLACEMENTCELL.add(new LatLng(9.882464,78.082422));
        CIPLACEMENTCELL.add(new LatLng(9.882464,78.082333));
        CIPLACEMENTCELL.add(new LatLng(9.882464,78.082037));
        CIPLACEMENTCELL.add(new LatLng(9.882466,78.081854));
        CIPLACEMENTCELL.add(new LatLng(9.882816,78.081854));
        CIPLACEMENTCELL.add(new LatLng(9.883225,78.081854));
        CIPLACEMENTCELL.add(new LatLng(9.883262,78.080870));
        CIPLACEMENTCELL.add(new LatLng(9.883286,78.080765));
        CIPLACEMENTCELL.add(new LatLng(9.883368,78.080711));
        CIPLACEMENTCELL.add(new LatLng(9.883896,78.080727));
        CIPLACEMENTCELL.add(new LatLng(9.884735,78.080781));
        CIPLACEMENTCELL.add(new LatLng(9.885035,78.080792));
        CIPLACEMENTCELL.add(new LatLng(9.885026,78.080954));


        CIGUESTHOUSE.add(new LatLng(9.882278,78.082855));
        CIGUESTHOUSE.add(new LatLng(9.882341,78.082764));
        CIGUESTHOUSE.add(new LatLng(9.882341,78.082422));
        CIGUESTHOUSE.add(new LatLng(9.882464,78.082422));
        CIGUESTHOUSE.add(new LatLng(9.882464,78.082333));
        CIGUESTHOUSE.add(new LatLng(9.882464,78.082037));
        CIGUESTHOUSE.add(new LatLng(9.882466,78.081854));
        CIGUESTHOUSE.add(new LatLng(9.882816,78.081854));
        CIGUESTHOUSE.add(new LatLng(9.883225,78.081854));
        CIGUESTHOUSE.add(new LatLng(9.883262,78.080870));
        CIGUESTHOUSE.add(new LatLng(9.883286,78.080765));
        CIGUESTHOUSE.add(new LatLng(9.883368,78.080711));
        CIGUESTHOUSE.add(new LatLng(9.883896,78.080727));
        CIGUESTHOUSE.add(new LatLng(9.884735,78.080781));
        CIGUESTHOUSE.add(new LatLng(9.885035,78.080792));
        CIGUESTHOUSE.add(new LatLng(9.885210,78.080791));
        CIGUESTHOUSE.add(new LatLng(9.885211,78.080632));


        CIMAINCANTEEN.add(new LatLng(9.882278,78.082855));
        CIMAINCANTEEN.add(new LatLng(9.882341,78.082764));
        CIMAINCANTEEN.add(new LatLng(9.882341,78.082422));
        CIMAINCANTEEN.add(new LatLng(9.882464,78.082422));
        CIMAINCANTEEN.add(new LatLng(9.882464,78.082333));
        CIMAINCANTEEN.add(new LatLng(9.882464,78.082037));
        CIMAINCANTEEN.add(new LatLng(9.882466,78.081854));
        CIMAINCANTEEN.add(new LatLng(9.882816,78.081854));
        CIMAINCANTEEN.add(new LatLng(9.883225,78.081854));
        CIMAINCANTEEN.add(new LatLng(9.883262,78.080870));
        CIMAINCANTEEN.add(new LatLng(9.883286,78.080765));
        CIMAINCANTEEN.add(new LatLng(9.883277,78.080255));
        CIMAINCANTEEN.add(new LatLng(9.883264,78.079857));


        CIFOODCOURT.add(new LatLng(9.882278,78.082855));
        CIFOODCOURT.add(new LatLng(9.882345,78.082764));
        CIFOODCOURT.add(new LatLng(9.882345,78.083193));
        CIFOODCOURT.add(new LatLng(9.883282,78.083236));


        CIMENSHOSTEL.add(new LatLng(9.882278,78.082855));
        CIMENSHOSTEL.add(new LatLng(9.882341,78.082764));
        CIMENSHOSTEL.add(new LatLng(9.882341,78.082422));
        CIMENSHOSTEL.add(new LatLng(9.882464,78.082422));
        CIMENSHOSTEL.add(new LatLng(9.882464,78.082333));
        CIMENSHOSTEL.add(new LatLng(9.882464,78.082037));
        CIMENSHOSTEL.add(new LatLng(9.882466,78.081854));
        CIMENSHOSTEL.add(new LatLng(9.882816,78.081854));
        CIMENSHOSTEL.add(new LatLng(9.883225,78.081854));
        CIMENSHOSTEL.add(new LatLng(9.883262,78.080870));
        CIMENSHOSTEL.add(new LatLng(9.883286,78.080765));
        CIMENSHOSTEL.add(new LatLng(9.883368,78.080711));
        CIMENSHOSTEL.add(new LatLng(9.883896,78.080727));
        CIMENSHOSTEL.add(new LatLng(9.884735,78.080781));
        CIMENSHOSTEL.add(new LatLng(9.884765,78.080405));
        CIMENSHOSTEL.add(new LatLng(9.884738,78.080071));


        CIWOMENSHOSTEL.add(new LatLng(9.882278,78.082855));
        CIWOMENSHOSTEL.add(new LatLng(9.882324,78.082764));
        CIWOMENSHOSTEL.add(new LatLng(9.882324,78.083199));
        CIWOMENSHOSTEL.add(new LatLng(9.882326,78.083423));
        CIWOMENSHOSTEL.add(new LatLng(9.881682,78.083426));
        CIWOMENSHOSTEL.add(new LatLng(9.881301,78.083517));
        CIWOMENSHOSTEL.add(new LatLng(9.880672,78.083442));
        CIWOMENSHOSTEL.add(new LatLng(9.880375,78.083386));
        CIWOMENSHOSTEL.add(new LatLng(9.879979,78.083493));
        CIWOMENSHOSTEL.add(new LatLng(9.879832,78.083329));
        CIWOMENSHOSTEL.add(new LatLng(9.879632,78.083372));
        CIWOMENSHOSTEL.add(new LatLng(9.879518,78.082975));
        CIWOMENSHOSTEL.add(new LatLng(9.879373,78.082685));
        CIWOMENSHOSTEL.add(new LatLng(9.879288,78.082626));
        CIWOMENSHOSTEL.add(new LatLng(9.878910,78.082653));
        CIWOMENSHOSTEL.add(new LatLng(9.878479,78.082776));
        CIWOMENSHOSTEL.add(new LatLng(9.878434,78.082095));
        CIWOMENSHOSTEL.add(new LatLng(9.878201,78.082072));


        CILIBRARY.add(new LatLng(9.882278,78.082855));
        CILIBRARY.add(new LatLng(9.882341,78.082764));
        CILIBRARY.add(new LatLng(9.882341,78.082422));
        CILIBRARY.add(new LatLng(9.882464,78.082422));
        CILIBRARY.add(new LatLng(9.882464,78.082333));
        CILIBRARY.add(new LatLng(9.882464,78.082037));
        CILIBRARY.add(new LatLng(9.882466,78.081854));
        CILIBRARY.add(new LatLng(9.882816,78.081854));
        CILIBRARY.add(new LatLng(9.883225,78.081854));
        CILIBRARY.add(new LatLng(9.883236,78.081264));
        CILIBRARY.add(new LatLng(9.882854,78.081243));


        CIBANK.add(new LatLng(9.882278,78.082855));
        CIBANK.add(new LatLng(9.882341,78.082764));
        CIBANK.add(new LatLng(9.882341,78.082422));
        CIBANK.add(new LatLng(9.882464,78.082422));
        CIBANK.add(new LatLng(9.882464,78.082333));
        CIBANK.add(new LatLng(9.882464,78.082037));
        CIBANK.add(new LatLng(9.882466,78.081854));
        CIBANK.add(new LatLng(9.882816,78.081854));
        CIBANK.add(new LatLng(9.883225,78.081854));
        CIBANK.add(new LatLng(9.883262,78.080870));
        CIBANK.add(new LatLng(9.883286,78.080765));
        CIBANK.add(new LatLng(9.883458,78.080706));
        CIBANK.add(new LatLng(9.883496,78.079848));


        CITEMPLE.add(new LatLng(9.882278,78.082855));
        CITEMPLE.add(new LatLng(9.882341,78.082764));
        CITEMPLE.add(new LatLng(9.882341,78.082422));
        CITEMPLE.add(new LatLng(9.882464,78.082422));
        CITEMPLE.add(new LatLng(9.882464,78.082333));
        CITEMPLE.add(new LatLng(9.882464,78.082037));
        CITEMPLE.add(new LatLng(9.882466,78.081854));
        CITEMPLE.add(new LatLng(9.882816,78.081854));
        CITEMPLE.add(new LatLng(9.883225,78.081854));
        CITEMPLE.add(new LatLng(9.883262,78.080870));
        CITEMPLE.add(new LatLng(9.883286,78.080765));
        CITEMPLE.add(new LatLng(9.883368,78.080711));
        CITEMPLE.add(new LatLng(9.883896,78.080727));
        CITEMPLE.add(new LatLng(9.884735,78.080781));
        CITEMPLE.add(new LatLng(9.885035,78.080792));
        CITEMPLE.add(new LatLng(9.885443,78.080804));
        CITEMPLE.add(new LatLng(9.885459,78.080574));


        CIPARKING.add(new LatLng(9.882278,78.082855));
        CIPARKING.add(new LatLng(9.882341,78.082764));
        CIPARKING.add(new LatLng(9.882341,78.082422));
        CIPARKING.add(new LatLng(9.882464,78.082422));
        CIPARKING.add(new LatLng(9.882464,78.082333));
        CIPARKING.add(new LatLng(9.882464,78.082037));
        CIPARKING.add(new LatLng(9.882466,78.081854));
        CIPARKING.add(new LatLng(9.882816,78.081854));
        CIPARKING.add(new LatLng(9.883225,78.081854));
        CIPARKING.add(new LatLng(9.883252,78.081003));
        CIPARKING.add(new LatLng(9.883106,78.080998));
        CIPARKING.add(new LatLng(9.882769,78.080846));

    }
    public void initMechanicalCoordinates()
    {
        //MECH
        MEMAINBUILDING.add(new LatLng(9.882365,78.081429));
        MEMAINBUILDING.add(new LatLng(9.882707,78.081253));
        MEMAINBUILDING.add(new LatLng(9.882722,78.081917));
        MEMAINBUILDING.add(new LatLng(9.882722,78.082452));
        MEMAINBUILDING.add(new LatLng(9.882722,78.082530));
        MEMAINBUILDING.add(new LatLng(9.882881,78.082511));

        MEIT.add(new LatLng(9.882365,78.081429));
        MEIT.add(new LatLng(9.882704,78.081311));
        MEIT.add(new LatLng(9.882488,78.081320));
        MEIT.add(new LatLng(9.882467,78.081483));
        MEIT.add(new LatLng(9.882437,78.081691));
        MEIT.add(new LatLng(9.882324,78.081691));
        MEIT.add(new LatLng(9.882324,78.081958));
        MEIT.add(new LatLng(9.882324,78.082409));
        MEIT.add(new LatLng(9.882324,78.082820));
        MEIT.add(new LatLng(9.882324,78.083199));
        MEIT.add(new LatLng(9.882326,78.083423));
        MEIT.add(new LatLng(9.882397,78.083426));
        MEIT.add(new LatLng(9.882397,78.083506));
        MEIT.add(new LatLng(9.882397,78.083569));
        MEIT.add(new LatLng(9.882399,78.083630));

        MECSE.add(new LatLng(9.882365,78.081429));
        MECSE.add(new LatLng(9.882602,78.081292));
        MECSE.add(new LatLng(9.882471,78.081301));
        MECSE.add(new LatLng(9.882431,78.081627));
        MECSE.add(new LatLng(9.882376,78.081669));
        MECSE.add(new LatLng(9.882347,78.081990));
        MECSE.add(new LatLng(9.882332,78.082360));
        MECSE.add(new LatLng(9.882329,78.082917));
        MECSE.add(new LatLng(9.882323,78.083187));
        MECSE.add(new LatLng(9.882332,78.083411));
        MECSE.add(new LatLng(9.882688,78.083418));
        MECSE.add(new LatLng(9.882893,78.083421));
        MECSE.add(new LatLng(9.882884,78.083593));
        MECSE.add(new LatLng(9.882896,78.083745));
        MECSE.add(new LatLng(9.882797,78.083739));

        MEECE.add(new LatLng(9.882365,78.081429));
        MEECE.add(new LatLng(9.882727,78.081303));
        MEECE.add(new LatLng(9.882727,78.081601));
        MEECE.add(new LatLng(9.882727,78.081947));
        MEECE.add(new LatLng(9.882727,78.082312));
        MEECE.add(new LatLng(9.882727,78.082532));
        MEECE.add(new LatLng(9.882759,78.082532));
        MEECE.add(new LatLng(9.882759,78.082433));
        MEECE.add(new LatLng(9.882829,78.082341));
        MEECE.add(new LatLng(9.882829,78.082341));
        MEECE.add(new LatLng(9.882820,78.082338));

        MEEEE.add(new LatLng(9.882365,78.081429));
        MEEEE.add(new LatLng(9.882707,78.081317));
        MEEEE.add(new LatLng(9.882477,78.081317));
        MEEEE.add(new LatLng(9.882432,78.081634));
        MEEEE.add(new LatLng(9.882432,78.081753));
        MEEEE.add(new LatLng(9.882468,78.081753));
        MEEEE.add(new LatLng(9.882468,78.082038));
        MEEEE.add(new LatLng(9.882433,78.082086));

        MECIVIL.add(new LatLng(9.882365,78.081429));
        MECIVIL.add(new LatLng(9.882704,78.081311));
        MECIVIL.add(new LatLng(9.882488,78.081320));
        MECIVIL.add(new LatLng(9.882467,78.081483));
        MECIVIL.add(new LatLng(9.882437,78.081691));
        MECIVIL.add(new LatLng(9.882324,78.081691));
        MECIVIL.add(new LatLng(9.882324,78.081958));
        MECIVIL.add(new LatLng(9.882324,78.082409));
        MECIVIL.add(new LatLng(9.882324,78.082764));
        MECIVIL.add(new LatLng(9.882278,78.082855));

        MEMECHT.add(new LatLng(9.882365,78.081429));
        MEMECHT.add(new LatLng(9.882365,78.081428));

        MEARCH.add(new LatLng(9.882365,78.081429));
        MEARCH.add(new LatLng(9.882707,78.081388));
        MEARCH.add(new LatLng(9.882452,78.081388));
        MEARCH.add(new LatLng(9.882399,78.081653));
        MEARCH.add(new LatLng(9.882321,78.081682));
        MEARCH.add(new LatLng(9.882207,78.082300));
        MEARCH.add(new LatLng(9.881980,78.082442));
        MEARCH.add(new LatLng(9.881980,78.083002));
        MEARCH.add(new LatLng(9.882124,78.083002));
        MEARCH.add(new LatLng(9.882124,78.083251));
        MEARCH.add(new LatLng(9.882124,78.083426));
        MEARCH.add(new LatLng(9.881682,78.083426));
        MEARCH.add(new LatLng(9.881301,78.083517));
        MEARCH.add(new LatLng(9.880672,78.083442));
        MEARCH.add(new LatLng(9.880558,78.083080));
        MEARCH.add(new LatLng(9.880201,78.083158));
        MEARCH.add(new LatLng(9.878790,78.082110));

        MESCIENCEBLOCK.add(new LatLng(9.882365,78.081429));
        MESCIENCEBLOCK.add(new LatLng(9.882365,78.081429));
        MESCIENCEBLOCK.add(new LatLng(9.882707,78.081388));
        MESCIENCEBLOCK.add(new LatLng(9.882452,78.081388));
        MESCIENCEBLOCK.add(new LatLng(9.882399,78.081653));
        MESCIENCEBLOCK.add(new LatLng(9.882321,78.081682));
        MESCIENCEBLOCK.add(new LatLng(9.882207,78.082300));
        MESCIENCEBLOCK.add(new LatLng(9.881980,78.082442));
        MESCIENCEBLOCK.add(new LatLng(9.881980,78.083002));
        MESCIENCEBLOCK.add(new LatLng(9.881980,78.083111));
        MESCIENCEBLOCK.add(new LatLng(9.881876,78.083152));

        MEFRESHERBLOCK.add(new LatLng(9.882365,78.081429));
        MEFRESHERBLOCK.add(new LatLng(9.882707,78.081388));
        MEFRESHERBLOCK.add(new LatLng(9.882452,78.081388));
        MEFRESHERBLOCK.add(new LatLng(9.882399,78.081653));
        MEFRESHERBLOCK.add(new LatLng(9.882321,78.081682));
        MEFRESHERBLOCK.add(new LatLng(9.882207,78.082300));
        MEFRESHERBLOCK.add(new LatLng(9.881980,78.082442));
        MEFRESHERBLOCK.add(new LatLng(9.881980,78.082817));
        MEFRESHERBLOCK.add(new LatLng(9.88172,78.082617));

        MENCCBLOCK.add(new LatLng(9.882365,78.081429));
        MENCCBLOCK.add(new LatLng(9.882707,78.081253));
        MENCCBLOCK.add(new LatLng(9.882949,78.081681));
        MENCCBLOCK.add(new LatLng(9.883234,78.081681));
        MENCCBLOCK.add(new LatLng(9.883262,78.080870));
        MENCCBLOCK.add(new LatLng(9.883286,78.080765));
        MENCCBLOCK.add(new LatLng(9.883458,78.080706));
        MENCCBLOCK.add(new LatLng(9.883560,78.079803));

        MEINDOOR.add(new LatLng(9.882365,78.081429));
        MEINDOOR.add(new LatLng(9.882707,78.081388));
        MEINDOOR.add(new LatLng(9.882452,78.081388));
        MEINDOOR.add(new LatLng(9.882399,78.081653));
        MEINDOOR.add(new LatLng(9.882321,78.081682));
        MEINDOOR.add(new LatLng(9.882207,78.082300));
        MEINDOOR.add(new LatLng(9.881980,78.082442));
        MEINDOOR.add(new LatLng(9.881980,78.083002));
        MEINDOOR.add(new LatLng(9.882124,78.083002));
        MEINDOOR.add(new LatLng(9.882124,78.083251));
        MEINDOOR.add(new LatLng(9.882124,78.083426));
        MEINDOOR.add(new LatLng(9.881682,78.083426));
        MEINDOOR.add(new LatLng(9.881452,78.083488));
        MEINDOOR.add(new LatLng(9.881540,78.082662));
        MEINDOOR.add(new LatLng(9.880959,78.082606));
        MEINDOOR.add(new LatLng(9.880761,78.082324));
        MEINDOOR.add(new LatLng(9.880621,78.082225));
        MEINDOOR.add(new LatLng(9.879701,78.081978));
        MEINDOOR.add(new LatLng(9.879215,78.081785));
        MEINDOOR.add(new LatLng(9.878496,78.081654));
        MEINDOOR.add(new LatLng(9.877774,78.081405));
        MEINDOOR.add(new LatLng(9.877578,78.081330));
        MEINDOOR.add(new LatLng(9.877596,78.080995));
        MEINDOOR.add(new LatLng(9.882838,78.082683));

        MEOUTDOOR.add(new LatLng(9.882365,78.081429));
        MEOUTDOOR.add(new LatLng(9.882707,78.081253));
        MEOUTDOOR.add(new LatLng(9.882949,78.081681));
        MEOUTDOOR.add(new LatLng(9.883234,78.081681));
        MEOUTDOOR.add(new LatLng(9.883842,78.081407));

        MEKSAUDITORIUM.add(new LatLng(9.882365,78.081429));
        MEKSAUDITORIUM.add(new LatLng(9.882707,78.081268));
        MEKSAUDITORIUM.add(new LatLng(9.882707,78.081976));
        MEKSAUDITORIUM.add(new LatLng(9.882820,78.082337));

        MEKMAUDITORIUM.add(new LatLng(9.882365,78.081429));
        MEKMAUDITORIUM.add(new LatLng(9.882707,78.081268));
        MEKMAUDITORIUM.add(new LatLng(9.882707,78.081976));
        MEKMAUDITORIUM.add(new LatLng(9.882707,78.082540));
        MEKMAUDITORIUM.add(new LatLng(9.882480,78.082541));

        MEPLACEMENTCELL.add(new LatLng(9.882365,78.081429));
        MEPLACEMENTCELL.add(new LatLng(9.882707,78.081253));
        MEPLACEMENTCELL.add(new LatLng(9.882949,78.081681));
        MEPLACEMENTCELL.add(new LatLng(9.883234,78.081681));
        MEPLACEMENTCELL.add(new LatLng(9.883262,78.080870));
        MEPLACEMENTCELL.add(new LatLng(9.883286,78.080765));
        MEPLACEMENTCELL.add(new LatLng(9.883368,78.080711));
        MEPLACEMENTCELL.add(new LatLng(9.883896,78.080727));
        MEPLACEMENTCELL.add(new LatLng(9.884735,78.080781));
        MEPLACEMENTCELL.add(new LatLng(9.885035,78.080792));
        MEPLACEMENTCELL.add(new LatLng(9.885026,78.080954));

        MEGUESTHOUSE.add(new LatLng(9.882365,78.081429));
        MEGUESTHOUSE.add(new LatLng(9.882707,78.081253));
        MEGUESTHOUSE.add(new LatLng(9.882949,78.081681));
        MEGUESTHOUSE.add(new LatLng(9.883234,78.081681));
        MEGUESTHOUSE.add(new LatLng(9.883262,78.080870));
        MEGUESTHOUSE.add(new LatLng(9.883286,78.080765));
        MEGUESTHOUSE.add(new LatLng(9.883368,78.080711));
        MEGUESTHOUSE.add(new LatLng(9.883896,78.080727));
        MEGUESTHOUSE.add(new LatLng(9.884735,78.080781));
        MEGUESTHOUSE.add(new LatLng(9.885035,78.080792));
        MEGUESTHOUSE.add(new LatLng(9.885210,78.080791));
        MEGUESTHOUSE.add(new LatLng(9.885211,78.080632));

        MEMAINCANTEEN.add(new LatLng(9.882365,78.081429));
        MEMAINCANTEEN.add(new LatLng(9.882707,78.081253));
        MEMAINCANTEEN.add(new LatLng(9.882949,78.081681));
        MEMAINCANTEEN.add(new LatLng(9.883234,78.081681));
        MEMAINCANTEEN.add(new LatLng(9.883262,78.080870));
        MEMAINCANTEEN.add(new LatLng(9.883286,78.080765));
        MEMAINCANTEEN.add(new LatLng(9.883277,78.080255));
        MEMAINCANTEEN.add(new LatLng(9.883264,78.079857));

        MEFOODCOURT.add(new LatLng(9.882365,78.081429));
        MEFOODCOURT.add(new LatLng(9.882707,78.081253));
        MEFOODCOURT.add(new LatLng(9.882949,78.081681));
        MEFOODCOURT.add(new LatLng(9.883234,78.081681));
        MEFOODCOURT.add(new LatLng(9.883225,78.082669));
        MEFOODCOURT.add(new LatLng(9.883225,78.083187));
        MEFOODCOURT.add(new LatLng(9.883282,78.083236));

        MEMENSHOSTEL.add(new LatLng(9.882365,78.081429));
        MEMENSHOSTEL.add(new LatLng(9.882707,78.081253));
        MEMENSHOSTEL.add(new LatLng(9.882949,78.081681));
        MEMENSHOSTEL.add(new LatLng(9.883234,78.081681));
        MEMENSHOSTEL.add(new LatLng(9.883262,78.080870));
        MEMENSHOSTEL.add(new LatLng(9.883286,78.080765));
        MEMENSHOSTEL.add(new LatLng(9.883368,78.080711));
        MEMENSHOSTEL.add(new LatLng(9.883896,78.080727));
        MEMENSHOSTEL.add(new LatLng(9.884735,78.080781));
        MEMENSHOSTEL.add(new LatLng(9.884765,78.080405));
        MEMENSHOSTEL.add(new LatLng(9.884738,78.080071));

        MEWOMENSHOSTEL.add(new LatLng(9.882365,78.081429));
        MEWOMENSHOSTEL.add(new LatLng(9.882707,78.081388));
        MEWOMENSHOSTEL.add(new LatLng(9.882452,78.081388));
        MEWOMENSHOSTEL.add(new LatLng(9.882399,78.081653));
        MEWOMENSHOSTEL.add(new LatLng(9.882321,78.081682));
        MEWOMENSHOSTEL.add(new LatLng(9.882207,78.082300));
        MEWOMENSHOSTEL.add(new LatLng(9.881980,78.082442));
        MEWOMENSHOSTEL.add(new LatLng(9.881980,78.083002));
        MEWOMENSHOSTEL.add(new LatLng(9.882124,78.083002));
        MEWOMENSHOSTEL.add(new LatLng(9.882124,78.083251));
        MEWOMENSHOSTEL.add(new LatLng(9.882124,78.083426));
        MEWOMENSHOSTEL.add(new LatLng(9.881682,78.083426));
        MEWOMENSHOSTEL.add(new LatLng(9.881301,78.083517));
        MEWOMENSHOSTEL.add(new LatLng(9.880672,78.083442));
        MEWOMENSHOSTEL.add(new LatLng(9.880375,78.083386));
        MEWOMENSHOSTEL.add(new LatLng(9.879979,78.083493));
        MEWOMENSHOSTEL.add(new LatLng(9.879832,78.083329));
        MEWOMENSHOSTEL.add(new LatLng(9.879632,78.083372));
        MEWOMENSHOSTEL.add(new LatLng(9.879518,78.082975));
        MEWOMENSHOSTEL.add(new LatLng(9.879373,78.082685));
        MEWOMENSHOSTEL.add(new LatLng(9.879288,78.082626));
        MEWOMENSHOSTEL.add(new LatLng(9.878910,78.082653));
        MEWOMENSHOSTEL.add(new LatLng(9.878479,78.082776));
        MEWOMENSHOSTEL.add(new LatLng(9.878434,78.082095));
        MEWOMENSHOSTEL.add(new LatLng(9.878201,78.082072));

        MELIBRARY.add(new LatLng(9.882365,78.081429));
        MELIBRARY.add(new LatLng(9.882707,78.081253));
        MELIBRARY.add(new LatLng(9.882982,78.081681));
        MELIBRARY.add(new LatLng(9.882982,78.081445));
        MELIBRARY.add(new LatLng(9.883105,78.081445));
        MELIBRARY.add(new LatLng(9.882854,78.081243));

        MEBANK.add(new LatLng(9.882365,78.081429));
        MEBANK.add(new LatLng(9.882707,78.081253));
        MEBANK.add(new LatLng(9.882949,78.081681));
        MEBANK.add(new LatLng(9.883234,78.081681));
        MEBANK.add(new LatLng(9.883262,78.080870));
        MEBANK.add(new LatLng(9.883286,78.080765));
        MEBANK.add(new LatLng(9.883458,78.080706));
        MEBANK.add(new LatLng(9.883496,78.079848));

        METEMPLE.add(new LatLng(9.882365,78.081429));
        METEMPLE.add(new LatLng(9.882707,78.081253));
        METEMPLE.add(new LatLng(9.882949,78.081681));
        METEMPLE.add(new LatLng(9.883234,78.081681));
        METEMPLE.add(new LatLng(9.883262,78.080870));
        METEMPLE.add(new LatLng(9.883286,78.080765));
        METEMPLE.add(new LatLng(9.883368,78.080711));
        METEMPLE.add(new LatLng(9.883896,78.080727));
        METEMPLE.add(new LatLng(9.884735,78.080781));
        METEMPLE.add(new LatLng(9.885035,78.080792));
        METEMPLE.add(new LatLng(9.885443,78.080804));
        METEMPLE.add(new LatLng(9.885459,78.080574));

        MEPARKING.add(new LatLng(9.882365,78.081429));
        MEPARKING.add(new LatLng(9.882707,78.081253));
        MEPARKING.add(new LatLng(9.882949,78.081681));
        MEPARKING.add(new LatLng(9.883234,78.081681));
        MEPARKING.add(new LatLng(9.883252,78.081003));
        MEPARKING.add(new LatLng(9.883106,78.080998));
        MEPARKING.add(new LatLng(9.882769,78.080846));
    }
    public void initMechatronicsCoordinates()
    {
        //MECHT
        MTMAINBUILDING.add(new LatLng(9.882365,78.081428));
        MTMAINBUILDING.add(new LatLng(9.882707,78.081253));
        MTMAINBUILDING.add(new LatLng(9.882722,78.081917));
        MTMAINBUILDING.add(new LatLng(9.882722,78.082452));
        MTMAINBUILDING.add(new LatLng(9.882722,78.082530));
        MTMAINBUILDING.add(new LatLng(9.882881,78.082511));

        MTIT.add(new LatLng(9.882365,78.081428));
        MTIT.add(new LatLng(9.882704,78.081311));
        MTIT.add(new LatLng(9.882488,78.081320));
        MTIT.add(new LatLng(9.882467,78.081483));
        MTIT.add(new LatLng(9.882437,78.081691));
        MTIT.add(new LatLng(9.882324,78.081691));
        MTIT.add(new LatLng(9.882324,78.081958));
        MTIT.add(new LatLng(9.882324,78.082409));
        MTIT.add(new LatLng(9.882324,78.082820));
        MTIT.add(new LatLng(9.882324,78.083199));
        MTIT.add(new LatLng(9.882326,78.083423));
        MTIT.add(new LatLng(9.882397,78.083426));
        MTIT.add(new LatLng(9.882397,78.083506));
        MTIT.add(new LatLng(9.882397,78.083569));
        MTIT.add(new LatLng(9.882399,78.083630));

        MTCSE.add(new LatLng(9.882365,78.081428));
        MTCSE.add(new LatLng(9.882602,78.081292));
        MTCSE.add(new LatLng(9.882471,78.081301));
        MTCSE.add(new LatLng(9.882431,78.081627));
        MTCSE.add(new LatLng(9.882376,78.081669));
        MTCSE.add(new LatLng(9.882347,78.081990));
        MTCSE.add(new LatLng(9.882332,78.082360));
        MTCSE.add(new LatLng(9.882329,78.082917));
        MTCSE.add(new LatLng(9.882323,78.083187));
        MTCSE.add(new LatLng(9.882332,78.083411));
        MTCSE.add(new LatLng(9.882688,78.083418));
        MTCSE.add(new LatLng(9.882893,78.083421));
        MTCSE.add(new LatLng(9.882884,78.083593));
        MTCSE.add(new LatLng(9.882896,78.083745));
        MTCSE.add(new LatLng(9.882797,78.083739));

        MTECE.add(new LatLng(9.882365,78.081428));
        MTECE.add(new LatLng(9.882727,78.081303));
        MTECE.add(new LatLng(9.882727,78.081601));
        MTECE.add(new LatLng(9.882727,78.081947));
        MTECE.add(new LatLng(9.882727,78.082312));
        MTECE.add(new LatLng(9.882727,78.082532));
        MTECE.add(new LatLng(9.882759,78.082532));
        MTECE.add(new LatLng(9.882759,78.082433));
        MTECE.add(new LatLng(9.882829,78.082341));
        MTECE.add(new LatLng(9.882829,78.082341));
        MTECE.add(new LatLng(9.882820,78.082338));

        MTEEE.add(new LatLng(9.882365,78.081428));
        MTEEE.add(new LatLng(9.882707,78.081317));
        MTEEE.add(new LatLng(9.882477,78.081317));
        MTEEE.add(new LatLng(9.882432,78.081634));
        MTEEE.add(new LatLng(9.882432,78.081753));
        MTEEE.add(new LatLng(9.882468,78.081753));
        MTEEE.add(new LatLng(9.882468,78.082038));
        MTEEE.add(new LatLng(9.882433,78.082086));

        MTCIVIL.add(new LatLng(9.882365,78.081428));
        MTCIVIL.add(new LatLng(9.882704,78.081311));
        MTCIVIL.add(new LatLng(9.882488,78.081320));
        MTCIVIL.add(new LatLng(9.882467,78.081483));
        MTCIVIL.add(new LatLng(9.882437,78.081691));
        MTCIVIL.add(new LatLng(9.882324,78.081691));
        MTCIVIL.add(new LatLng(9.882324,78.081958));
        MTCIVIL.add(new LatLng(9.882324,78.082409));
        MTCIVIL.add(new LatLng(9.882324,78.082764));
        MTCIVIL.add(new LatLng(9.882278,78.082855));

        MTMECH.add(new LatLng(9.882365,78.081428));
        MTMECH.add(new LatLng(9.882365,78.081429));

        MTARCH.add(new LatLng(9.882365,78.081428));
        MTARCH.add(new LatLng(9.882707,78.081388));
        MTARCH.add(new LatLng(9.882452,78.081388));
        MTARCH.add(new LatLng(9.882399,78.081653));
        MTARCH.add(new LatLng(9.882321,78.081682));
        MTARCH.add(new LatLng(9.882207,78.082300));
        MTARCH.add(new LatLng(9.881980,78.082442));
        MTARCH.add(new LatLng(9.881980,78.083002));
        MTARCH.add(new LatLng(9.882124,78.083002));
        MTARCH.add(new LatLng(9.882124,78.083251));
        MTARCH.add(new LatLng(9.882124,78.083426));
        MTARCH.add(new LatLng(9.881682,78.083426));
        MTARCH.add(new LatLng(9.881301,78.083517));
        MTARCH.add(new LatLng(9.880672,78.083442));
        MTARCH.add(new LatLng(9.880558,78.083080));
        MTARCH.add(new LatLng(9.880201,78.083158));
        MTARCH.add(new LatLng(9.878790,78.082110));

        MTSCIENCEBLOCK.add(new LatLng(9.882365,78.081428));
        MTSCIENCEBLOCK.add(new LatLng(9.882365,78.081428));
        MTSCIENCEBLOCK.add(new LatLng(9.882707,78.081388));
        MTSCIENCEBLOCK.add(new LatLng(9.882452,78.081388));
        MTSCIENCEBLOCK.add(new LatLng(9.882399,78.081653));
        MTSCIENCEBLOCK.add(new LatLng(9.882321,78.081682));
        MTSCIENCEBLOCK.add(new LatLng(9.882207,78.082300));
        MTSCIENCEBLOCK.add(new LatLng(9.881980,78.082442));
        MTSCIENCEBLOCK.add(new LatLng(9.881980,78.083002));
        MTSCIENCEBLOCK.add(new LatLng(9.881980,78.083111));
        MTSCIENCEBLOCK.add(new LatLng(9.881876,78.083152));

        MTFRESHERBLOCK.add(new LatLng(9.882365,78.081428));
        MTFRESHERBLOCK.add(new LatLng(9.882707,78.081388));
        MTFRESHERBLOCK.add(new LatLng(9.882452,78.081388));
        MTFRESHERBLOCK.add(new LatLng(9.882399,78.081653));
        MTFRESHERBLOCK.add(new LatLng(9.882321,78.081682));
        MTFRESHERBLOCK.add(new LatLng(9.882207,78.082300));
        MTFRESHERBLOCK.add(new LatLng(9.881980,78.082442));
        MTFRESHERBLOCK.add(new LatLng(9.881980,78.082817));
        MTFRESHERBLOCK.add(new LatLng(9.88172,78.082617));

        MTNCCBLOCK.add(new LatLng(9.882365,78.081428));
        MTNCCBLOCK.add(new LatLng(9.882707,78.081253));
        MTNCCBLOCK.add(new LatLng(9.882949,78.081681));
        MTNCCBLOCK.add(new LatLng(9.883234,78.081681));
        MTNCCBLOCK.add(new LatLng(9.883262,78.080870));
        MTNCCBLOCK.add(new LatLng(9.883286,78.080765));
        MTNCCBLOCK.add(new LatLng(9.883458,78.080706));
        MTNCCBLOCK.add(new LatLng(9.883560,78.079803));

        MTINDOOR.add(new LatLng(9.882365,78.081428));
        MTINDOOR.add(new LatLng(9.882707,78.081388));
        MTINDOOR.add(new LatLng(9.882452,78.081388));
        MTINDOOR.add(new LatLng(9.882399,78.081653));
        MTINDOOR.add(new LatLng(9.882321,78.081682));
        MTINDOOR.add(new LatLng(9.882207,78.082300));
        MTINDOOR.add(new LatLng(9.881980,78.082442));
        MTINDOOR.add(new LatLng(9.881980,78.083002));
        MTINDOOR.add(new LatLng(9.882124,78.083002));
        MTINDOOR.add(new LatLng(9.882124,78.083251));
        MTINDOOR.add(new LatLng(9.882124,78.083426));
        MTINDOOR.add(new LatLng(9.881682,78.083426));
        MTINDOOR.add(new LatLng(9.881452,78.083488));
        MTINDOOR.add(new LatLng(9.881540,78.082662));
        MTINDOOR.add(new LatLng(9.880959,78.082606));
        MTINDOOR.add(new LatLng(9.880761,78.082324));
        MTINDOOR.add(new LatLng(9.880621,78.082225));
        MTINDOOR.add(new LatLng(9.879701,78.081978));
        MTINDOOR.add(new LatLng(9.879215,78.081785));
        MTINDOOR.add(new LatLng(9.878496,78.081654));
        MTINDOOR.add(new LatLng(9.877774,78.081405));
        MTINDOOR.add(new LatLng(9.877578,78.081330));
        MTINDOOR.add(new LatLng(9.877596,78.080995));
        MTINDOOR.add(new LatLng(9.882838,78.082683));

        MTOUTDOOR.add(new LatLng(9.882365,78.081428));
        MTOUTDOOR.add(new LatLng(9.882707,78.081253));
        MTOUTDOOR.add(new LatLng(9.882949,78.081681));
        MTOUTDOOR.add(new LatLng(9.883234,78.081681));
        MTOUTDOOR.add(new LatLng(9.883842,78.081407));

        MTKSAUDITORIUM.add(new LatLng(9.882365,78.081428));
        MTKSAUDITORIUM.add(new LatLng(9.882707,78.081268));
        MTKSAUDITORIUM.add(new LatLng(9.882707,78.081976));
        MTKSAUDITORIUM.add(new LatLng(9.882820,78.082337));

        MTKMAUDITORIUM.add(new LatLng(9.882365,78.081428));
        MTKMAUDITORIUM.add(new LatLng(9.882707,78.081268));
        MTKMAUDITORIUM.add(new LatLng(9.882707,78.081976));
        MTKMAUDITORIUM.add(new LatLng(9.882707,78.082540));
        MTKMAUDITORIUM.add(new LatLng(9.882480,78.082541));

        MTPLACEMENTCELL.add(new LatLng(9.882365,78.081428));
        MTPLACEMENTCELL.add(new LatLng(9.882707,78.081253));
        MTPLACEMENTCELL.add(new LatLng(9.882949,78.081681));
        MTPLACEMENTCELL.add(new LatLng(9.883234,78.081681));
        MTPLACEMENTCELL.add(new LatLng(9.883262,78.080870));
        MTPLACEMENTCELL.add(new LatLng(9.883286,78.080765));
        MTPLACEMENTCELL.add(new LatLng(9.883368,78.080711));
        MTPLACEMENTCELL.add(new LatLng(9.883896,78.080727));
        MTPLACEMENTCELL.add(new LatLng(9.884735,78.080781));
        MTPLACEMENTCELL.add(new LatLng(9.885035,78.080792));
        MTPLACEMENTCELL.add(new LatLng(9.885026,78.080954));

        MTGUESTHOUSE.add(new LatLng(9.882365,78.081428));
        MTGUESTHOUSE.add(new LatLng(9.882707,78.081253));
        MTGUESTHOUSE.add(new LatLng(9.882949,78.081681));
        MTGUESTHOUSE.add(new LatLng(9.883234,78.081681));
        MTGUESTHOUSE.add(new LatLng(9.883262,78.080870));
        MTGUESTHOUSE.add(new LatLng(9.883286,78.080765));
        MTGUESTHOUSE.add(new LatLng(9.883368,78.080711));
        MTGUESTHOUSE.add(new LatLng(9.883896,78.080727));
        MTGUESTHOUSE.add(new LatLng(9.884735,78.080781));
        MTGUESTHOUSE.add(new LatLng(9.885035,78.080792));
        MTGUESTHOUSE.add(new LatLng(9.885210,78.080791));
        MTGUESTHOUSE.add(new LatLng(9.885211,78.080632));

        MTMAINCANTEEN.add(new LatLng(9.882365,78.081428));
        MTMAINCANTEEN.add(new LatLng(9.882707,78.081253));
        MTMAINCANTEEN.add(new LatLng(9.882949,78.081681));
        MTMAINCANTEEN.add(new LatLng(9.883234,78.081681));
        MTMAINCANTEEN.add(new LatLng(9.883262,78.080870));
        MTMAINCANTEEN.add(new LatLng(9.883286,78.080765));
        MTMAINCANTEEN.add(new LatLng(9.883277,78.080255));
        MTMAINCANTEEN.add(new LatLng(9.883264,78.079857));

        MTFOODCOURT.add(new LatLng(9.882365,78.081428));
        MTFOODCOURT.add(new LatLng(9.882707,78.081253));
        MTFOODCOURT.add(new LatLng(9.882949,78.081681));
        MTFOODCOURT.add(new LatLng(9.883234,78.081681));
        MTFOODCOURT.add(new LatLng(9.883225,78.082669));
        MTFOODCOURT.add(new LatLng(9.883225,78.083187));
        MTFOODCOURT.add(new LatLng(9.883282,78.083236));

        MTMENSHOSTEL.add(new LatLng(9.882365,78.081428));
        MTMENSHOSTEL.add(new LatLng(9.882707,78.081253));
        MTMENSHOSTEL.add(new LatLng(9.882949,78.081681));
        MTMENSHOSTEL.add(new LatLng(9.883234,78.081681));
        MTMENSHOSTEL.add(new LatLng(9.883262,78.080870));
        MTMENSHOSTEL.add(new LatLng(9.883286,78.080765));
        MTMENSHOSTEL.add(new LatLng(9.883368,78.080711));
        MTMENSHOSTEL.add(new LatLng(9.883896,78.080727));
        MTMENSHOSTEL.add(new LatLng(9.884735,78.080781));
        MTMENSHOSTEL.add(new LatLng(9.884765,78.080405));
        MTMENSHOSTEL.add(new LatLng(9.884738,78.080071));

        MTWOMENSHOSTEL.add(new LatLng(9.882365,78.081428));
        MTWOMENSHOSTEL.add(new LatLng(9.882707,78.081388));
        MTWOMENSHOSTEL.add(new LatLng(9.882452,78.081388));
        MTWOMENSHOSTEL.add(new LatLng(9.882399,78.081653));
        MTWOMENSHOSTEL.add(new LatLng(9.882321,78.081682));
        MTWOMENSHOSTEL.add(new LatLng(9.882207,78.082300));
        MTWOMENSHOSTEL.add(new LatLng(9.881980,78.082442));
        MTWOMENSHOSTEL.add(new LatLng(9.881980,78.083002));
        MTWOMENSHOSTEL.add(new LatLng(9.882124,78.083002));
        MTWOMENSHOSTEL.add(new LatLng(9.882124,78.083251));
        MTWOMENSHOSTEL.add(new LatLng(9.882124,78.083426));
        MTWOMENSHOSTEL.add(new LatLng(9.881682,78.083426));
        MTWOMENSHOSTEL.add(new LatLng(9.881301,78.083517));
        MTWOMENSHOSTEL.add(new LatLng(9.880672,78.083442));
        MTWOMENSHOSTEL.add(new LatLng(9.880375,78.083386));
        MTWOMENSHOSTEL.add(new LatLng(9.879979,78.083493));
        MTWOMENSHOSTEL.add(new LatLng(9.879832,78.083329));
        MTWOMENSHOSTEL.add(new LatLng(9.879632,78.083372));
        MTWOMENSHOSTEL.add(new LatLng(9.879518,78.082975));
        MTWOMENSHOSTEL.add(new LatLng(9.879373,78.082685));
        MTWOMENSHOSTEL.add(new LatLng(9.879288,78.082626));
        MTWOMENSHOSTEL.add(new LatLng(9.878910,78.082653));
        MTWOMENSHOSTEL.add(new LatLng(9.878479,78.082776));
        MTWOMENSHOSTEL.add(new LatLng(9.878434,78.082095));
        MTWOMENSHOSTEL.add(new LatLng(9.878201,78.082072));

        MTLIBRARY.add(new LatLng(9.882365,78.081428));
        MTLIBRARY.add(new LatLng(9.882707,78.081253));
        MTLIBRARY.add(new LatLng(9.882982,78.081681));
        MTLIBRARY.add(new LatLng(9.882982,78.081445));
        MTLIBRARY.add(new LatLng(9.883105,78.081445));
        MTLIBRARY.add(new LatLng(9.882854,78.081243));

        MTBANK.add(new LatLng(9.882365,78.081428));
        MTBANK.add(new LatLng(9.882707,78.081253));
        MTBANK.add(new LatLng(9.882949,78.081681));
        MTBANK.add(new LatLng(9.883234,78.081681));
        MTBANK.add(new LatLng(9.883262,78.080870));
        MTBANK.add(new LatLng(9.883286,78.080765));
        MTBANK.add(new LatLng(9.883458,78.080706));
        MTBANK.add(new LatLng(9.883496,78.079848));

        MTTEMPLE.add(new LatLng(9.882365,78.081428));
        MTTEMPLE.add(new LatLng(9.882707,78.081253));
        MTTEMPLE.add(new LatLng(9.882949,78.081681));
        MTTEMPLE.add(new LatLng(9.883234,78.081681));
        MTTEMPLE.add(new LatLng(9.883262,78.080870));
        MTTEMPLE.add(new LatLng(9.883286,78.080765));
        MTTEMPLE.add(new LatLng(9.883368,78.080711));
        MTTEMPLE.add(new LatLng(9.883896,78.080727));
        MTTEMPLE.add(new LatLng(9.884735,78.080781));
        MTTEMPLE.add(new LatLng(9.885035,78.080792));
        MTTEMPLE.add(new LatLng(9.885443,78.080804));
        MTTEMPLE.add(new LatLng(9.885459,78.080574));

        MTPARKING.add(new LatLng(9.882365,78.081428));
        MTPARKING.add(new LatLng(9.882707,78.081253));
        MTPARKING.add(new LatLng(9.882949,78.081681));
        MTPARKING.add(new LatLng(9.883234,78.081681));
        MTPARKING.add(new LatLng(9.883252,78.081003));
        MTPARKING.add(new LatLng(9.883106,78.080998));
        MTPARKING.add(new LatLng(9.882769,78.080846));

    }
    public void initArchCoordinates()
    {
        //ARCH

        AMAINBUILDING.add(new LatLng(9.878790,78.082110));
        AMAINBUILDING.add(new LatLng(9.880201,78.083158));
        AMAINBUILDING.add(new LatLng(9.880558,78.083080));
        AMAINBUILDING.add(new LatLng(9.880672,78.083442));
        AMAINBUILDING.add(new LatLng(9.881301,78.083517));
        AMAINBUILDING.add(new LatLng(9.881682,78.083426));
        AMAINBUILDING.add(new LatLng(9.882692,78.083426));
        AMAINBUILDING.add(new LatLng(9.882710,78.083130));
        AMAINBUILDING.add(new LatLng(9.882731,78.082759));
        AMAINBUILDING.add(new LatLng(9.882750,78.082536));
        AMAINBUILDING.add(new LatLng(9.882829,78.082341));
        AMAINBUILDING.add(new LatLng(9.882881,78.082511));

        AIT.add(new LatLng(9.878790,78.082110));
        AIT.add(new LatLng(9.880201,78.083158));
        AIT.add(new LatLng(9.880558,78.083080));
        AIT.add(new LatLng(9.880672,78.083442));
        AIT.add(new LatLng(9.881301,78.083517));
        AIT.add(new LatLng(9.881682,78.083426));
        AIT.add(new LatLng(9.882397,78.083426));
        AIT.add(new LatLng(9.882397,78.083506));
        AIT.add(new LatLng(9.882397,78.083569));
        AIT.add(new LatLng(9.882399,78.083630));


        ACSE.add(new LatLng(9.878790,78.082110));
        ACSE.add(new LatLng(9.880201,78.083158));
        ACSE.add(new LatLng(9.880558,78.083080));
        ACSE.add(new LatLng(9.880672,78.083442));
        ACSE.add(new LatLng(9.881301,78.083517));
        ACSE.add(new LatLng(9.881682,78.083426));
        ACSE.add(new LatLng(9.882397,78.083426));
        ACSE.add(new LatLng(9.882893,78.083421));
        ACSE.add(new LatLng(9.882884,78.083593));
        ACSE.add(new LatLng(9.882896,78.083745));
        ACSE.add(new LatLng(9.882797,78.083739));


        AECE.add(new LatLng(9.878790,78.082110));
        AECE.add(new LatLng(9.880201,78.083158));
        AECE.add(new LatLng(9.880558,78.083080));
        AECE.add(new LatLng(9.880672,78.083442));
        AECE.add(new LatLng(9.881301,78.083517));
        AECE.add(new LatLng(9.881682,78.083426));
        AECE.add(new LatLng(9.882208,78.083411));
        AECE.add(new LatLng(9.882319,78.083360));
        AECE.add(new LatLng(9.882398,78.083309));
        AECE.add(new LatLng(9.882554,78.083288));
        AECE.add(new LatLng(9.882691,78.083267));
        AECE.add(new LatLng(9.882710,78.083130));
        AECE.add(new LatLng(9.882731,78.082759));
        AECE.add(new LatLng(9.882750,78.082536));
        AECE.add(new LatLng(9.882820,78.082338));


        AEEE.add(new LatLng(9.878790,78.082110));
        AEEE.add(new LatLng(9.880201,78.083158));
        AEEE.add(new LatLng(9.880558,78.083080));
        AEEE.add(new LatLng(9.880672,78.083442));
        AEEE.add(new LatLng(9.881301,78.083517));
        AEEE.add(new LatLng(9.881682,78.083426));
        AEEE.add(new LatLng(9.882341,78.083402));
        AEEE.add(new LatLng(9.882341,78.083190));
        AEEE.add(new LatLng(9.882341,78.082764));
        AEEE.add(new LatLng(9.882341,78.082422));
        AEEE.add(new LatLng(9.882464,78.082422));
        AEEE.add(new LatLng(9.882464,78.082333));
        AEEE.add(new LatLng(9.882464,78.082037));
        AEEE.add(new LatLng(9.882433,78.082086));


        ACIVIL.add(new LatLng(9.878790,78.082110));
        ACIVIL.add(new LatLng(9.880201,78.083158));
        ACIVIL.add(new LatLng(9.880558,78.083080));
        ACIVIL.add(new LatLng(9.880672,78.083442));
        ACIVIL.add(new LatLng(9.881301,78.083517));
        ACIVIL.add(new LatLng(9.881682,78.083426));
        ACIVIL.add(new LatLng(9.882326,78.083423));
        ACIVIL.add(new LatLng(9.882324,78.083199));
        ACIVIL.add(new LatLng(9.882324,78.082764));
        ACIVIL.add(new LatLng(9.882278,78.082855));


        AMECH.add(new LatLng(9.878790,78.082110));
        AMECH.add(new LatLng(9.880201,78.083158));
        AMECH.add(new LatLng(9.880558,78.083080));
        AMECH.add(new LatLng(9.880672,78.083442));
        AMECH.add(new LatLng(9.881301,78.083517));
        AMECH.add(new LatLng(9.881682,78.083426));
        AMECH.add(new LatLng(9.882124,78.083426));
        AMECH.add(new LatLng(9.882124,78.083251));
        AMECH.add(new LatLng(9.882124,78.083002));
        AMECH.add(new LatLng(9.881980,78.083002));
        AMECH.add(new LatLng(9.881980,78.082442));
        AMECH.add(new LatLng(9.882207,78.082300));
        AMECH.add(new LatLng(9.882321,78.081682));
        AMECH.add(new LatLng(9.882399,78.081653));
        AMECH.add(new LatLng(9.882452,78.081388));
        AMECH.add(new LatLng(9.882707,78.081388));
        AMECH.add(new LatLng(9.882365,78.081429));


        AMECHT.add(new LatLng(9.878790,78.082110));
        AMECHT.add(new LatLng(9.880201,78.083158));
        AMECHT.add(new LatLng(9.880558,78.083080));
        AMECHT.add(new LatLng(9.880672,78.083442));
        AMECHT.add(new LatLng(9.881301,78.083517));
        AMECHT.add(new LatLng(9.881682,78.083426));
        AMECHT.add(new LatLng(9.882124,78.083426));
        AMECHT.add(new LatLng(9.882124,78.083251));
        AMECHT.add(new LatLng(9.882124,78.083002));
        AMECHT.add(new LatLng(9.881980,78.083002));
        AMECHT.add(new LatLng(9.881980,78.082442));
        AMECHT.add(new LatLng(9.882207,78.082300));
        AMECHT.add(new LatLng(9.882321,78.081682));
        AMECHT.add(new LatLng(9.882399,78.081653));
        AMECHT.add(new LatLng(9.882452,78.081388));
        AMECHT.add(new LatLng(9.882707,78.081388));
        AMECHT.add(new LatLng(9.882365,78.081428));


        ASCIENCEBLOCK.add(new LatLng(9.878790,78.082110));
        ASCIENCEBLOCK.add(new LatLng(9.880201,78.083158));
        ASCIENCEBLOCK.add(new LatLng(9.880558,78.083080));
        ASCIENCEBLOCK.add(new LatLng(9.880672,78.083442));
        ASCIENCEBLOCK.add(new LatLng(9.881301,78.083517));
        ASCIENCEBLOCK.add(new LatLng(9.881682,78.083426));
        ASCIENCEBLOCK.add(new LatLng(9.882124,78.083426));
        ASCIENCEBLOCK.add(new LatLng(9.882124,78.083251));
        ASCIENCEBLOCK.add(new LatLng(9.882124,78.083002));
        ASCIENCEBLOCK.add(new LatLng(9.881684,78.083002));
        ASCIENCEBLOCK.add(new LatLng(9.881876,78.083152));


        AFRESHERBLOCK.add(new LatLng(9.878790,78.082110));
        AFRESHERBLOCK.add(new LatLng(9.880201,78.083158));
        AFRESHERBLOCK.add(new LatLng(9.880558,78.083080));
        AFRESHERBLOCK.add(new LatLng(9.880672,78.083442));
        AFRESHERBLOCK.add(new LatLng(9.881301,78.083517));
        AFRESHERBLOCK.add(new LatLng(9.881682,78.083426));
        AFRESHERBLOCK.add(new LatLng(9.882124,78.083426));
        AFRESHERBLOCK.add(new LatLng(9.882124,78.083251));
        AFRESHERBLOCK.add(new LatLng(9.882124,78.083002));
        AFRESHERBLOCK.add(new LatLng(9.881936,78.083002));
        AFRESHERBLOCK.add(new LatLng(9.881936,78.082817));
        AFRESHERBLOCK.add(new LatLng(9.88172,78.082617));


        ANCCBLOCK.add(new LatLng(9.878790,78.082110));
        ANCCBLOCK.add(new LatLng(9.880201,78.083158));
        ANCCBLOCK.add(new LatLng(9.880558,78.083080));
        ANCCBLOCK.add(new LatLng(9.880672,78.083442));
        ANCCBLOCK.add(new LatLng(9.881301,78.083517));
        ANCCBLOCK.add(new LatLng(9.881682,78.083426));
        ANCCBLOCK.add(new LatLng(9.882124,78.083426));
        ANCCBLOCK.add(new LatLng(9.882124,78.083251));
        ANCCBLOCK.add(new LatLng(9.882124,78.083002));
        ANCCBLOCK.add(new LatLng(9.881980,78.083002));
        ANCCBLOCK.add(new LatLng(9.881980,78.082442));
        ANCCBLOCK.add(new LatLng(9.882207,78.082300));
        ANCCBLOCK.add(new LatLng(9.882321,78.081682));
        ANCCBLOCK.add(new LatLng(9.882399,78.081653));
        ANCCBLOCK.add(new LatLng(9.882771,78.081653));
        ANCCBLOCK.add(new LatLng(9.883236,78.081653));
        ANCCBLOCK.add(new LatLng(9.883262,78.080870));
        ANCCBLOCK.add(new LatLng(9.883286,78.080765));
        ANCCBLOCK.add(new LatLng(9.883458,78.080706));
        ANCCBLOCK.add(new LatLng(9.883560,78.079803));


        AINDOOR.add(new LatLng(9.878790,78.082110));
        AINDOOR.add(new LatLng(9.880201,78.083158));
        AINDOOR.add(new LatLng(9.880558,78.083080));
        AINDOOR.add(new LatLng(9.880672,78.083442));
        AINDOOR.add(new LatLng(9.881301,78.083517));
        AINDOOR.add(new LatLng(9.881452,78.083488));
        AINDOOR.add(new LatLng(9.881540,78.082662));
        AINDOOR.add(new LatLng(9.880959,78.082606));
        AINDOOR.add(new LatLng(9.880761,78.082324));
        AINDOOR.add(new LatLng(9.880621,78.082225));
        AINDOOR.add(new LatLng(9.879701,78.081978));
        AINDOOR.add(new LatLng(9.879215,78.081785));
        AINDOOR.add(new LatLng(9.878496,78.081654));
        AINDOOR.add(new LatLng(9.877774,78.081405));
        AINDOOR.add(new LatLng(9.877578,78.081330));
        AINDOOR.add(new LatLng(9.877596,78.080995));
        AINDOOR.add(new LatLng(9.882838,78.082683));


        AOUTDOOR.add(new LatLng(9.878790,78.082110));
        AOUTDOOR.add(new LatLng(9.880201,78.083158));
        AOUTDOOR.add(new LatLng(9.880558,78.083080));
        AOUTDOOR.add(new LatLng(9.880672,78.083442));
        AOUTDOOR.add(new LatLng(9.881301,78.083517));
        AOUTDOOR.add(new LatLng(9.881682,78.083426));
        AOUTDOOR.add(new LatLng(9.882124,78.083426));
        AOUTDOOR.add(new LatLng(9.882124,78.083251));
        AOUTDOOR.add(new LatLng(9.882124,78.083002));
        AOUTDOOR.add(new LatLng(9.881980,78.083002));
        AOUTDOOR.add(new LatLng(9.881980,78.082442));
        AOUTDOOR.add(new LatLng(9.882207,78.082300));
        AOUTDOOR.add(new LatLng(9.882321,78.081682));
        AOUTDOOR.add(new LatLng(9.882399,78.081653));
        AOUTDOOR.add(new LatLng(9.882771,78.081653));
        AOUTDOOR.add(new LatLng(9.883236,78.081653));
        AOUTDOOR.add(new LatLng(9.883842,78.081407));


        AKSAUDITORIUM.add(new LatLng(9.878790,78.082110));
        AKSAUDITORIUM.add(new LatLng(9.880201,78.083158));
        AKSAUDITORIUM.add(new LatLng(9.880558,78.083080));
        AKSAUDITORIUM.add(new LatLng(9.880672,78.083442));
        AKSAUDITORIUM.add(new LatLng(9.881301,78.083517));
        AKSAUDITORIUM.add(new LatLng(9.881682,78.083426));
        AKSAUDITORIUM.add(new LatLng(9.882692,78.083426));
        AKSAUDITORIUM.add(new LatLng(9.882710,78.083130));
        AKSAUDITORIUM.add(new LatLng(9.882731,78.082759));
        AKSAUDITORIUM.add(new LatLng(9.882750,78.082536));
        AKSAUDITORIUM.add(new LatLng(9.882770,78.082258));
        AKSAUDITORIUM.add(new LatLng(9.882783,78.082046));
        AKSAUDITORIUM.add(new LatLng(9.882820,78.082337));


        AKMAUDITORIUM.add(new LatLng(9.878790,78.082110));
        AKMAUDITORIUM.add(new LatLng(9.880201,78.083158));
        AKMAUDITORIUM.add(new LatLng(9.880558,78.083080));
        AKMAUDITORIUM.add(new LatLng(9.880672,78.083442));
        AKMAUDITORIUM.add(new LatLng(9.881301,78.083517));
        AKMAUDITORIUM.add(new LatLng(9.881682,78.083426));
        AKMAUDITORIUM.add(new LatLng(9.882692,78.083426));
        AKMAUDITORIUM.add(new LatLng(9.882710,78.083130));
        AKMAUDITORIUM.add(new LatLng(9.882731,78.082759));
        AKMAUDITORIUM.add(new LatLng(9.882750,78.082536));
        AKMAUDITORIUM.add(new LatLng(9.882626,78.082537));
        AKMAUDITORIUM.add(new LatLng(9.882480,78.082541));


        APLACEMENTCELL.add(new LatLng(9.878790,78.082110));
        APLACEMENTCELL.add(new LatLng(9.880201,78.083158));
        APLACEMENTCELL.add(new LatLng(9.880558,78.083080));
        APLACEMENTCELL.add(new LatLng(9.880672,78.083442));
        APLACEMENTCELL.add(new LatLng(9.881301,78.083517));
        APLACEMENTCELL.add(new LatLng(9.881682,78.083426));
        APLACEMENTCELL.add(new LatLng(9.882124,78.083426));
        APLACEMENTCELL.add(new LatLng(9.882124,78.083251));
        APLACEMENTCELL.add(new LatLng(9.882124,78.083002));
        APLACEMENTCELL.add(new LatLng(9.881980,78.083002));
        APLACEMENTCELL.add(new LatLng(9.881980,78.082442));
        APLACEMENTCELL.add(new LatLng(9.882207,78.082300));
        APLACEMENTCELL.add(new LatLng(9.882321,78.081682));
        APLACEMENTCELL.add(new LatLng(9.882399,78.081653));
        APLACEMENTCELL.add(new LatLng(9.882771,78.081653));
        APLACEMENTCELL.add(new LatLng(9.883236,78.081653));
        APLACEMENTCELL.add(new LatLng(9.883262,78.080870));
        APLACEMENTCELL.add(new LatLng(9.883286,78.080765));
        APLACEMENTCELL.add(new LatLng(9.883368,78.080711));
        APLACEMENTCELL.add(new LatLng(9.883896,78.080727));
        APLACEMENTCELL.add(new LatLng(9.884735,78.080781));
        APLACEMENTCELL.add(new LatLng(9.885035,78.080792));
        APLACEMENTCELL.add(new LatLng(9.885026,78.080954));


        AGUESTHOUSE.add(new LatLng(9.878790,78.082110));
        AGUESTHOUSE.add(new LatLng(9.880201,78.083158));
        AGUESTHOUSE.add(new LatLng(9.880558,78.083080));
        AGUESTHOUSE.add(new LatLng(9.880672,78.083442));
        AGUESTHOUSE.add(new LatLng(9.881301,78.083517));
        AGUESTHOUSE.add(new LatLng(9.881682,78.083426));
        AGUESTHOUSE.add(new LatLng(9.882124,78.083426));
        AGUESTHOUSE.add(new LatLng(9.882124,78.083251));
        AGUESTHOUSE.add(new LatLng(9.882124,78.083002));
        AGUESTHOUSE.add(new LatLng(9.881980,78.083002));
        AGUESTHOUSE.add(new LatLng(9.881980,78.082442));
        AGUESTHOUSE.add(new LatLng(9.882207,78.082300));
        AGUESTHOUSE.add(new LatLng(9.882321,78.081682));
        AGUESTHOUSE.add(new LatLng(9.882399,78.081653));
        AGUESTHOUSE.add(new LatLng(9.882771,78.081653));
        AGUESTHOUSE.add(new LatLng(9.883236,78.081653));
        AGUESTHOUSE.add(new LatLng(9.883262,78.080870));
        AGUESTHOUSE.add(new LatLng(9.883286,78.080765));
        AGUESTHOUSE.add(new LatLng(9.883368,78.080711));
        AGUESTHOUSE.add(new LatLng(9.883896,78.080727));
        AGUESTHOUSE.add(new LatLng(9.884735,78.080781));
        AGUESTHOUSE.add(new LatLng(9.885035,78.080792));
        AGUESTHOUSE.add(new LatLng(9.885210,78.080791));
        AGUESTHOUSE.add(new LatLng(9.885211,78.080632));


        AMAINCANTEEN.add(new LatLng(9.878790,78.082110));
        AMAINCANTEEN.add(new LatLng(9.880201,78.083158));
        AMAINCANTEEN.add(new LatLng(9.880558,78.083080));
        AMAINCANTEEN.add(new LatLng(9.880672,78.083442));
        AMAINCANTEEN.add(new LatLng(9.881301,78.083517));
        AMAINCANTEEN.add(new LatLng(9.881682,78.083426));
        AMAINCANTEEN.add(new LatLng(9.882124,78.083426));
        AMAINCANTEEN.add(new LatLng(9.882124,78.083251));
        AMAINCANTEEN.add(new LatLng(9.882124,78.083002));
        AMAINCANTEEN.add(new LatLng(9.881980,78.083002));
        AMAINCANTEEN.add(new LatLng(9.881980,78.082442));
        AMAINCANTEEN.add(new LatLng(9.882207,78.082300));
        AMAINCANTEEN.add(new LatLng(9.882321,78.081682));
        AMAINCANTEEN.add(new LatLng(9.882399,78.081653));
        AMAINCANTEEN.add(new LatLng(9.882771,78.081653));
        AMAINCANTEEN.add(new LatLng(9.883236,78.081653));
        AMAINCANTEEN.add(new LatLng(9.883286,78.080765));
        AMAINCANTEEN.add(new LatLng(9.883277,78.080255));
        AMAINCANTEEN.add(new LatLng(9.883264,78.079857));


        AFOODCOURT.add(new LatLng(9.878790,78.082110));
        AFOODCOURT.add(new LatLng(9.880201,78.083158));
        AFOODCOURT.add(new LatLng(9.880558,78.083080));
        AFOODCOURT.add(new LatLng(9.880672,78.083442));
        AFOODCOURT.add(new LatLng(9.881301,78.083517));
        AFOODCOURT.add(new LatLng(9.881682,78.083426));
        AFOODCOURT.add(new LatLng(9.882982,78.083426));
        AFOODCOURT.add(new LatLng(9.883168,78.083267));
        AFOODCOURT.add(new LatLng(9.883198,78.083240));
        AFOODCOURT.add(new LatLng(9.883282,78.083236));


        AMENSHOSTEL.add(new LatLng(9.878790,78.082110));
        AMENSHOSTEL.add(new LatLng(9.880201,78.083158));
        AMENSHOSTEL.add(new LatLng(9.880558,78.083080));
        AMENSHOSTEL.add(new LatLng(9.880672,78.083442));
        AMENSHOSTEL.add(new LatLng(9.881301,78.083517));
        AMENSHOSTEL.add(new LatLng(9.881682,78.083426));
        AMENSHOSTEL.add(new LatLng(9.882124,78.083426));
        AMENSHOSTEL.add(new LatLng(9.882124,78.083251));
        AMENSHOSTEL.add(new LatLng(9.882124,78.083002));
        AMENSHOSTEL.add(new LatLng(9.881980,78.083002));
        AMENSHOSTEL.add(new LatLng(9.881980,78.082442));
        AMENSHOSTEL.add(new LatLng(9.882207,78.082300));
        AMENSHOSTEL.add(new LatLng(9.882321,78.081682));
        AMENSHOSTEL.add(new LatLng(9.882399,78.081653));
        AMENSHOSTEL.add(new LatLng(9.882771,78.081653));
        AMENSHOSTEL.add(new LatLng(9.883236,78.081653));
        AMENSHOSTEL.add(new LatLng(9.883262,78.080870));
        AMENSHOSTEL.add(new LatLng(9.883286,78.080765));
        AMENSHOSTEL.add(new LatLng(9.883368,78.080711));
        AMENSHOSTEL.add(new LatLng(9.883896,78.080727));
        AMENSHOSTEL.add(new LatLng(9.884735,78.080781));
        AMENSHOSTEL.add(new LatLng(9.884765,78.080405));
        AMENSHOSTEL.add(new LatLng(9.883264,78.079857));


        AWOMENSHOSTEL.add(new LatLng(9.878790,78.082110));
        AWOMENSHOSTEL.add(new LatLng(9.880176, 78.083175));
        AWOMENSHOSTEL.add(new LatLng(9.879832,78.083329));
        AWOMENSHOSTEL.add(new LatLng(9.879632,78.083372));
        AWOMENSHOSTEL.add(new LatLng(9.879518,78.082975));
        AWOMENSHOSTEL.add(new LatLng(9.879373,78.082685));
        AWOMENSHOSTEL.add(new LatLng(9.879288,78.082626));
        AWOMENSHOSTEL.add(new LatLng(9.878910,78.082653));
        AWOMENSHOSTEL.add(new LatLng(9.878479,78.082776));
        AWOMENSHOSTEL.add(new LatLng(9.878434,78.082095));
        AWOMENSHOSTEL.add(new LatLng(9.878201,78.082072));


        ALIBRARY.add(new LatLng(9.878790,78.082110));
        ALIBRARY.add(new LatLng(9.880201,78.083158));
        ALIBRARY.add(new LatLng(9.880558,78.083080));
        ALIBRARY.add(new LatLng(9.880672,78.083442));
        ALIBRARY.add(new LatLng(9.881301,78.083517));
        ALIBRARY.add(new LatLng(9.881682,78.083426));
        ALIBRARY.add(new LatLng(9.882124,78.083426));
        ALIBRARY.add(new LatLng(9.882124,78.083251));
        ALIBRARY.add(new LatLng(9.882124,78.083002));
        ALIBRARY.add(new LatLng(9.881980,78.083002));
        ALIBRARY.add(new LatLng(9.881980,78.082442));
        ALIBRARY.add(new LatLng(9.882207,78.082300));
        ALIBRARY.add(new LatLng(9.882321,78.081682));
        ALIBRARY.add(new LatLng(9.882399,78.081681));
        ALIBRARY.add(new LatLng(9.882982,78.081681));
        ALIBRARY.add(new LatLng(9.882982,78.081445));
        ALIBRARY.add(new LatLng(9.883105,78.081445));
        ALIBRARY.add(new LatLng(9.882854,78.081243));


        ABANK.add(new LatLng(9.878790,78.082110));
        ABANK.add(new LatLng(9.880201,78.083158));
        ABANK.add(new LatLng(9.880558,78.083080));
        ABANK.add(new LatLng(9.880672,78.083442));
        ABANK.add(new LatLng(9.881301,78.083517));
        ABANK.add(new LatLng(9.881682,78.083426));
        ABANK.add(new LatLng(9.882124,78.083426));
        ABANK.add(new LatLng(9.882124,78.083251));
        ABANK.add(new LatLng(9.882124,78.083002));
        ABANK.add(new LatLng(9.881980,78.083002));
        ABANK.add(new LatLng(9.881980,78.082442));
        ABANK.add(new LatLng(9.882207,78.082300));
        ABANK.add(new LatLng(9.882321,78.081682));
        ABANK.add(new LatLng(9.882399,78.081653));
        ABANK.add(new LatLng(9.882771,78.081653));
        ABANK.add(new LatLng(9.883236,78.081653));
        ABANK.add(new LatLng(9.883262,78.080870));
        ABANK.add(new LatLng(9.883286,78.080765));
        ABANK.add(new LatLng(9.883458,78.080706));
        ABANK.add(new LatLng(9.883496,78.079848));


        ATEMPLE.add(new LatLng(9.878790,78.082110));
        ATEMPLE.add(new LatLng(9.880201,78.083158));
        ATEMPLE.add(new LatLng(9.880558,78.083080));
        ATEMPLE.add(new LatLng(9.880672,78.083442));
        ATEMPLE.add(new LatLng(9.881301,78.083517));
        ATEMPLE.add(new LatLng(9.881682,78.083426));
        ATEMPLE.add(new LatLng(9.882124,78.083426));
        ATEMPLE.add(new LatLng(9.882124,78.083251));
        ATEMPLE.add(new LatLng(9.882124,78.083002));
        ATEMPLE.add(new LatLng(9.881980,78.083002));
        ATEMPLE.add(new LatLng(9.881980,78.082442));
        ATEMPLE.add(new LatLng(9.882207,78.082300));
        ATEMPLE.add(new LatLng(9.882321,78.081682));
        ATEMPLE.add(new LatLng(9.882399,78.081653));
        ATEMPLE.add(new LatLng(9.882771,78.081653));
        ATEMPLE.add(new LatLng(9.883236,78.081653));
        ATEMPLE.add(new LatLng(9.883262,78.080870));
        ATEMPLE.add(new LatLng(9.883286,78.080765));
        ATEMPLE.add(new LatLng(9.883368,78.080711));
        ATEMPLE.add(new LatLng(9.883896,78.080727));
        ATEMPLE.add(new LatLng(9.884735,78.080781));
        ATEMPLE.add(new LatLng(9.885035,78.080792));
        ATEMPLE.add(new LatLng(9.885443,78.080804));
        ATEMPLE.add(new LatLng(9.885459,78.080574));


        APARKING.add(new LatLng(9.878790,78.082110));
        APARKING.add(new LatLng(9.880201,78.083158));
        APARKING.add(new LatLng(9.880558,78.083080));
        APARKING.add(new LatLng(9.880672,78.083442));
        APARKING.add(new LatLng(9.881301,78.083517));
        APARKING.add(new LatLng(9.881682,78.083426));
        APARKING.add(new LatLng(9.882124,78.083426));
        APARKING.add(new LatLng(9.882124,78.083251));
        APARKING.add(new LatLng(9.882124,78.083002));
        APARKING.add(new LatLng(9.881980,78.083002));
        APARKING.add(new LatLng(9.881980,78.082442));
        APARKING.add(new LatLng(9.882207,78.082300));
        APARKING.add(new LatLng(9.882321,78.081682));
        APARKING.add(new LatLng(9.882399,78.081653));
        APARKING.add(new LatLng(9.882771,78.081653));
        APARKING.add(new LatLng(9.883236,78.081653));
        APARKING.add(new LatLng(9.883252,78.081003));
        APARKING.add(new LatLng(9.883106,78.080998));
        APARKING.add(new LatLng(9.882769,78.080846));

    }
    public void initKMCoordinates()
    {
        //KM
        KMMAINBUILDING.add(new LatLng(9.882480,78.082541));
        KMMAINBUILDING.add(new LatLng(9.882716,78.082540));
        KMMAINBUILDING.add(new LatLng(9.882881,78.082511));


        KMIT.add(new LatLng(9.882480,78.082541));
        KMIT.add(new LatLng(9.882626,78.082537));
        KMIT.add(new LatLng(9.882750,78.082536));
        KMIT.add(new LatLng(9.882731,78.082759));
        KMIT.add(new LatLng(9.882710,78.083130));
        KMIT.add(new LatLng(9.882692,78.083426));
        KMIT.add(new LatLng(9.882397,78.083426));
        KMIT.add(new LatLng(9.882397,78.083506));
        KMIT.add(new LatLng(9.882397,78.083569));
        KMIT.add(new LatLng(9.882399,78.083630));


        KMCSE.add(new LatLng(9.882480,78.082541));
        KMCSE.add(new LatLng(9.882737,78.082534));
        KMCSE.add(new LatLng(9.882711,78.083131));
        KMCSE.add(new LatLng(9.882688,78.083418));
        KMCSE.add(new LatLng(9.882893,78.083421));
        KMCSE.add(new LatLng(9.882884,78.083593));
        KMCSE.add(new LatLng(9.882896,78.083745));
        KMCSE.add(new LatLng(9.882797,78.083739));


        KMECE.add(new LatLng(9.882480,78.082541));
        KMECE.add(new LatLng(9.882727,78.082532));
        KMECE.add(new LatLng(9.882759,78.082532));
        KMECE.add(new LatLng(9.882759,78.082433));
        KMECE.add(new LatLng(9.882820,78.082338));


        KMEEE.add(new LatLng(9.882480,78.082541));
        KMEEE.add(new LatLng(9.882727,78.082540));
        KMEEE.add(new LatLng(9.882727,78.082435));
        KMEEE.add(new LatLng(9.882625,78.082435));
        KMEEE.add(new LatLng(9.882463,78.082426));
        KMEEE.add(new LatLng(9.882463,78.082342));
        KMEEE.add(new LatLng(9.882463,78.082176));
        KMEEE.add(new LatLng(9.882433,78.082086));


        KMCIVIL.add(new LatLng(9.882480,78.082541));
        KMCIVIL.add(new LatLng(9.882715,78.082540));
        KMCIVIL.add(new LatLng(9.882715,78.082633));
        KMCIVIL.add(new LatLng(9.882538,78.082633));
        KMCIVIL.add(new LatLng(9.882345,78.082633));
        KMCIVIL.add(new LatLng(9.882345,78.082764));
        KMCIVIL.add(new LatLng(9.882278,78.082855));


        KMMECH.add(new LatLng(9.882480,78.082541));
        KMMECH.add(new LatLng(9.882707,78.082540));
        KMMECH.add(new LatLng(9.882707,78.081976));
        KMMECH.add(new LatLng(9.882707,78.081268));
        KMMECH.add(new LatLng(9.882365,78.081429));


        KMMECHT.add(new LatLng(9.882480,78.082541));
        KMMECHT.add(new LatLng(9.882707,78.082540));
        KMMECHT.add(new LatLng(9.882707,78.081976));
        KMMECHT.add(new LatLng(9.882707,78.081268));
        KMMECHT.add(new LatLng(9.882365,78.081428));


        KMARCH.add(new LatLng(9.882480,78.082541));
        KMARCH.add(new LatLng(9.882626,78.082537));
        KMARCH.add(new LatLng(9.882750,78.082536));
        KMARCH.add(new LatLng(9.882731,78.082759));
        KMARCH.add(new LatLng(9.882710,78.083130));
        KMARCH.add(new LatLng(9.882692,78.083426));
        KMARCH.add(new LatLng(9.881682,78.083426));
        KMARCH.add(new LatLng(9.881301,78.083517));
        KMARCH.add(new LatLng(9.880672,78.083442));
        KMARCH.add(new LatLng(9.880558,78.083080));
        KMARCH.add(new LatLng(9.880201,78.083158));
        KMARCH.add(new LatLng(9.878790,78.082110));


        KMSCIENCEBLOCK.add(new LatLng(9.882480,78.082541));
        KMSCIENCEBLOCK.add(new LatLng(9.882744,78.082540));
        KMSCIENCEBLOCK.add(new LatLng(9.882744,78.082452));
        KMSCIENCEBLOCK.add(new LatLng(9.882362,78.082437));
        KMSCIENCEBLOCK.add(new LatLng(9.882322,78.082336));
        KMSCIENCEBLOCK.add(new LatLng(9.882004,78.082337));
        KMSCIENCEBLOCK.add(new LatLng(9.881943,78.083021));
        KMSCIENCEBLOCK.add(new LatLng(9.881697,78.083028));
        KMSCIENCEBLOCK.add(new LatLng(9.881876,78.083152));


        KMFRESHERBLOCK.add(new LatLng(9.882480,78.082541));
        KMFRESHERBLOCK.add(new LatLng(9.882717,78.082540));
        KMFRESHERBLOCK.add(new LatLng(9.882717,78.082435));
        KMFRESHERBLOCK.add(new LatLng(9.882341,78.082422));
        KMFRESHERBLOCK.add(new LatLng(9.882341,78.082342));
        KMFRESHERBLOCK.add(new LatLng(9.882238,78.082342));
        KMFRESHERBLOCK.add(new LatLng(9.882066,78.082397));
        KMFRESHERBLOCK.add(new LatLng(9.881912,78.082477));
        KMFRESHERBLOCK.add(new LatLng(9.881912,78.082817));
        KMFRESHERBLOCK.add(new LatLng(9.88172,78.082617));


        KMNCCBLOCK.add(new LatLng(9.882480,78.082541));
        KMNCCBLOCK.add(new LatLng(9.883234,78.082540));
        KMNCCBLOCK.add(new LatLng(9.883234,78.081681));
        KMNCCBLOCK.add(new LatLng(9.883262,78.080870));
        KMNCCBLOCK.add(new LatLng(9.883286,78.080765));
        KMNCCBLOCK.add(new LatLng(9.883458,78.080706));
        KMNCCBLOCK.add(new LatLng(9.883560,78.079803));


        KMINDOOR.add(new LatLng(9.882480,78.082541));
        KMINDOOR.add(new LatLng(9.882626,78.082537));
        KMINDOOR.add(new LatLng(9.882750,78.082536));
        KMINDOOR.add(new LatLng(9.882731,78.082759));
        KMINDOOR.add(new LatLng(9.882710,78.083130));
        KMINDOOR.add(new LatLng(9.882692,78.083426));
        KMINDOOR.add(new LatLng(9.881682,78.083426));
        KMINDOOR.add(new LatLng(9.881452,78.083488));
        KMINDOOR.add(new LatLng(9.881540,78.082662));
        KMINDOOR.add(new LatLng(9.880959,78.082606));
        KMINDOOR.add(new LatLng(9.880761,78.082324));
        KMINDOOR.add(new LatLng(9.880621,78.082225));
        KMINDOOR.add(new LatLng(9.879701,78.081978));
        KMINDOOR.add(new LatLng(9.879215,78.081785));
        KMINDOOR.add(new LatLng(9.878496,78.081654));
        KMINDOOR.add(new LatLng(9.877774,78.081405));
        KMINDOOR.add(new LatLng(9.877578,78.081330));
        KMINDOOR.add(new LatLng(9.877596,78.080995));
        KMINDOOR.add(new LatLng(9.882838,78.082683));


        KMOUTDOOR.add(new LatLng(9.882480,78.082541));
        KMOUTDOOR.add(new LatLng(9.882711,78.082540));
        KMOUTDOOR.add(new LatLng(9.882933,78.082540));
        KMOUTDOOR.add(new LatLng(9.883250,78.082540));
        KMOUTDOOR.add(new LatLng(9.883250,78.081539));
        KMOUTDOOR.add(new LatLng(9.883842,78.081407));


        KMKSAUDITORIUM.add(new LatLng(9.882480,78.082541));
        KMKSAUDITORIUM.add(new LatLng(9.882741,78.082532));
        KMKSAUDITORIUM.add(new LatLng(9.882774,78.081976));
        KMKSAUDITORIUM.add(new LatLng(9.882820,78.082337));


        KMPLACEMENTCELL.add(new LatLng(9.882480,78.082541));
        KMPLACEMENTCELL.add(new LatLng(9.882716,78.082540));
        KMPLACEMENTCELL.add(new LatLng(9.883210,78.082540));
        KMPLACEMENTCELL.add(new LatLng(9.883262,78.080870));
        KMPLACEMENTCELL.add(new LatLng(9.883286,78.080765));
        KMPLACEMENTCELL.add(new LatLng(9.883368,78.080711));
        KMPLACEMENTCELL.add(new LatLng(9.883896,78.080727));
        KMPLACEMENTCELL.add(new LatLng(9.884735,78.080781));
        KMPLACEMENTCELL.add(new LatLng(9.885035,78.080792));
        KMPLACEMENTCELL.add(new LatLng(9.885026,78.080954));


        KMGUESTHOUSE.add(new LatLng(9.882480,78.082541));
        KMGUESTHOUSE.add(new LatLng(9.882716,78.082540));
        KMGUESTHOUSE.add(new LatLng(9.883210,78.082540));
        KMGUESTHOUSE.add(new LatLng(9.883262,78.080870));
        KMGUESTHOUSE.add(new LatLng(9.883286,78.080765));
        KMGUESTHOUSE.add(new LatLng(9.883368,78.080711));
        KMGUESTHOUSE.add(new LatLng(9.883896,78.080727));
        KMGUESTHOUSE.add(new LatLng(9.884735,78.080781));
        KMGUESTHOUSE.add(new LatLng(9.885035,78.080792));
        KMGUESTHOUSE.add(new LatLng(9.885210,78.080791));
        KMGUESTHOUSE.add(new LatLng(9.885211,78.080632));

        KMMAINCANTEEN.add(new LatLng(9.882480,78.082541));
        KMMAINCANTEEN.add(new LatLng(9.882716,78.082540));
        KMMAINCANTEEN.add(new LatLng(9.883210,78.082540));
        KMMAINCANTEEN.add(new LatLng(9.883262,78.080870));
        KMMAINCANTEEN.add(new LatLng(9.883286,78.080765));
        KMMAINCANTEEN.add(new LatLng(9.883277,78.080255));
        KMMAINCANTEEN.add(new LatLng(9.883264,78.079857));


        KMFOODCOURT.add(new LatLng(9.882480,78.082541));
        KMFOODCOURT.add(new LatLng(9.882716,78.082540));
        KMFOODCOURT.add(new LatLng(9.883210,78.082540));
        KMFOODCOURT.add(new LatLng(9.883186,78.083246));
        KMFOODCOURT.add(new LatLng(9.883282,78.083236));

        KMMENSHOSTEL.add(new LatLng(9.882480,78.082541));
        KMMENSHOSTEL.add(new LatLng(9.882716,78.082540));
        KMMENSHOSTEL.add(new LatLng(9.883210,78.082540));
        KMMENSHOSTEL.add(new LatLng(9.883262,78.080870));
        KMMENSHOSTEL.add(new LatLng(9.883286,78.080765));
        KMMENSHOSTEL.add(new LatLng(9.883368,78.080711));
        KMMENSHOSTEL.add(new LatLng(9.883896,78.080727));
        KMMENSHOSTEL.add(new LatLng(9.884735,78.080781));
        KMMENSHOSTEL.add(new LatLng(9.884765,78.080405));
        KMMENSHOSTEL.add(new LatLng(9.884738,78.080071));

        KMWOMENSHOSTEL.add(new LatLng(9.882480,78.082541));
        KMWOMENSHOSTEL.add(new LatLng(9.882716,78.082540));
        KMWOMENSHOSTEL.add(new LatLng(9.882731,78.082759));
        KMWOMENSHOSTEL.add(new LatLng(9.882710,78.083130));
        KMWOMENSHOSTEL.add(new LatLng(9.882691,78.083267));
        KMWOMENSHOSTEL.add(new LatLng(9.882554,78.083288));
        KMWOMENSHOSTEL.add(new LatLng(9.882398,78.083309));
        KMWOMENSHOSTEL.add(new LatLng(9.882319,78.083360));
        KMWOMENSHOSTEL.add(new LatLng(9.882208,78.083411));
        KMWOMENSHOSTEL.add(new LatLng(9.881682,78.083426));
        KMWOMENSHOSTEL.add(new LatLng(9.881301,78.083517));
        KMWOMENSHOSTEL.add(new LatLng(9.880672,78.083442));
        KMWOMENSHOSTEL.add(new LatLng(9.880375,78.083386));
        KMWOMENSHOSTEL.add(new LatLng(9.879979,78.083493));
        KMWOMENSHOSTEL.add(new LatLng(9.879832,78.083329));
        KMWOMENSHOSTEL.add(new LatLng(9.879632,78.083372));
        KMWOMENSHOSTEL.add(new LatLng(9.879518,78.082975));
        KMWOMENSHOSTEL.add(new LatLng(9.879373,78.082685));
        KMWOMENSHOSTEL.add(new LatLng(9.879288,78.082626));
        KMWOMENSHOSTEL.add(new LatLng(9.878910,78.082653));
        KMWOMENSHOSTEL.add(new LatLng(9.878479,78.082776));
        KMWOMENSHOSTEL.add(new LatLng(9.878434,78.082095));
        KMWOMENSHOSTEL.add(new LatLng(9.878201,78.082072));

        KMLIBRARY.add(new LatLng(9.882480,78.082541));
        KMLIBRARY.add(new LatLng(9.882716,78.082540));
        KMLIBRARY.add(new LatLng(9.883210,78.082540));
        KMLIBRARY.add(new LatLng(9.883236,78.081264));
        KMLIBRARY.add(new LatLng(9.882854,78.081243));

        KMBANK.add(new LatLng(9.882480,78.082541));
        KMBANK.add(new LatLng(9.882716,78.082540));
        KMBANK.add(new LatLng(9.883210,78.082540));
        KMBANK.add(new LatLng(9.883262,78.080870));
        KMBANK.add(new LatLng(9.883286,78.080765));
        KMBANK.add(new LatLng(9.883458,78.080706));
        KMBANK.add(new LatLng(9.883496,78.079848));

        KMTEMPLE.add(new LatLng(9.882480,78.082541));
        KMTEMPLE.add(new LatLng(9.882716,78.082540));
        KMTEMPLE.add(new LatLng(9.883210,78.082540));
        KMTEMPLE.add(new LatLng(9.883262,78.080870));
        KMTEMPLE.add(new LatLng(9.883286,78.080765));
        KMTEMPLE.add(new LatLng(9.883368,78.080711));
        KMTEMPLE.add(new LatLng(9.883896,78.080727));
        KMTEMPLE.add(new LatLng(9.884735,78.080781));
        KMTEMPLE.add(new LatLng(9.885035,78.080792));
        KMTEMPLE.add(new LatLng(9.885443,78.080804));
        KMTEMPLE.add(new LatLng(9.885459,78.080574));

        KMPARKING.add(new LatLng(9.882480,78.082541));
        KMPARKING.add(new LatLng(9.882716,78.082540));
        KMPARKING.add(new LatLng(9.883210,78.082540));
        KMPARKING.add(new LatLng(9.883252,78.081003));
        KMPARKING.add(new LatLng(9.883106,78.080998));
        KMPARKING.add(new LatLng(9.882769,78.080846));

    }
    public void initKSCoordinates()
    {
        //KS

        KSMAINBUILDING.add(new LatLng(9.882820,78.082337));
        KSMAINBUILDING.add(new LatLng(9.882881,78.082511));

        KSIT.add(new LatLng(9.882820,78.082337));
        KSIT.add(new LatLng(9.882783,78.082046));
        KSIT.add(new LatLng(9.882770,78.082258));
        KSIT.add(new LatLng(9.882750,78.082536));
        KSIT.add(new LatLng(9.882731,78.082759));
        KSIT.add(new LatLng(9.882710,78.083130));
        KSIT.add(new LatLng(9.882692,78.083426));
        KSIT.add(new LatLng(9.882397,78.083426));
        KSIT.add(new LatLng(9.882397,78.083506));
        KSIT.add(new LatLng(9.882397,78.083569));
        KSIT.add(new LatLng(9.882399,78.083630));


        KSCSE.add(new LatLng(9.882820,78.082337));
        KSCSE.add(new LatLng(9.882914,78.081975));
        KSCSE.add(new LatLng(9.882904,78.082272));
        KSCSE.add(new LatLng(9.882904,78.082674));
        KSCSE.add(new LatLng(9.882891,78.083151));
        KSCSE.add(new LatLng(9.882893,78.083421));
        KSCSE.add(new LatLng(9.882884,78.083593));
        KSCSE.add(new LatLng(9.882896,78.083745));
        KSCSE.add(new LatLng(9.882797,78.083739));


        KSECE.add(new LatLng(9.882820,78.082337));
        KSECE.add(new LatLng(9.882897,78.081976));
        KSECE.add(new LatLng(9.882897,78.082341));
        KSECE.add(new LatLng(9.882820,78.082338));


        KSEEE.add(new LatLng(9.882820,78.082337));
        KSEEE.add(new LatLng(9.882783,78.081976));
        KSEEE.add(new LatLng(9.882727,78.082435));
        KSEEE.add(new LatLng(9.882625,78.082435));
        KSEEE.add(new LatLng(9.882463,78.082426));
        KSEEE.add(new LatLng(9.882463,78.082342));
        KSEEE.add(new LatLng(9.882463,78.082176));
        KSEEE.add(new LatLng(9.882433,78.082086));


        KSCIVIL.add(new LatLng(9.882820,78.082337));
        KSCIVIL.add(new LatLng(9.882759,78.081976));
        KSCIVIL.add(new LatLng(9.882759,78.082433));
        KSCIVIL.add(new LatLng(9.882759,78.082532));
        KSCIVIL.add(new LatLng(9.882727,78.082532));
        KSCIVIL.add(new LatLng(9.882720,78.082638));
        KSCIVIL.add(new LatLng(9.882560,78.082638));
        KSCIVIL.add(new LatLng(9.882345,78.082638));
        KSCIVIL.add(new LatLng(9.882345,78.082764));
        KSCIVIL.add(new LatLng(9.882278,78.082855));


        KSMECH.add(new LatLng(9.882820,78.082337));
        KSMECH.add(new LatLng(9.882707,78.081976));
        KSMECH.add(new LatLng(9.882707,78.081268));
        KSMECH.add(new LatLng(9.882365,78.081429));


        KSMECHT.add(new LatLng(9.882820,78.082337));
        KSMECHT.add(new LatLng(9.882707,78.081976));
        KSMECHT.add(new LatLng(9.882707,78.081268));
        KSMECHT.add(new LatLng(9.882365,78.081428));


        KSARCH.add(new LatLng(9.882820,78.082337));
        KSARCH.add(new LatLng(9.882783,78.082046));
        KSARCH.add(new LatLng(9.882770,78.082258));
        KSARCH.add(new LatLng(9.882750,78.082536));
        KSARCH.add(new LatLng(9.882731,78.082759));
        KSARCH.add(new LatLng(9.882710,78.083130));
        KSARCH.add(new LatLng(9.882692,78.083426));
        KSARCH.add(new LatLng(9.881682,78.083426));
        KSARCH.add(new LatLng(9.881301,78.083517));
        KSARCH.add(new LatLng(9.880672,78.083442));
        KSARCH.add(new LatLng(9.880558,78.083080));
        KSARCH.add(new LatLng(9.880201,78.083158));
        KSARCH.add(new LatLng(9.878790,78.082110));


        KSSCIENCEBLOCK.add(new LatLng(9.882820,78.082337));
        KSSCIENCEBLOCK.add(new LatLng(9.882744,78.081976));
        KSSCIENCEBLOCK.add(new LatLng(9.882744,78.082452));
        KSSCIENCEBLOCK.add(new LatLng(9.882362,78.082437));
        KSSCIENCEBLOCK.add(new LatLng(9.882322,78.082336));
        KSSCIENCEBLOCK.add(new LatLng(9.882004,78.082337));
        KSSCIENCEBLOCK.add(new LatLng(9.881943,78.083021));
        KSSCIENCEBLOCK.add(new LatLng(9.881697,78.083028));
        KSSCIENCEBLOCK.add(new LatLng(9.881876,78.083152));


        KSFRESHERBLOCK.add(new LatLng(9.882820,78.082337));
        KSFRESHERBLOCK.add(new LatLng(9.882791,78.081976));
        KSFRESHERBLOCK.add(new LatLng(9.882717,78.082435));
        KSFRESHERBLOCK.add(new LatLng(9.882341,78.082422));
        KSFRESHERBLOCK.add(new LatLng(9.882341,78.082342));
        KSFRESHERBLOCK.add(new LatLng(9.882238,78.082342));
        KSFRESHERBLOCK.add(new LatLng(9.882066,78.082397));
        KSFRESHERBLOCK.add(new LatLng(9.881912,78.082477));
        KSFRESHERBLOCK.add(new LatLng(9.881912,78.082817));
        KSFRESHERBLOCK.add(new LatLng(9.88172,78.082617));


        KSNCCBLOCK.add(new LatLng(9.882820,78.082337));
        KSNCCBLOCK.add(new LatLng(9.883234,78.081976));
        KSNCCBLOCK.add(new LatLng(9.883234,78.081681));
        KSNCCBLOCK.add(new LatLng(9.883262,78.080870));
        KSNCCBLOCK.add(new LatLng(9.883286,78.080765));
        KSNCCBLOCK.add(new LatLng(9.883458,78.080706));
        KSNCCBLOCK.add(new LatLng(9.883560,78.079803));


        KSINDOOR.add(new LatLng(9.882820,78.082337));
        KSINDOOR.add(new LatLng(9.882783,78.082046));
        KSINDOOR.add(new LatLng(9.882770,78.082258));
        KSINDOOR.add(new LatLng(9.882750,78.082536));
        KSINDOOR.add(new LatLng(9.882731,78.082759));
        KSINDOOR.add(new LatLng(9.882710,78.083130));
        KSINDOOR.add(new LatLng(9.882692,78.083426));
        KSINDOOR.add(new LatLng(9.882124,78.083426));
        KSINDOOR.add(new LatLng(9.881682,78.083426));
        KSINDOOR.add(new LatLng(9.881452,78.083488));
        KSINDOOR.add(new LatLng(9.881540,78.082662));
        KSINDOOR.add(new LatLng(9.880959,78.082606));
        KSINDOOR.add(new LatLng(9.880761,78.082324));
        KSINDOOR.add(new LatLng(9.880621,78.082225));
        KSINDOOR.add(new LatLng(9.879701,78.081978));
        KSINDOOR.add(new LatLng(9.879215,78.081785));
        KSINDOOR.add(new LatLng(9.878496,78.081654));
        KSINDOOR.add(new LatLng(9.877774,78.081405));
        KSINDOOR.add(new LatLng(9.877578,78.081330));
        KSINDOOR.add(new LatLng(9.877596,78.080995));
        KSINDOOR.add(new LatLng(9.882838,78.082683));


        KSOUTDOOR.add(new LatLng(9.882820,78.082337));
        KSOUTDOOR.add(new LatLng(9.883250,78.081976));
        KSOUTDOOR.add(new LatLng(9.883250,78.081539));
        KSOUTDOOR.add(new LatLng(9.883842,78.081407));


        KSKMAUDITORIUM.add(new LatLng(9.882820,78.082337));
        KSKMAUDITORIUM.add(new LatLng(9.882774,78.081976));
        KSKMAUDITORIUM.add(new LatLng(9.882741,78.082532));
        KSKMAUDITORIUM.add(new LatLng(9.882480,78.082541));


        KSPLACEMENTCELL.add(new LatLng(9.882820,78.082337));
        KSPLACEMENTCELL.add(new LatLng(9.883227,78.081976));
        KSPLACEMENTCELL.add(new LatLng(9.883262,78.080870));
        KSPLACEMENTCELL.add(new LatLng(9.883286,78.080765));
        KSPLACEMENTCELL.add(new LatLng(9.883368,78.080711));
        KSPLACEMENTCELL.add(new LatLng(9.883896,78.080727));
        KSPLACEMENTCELL.add(new LatLng(9.884735,78.080781));
        KSPLACEMENTCELL.add(new LatLng(9.885035,78.080792));
        KSPLACEMENTCELL.add(new LatLng(9.885026,78.080954));


        KSGUESTHOUSE.add(new LatLng(9.882820,78.082337));
        KSGUESTHOUSE.add(new LatLng(9.883227,78.081976));
        KSGUESTHOUSE.add(new LatLng(9.883262,78.080870));
        KSGUESTHOUSE.add(new LatLng(9.883286,78.080765));
        KSGUESTHOUSE.add(new LatLng(9.883368,78.080711));
        KSGUESTHOUSE.add(new LatLng(9.883896,78.080727));
        KSGUESTHOUSE.add(new LatLng(9.884735,78.080781));
        KSGUESTHOUSE.add(new LatLng(9.885035,78.080792));
        KSGUESTHOUSE.add(new LatLng(9.885210,78.080791));
        KSGUESTHOUSE.add(new LatLng(9.885211,78.080632));


        KSMAINCANTEEN.add(new LatLng(9.882820,78.082337));
        KSMAINCANTEEN.add(new LatLng(9.883227,78.081976));
        KSMAINCANTEEN.add(new LatLng(9.883262,78.080870));
        KSMAINCANTEEN.add(new LatLng(9.883286,78.080765));
        KSMAINCANTEEN.add(new LatLng(9.883277,78.080255));
        KSMAINCANTEEN.add(new LatLng(9.883264,78.079857));


        KSFOODCOURT.add(new LatLng(9.882820,78.082337));
        KSFOODCOURT.add(new LatLng(9.883227,78.081976));
        KSFOODCOURT.add(new LatLng(9.883198,78.083246));
        KSFOODCOURT.add(new LatLng(9.883282,78.083236));


        KSMENSHOSTEL.add(new LatLng(9.882820,78.082337));
        KSMENSHOSTEL.add(new LatLng(9.883227,78.081976));
        KSMENSHOSTEL.add(new LatLng(9.883262,78.080870));
        KSMENSHOSTEL.add(new LatLng(9.883286,78.080765));
        KSMENSHOSTEL.add(new LatLng(9.883368,78.080711));
        KSMENSHOSTEL.add(new LatLng(9.883896,78.080727));
        KSMENSHOSTEL.add(new LatLng(9.884735,78.080781));
        KSMENSHOSTEL.add(new LatLng(9.884765,78.080405));
        KSMENSHOSTEL.add(new LatLng(9.884738,78.080071));


        KSWOMENSHOSTEL.add(new LatLng(9.882820,78.082337));
        KSWOMENSHOSTEL.add(new LatLng(9.882786,78.081976));
        KSWOMENSHOSTEL.add(new LatLng(9.882750,78.082536));
        KSWOMENSHOSTEL.add(new LatLng(9.882731,78.082759));
        KSWOMENSHOSTEL.add(new LatLng(9.882710,78.083130));
        KSWOMENSHOSTEL.add(new LatLng(9.882691,78.083267));
        KSWOMENSHOSTEL.add(new LatLng(9.882554,78.083288));
        KSWOMENSHOSTEL.add(new LatLng(9.882398,78.083309));
        KSWOMENSHOSTEL.add(new LatLng(9.882319,78.083360));
        KSWOMENSHOSTEL.add(new LatLng(9.882208,78.083411));
        KSWOMENSHOSTEL.add(new LatLng(9.881682,78.083426));
        KSWOMENSHOSTEL.add(new LatLng(9.881301,78.083517));
        KSWOMENSHOSTEL.add(new LatLng(9.880672,78.083442));
        KSWOMENSHOSTEL.add(new LatLng(9.880375,78.083386));
        KSWOMENSHOSTEL.add(new LatLng(9.879979,78.083493));
        KSWOMENSHOSTEL.add(new LatLng(9.879832,78.083329));
        KSWOMENSHOSTEL.add(new LatLng(9.879632,78.083372));
        KSWOMENSHOSTEL.add(new LatLng(9.879518,78.082975));
        KSWOMENSHOSTEL.add(new LatLng(9.879373,78.082685));
        KSWOMENSHOSTEL.add(new LatLng(9.879288,78.082626));
        KSWOMENSHOSTEL.add(new LatLng(9.878910,78.082653));
        KSWOMENSHOSTEL.add(new LatLng(9.878479,78.082776));
        KSWOMENSHOSTEL.add(new LatLng(9.878434,78.082095));
        KSWOMENSHOSTEL.add(new LatLng(9.878201,78.082072));


        KSLIBRARY.add(new LatLng(9.882820,78.082337));
        KSLIBRARY.add(new LatLng(9.883227,78.081976));
        KSLIBRARY.add(new LatLng(9.883236,78.081264));
        KSLIBRARY.add(new LatLng(9.882854,78.081243));


        KSBANK.add(new LatLng(9.882820,78.082337));
        KSBANK.add(new LatLng(9.883227,78.081976));
        KSBANK.add(new LatLng(9.883262,78.080870));
        KSBANK.add(new LatLng(9.883286,78.080765));
        KSBANK.add(new LatLng(9.883458,78.080706));
        KSBANK.add(new LatLng(9.883496,78.079848));


        KSTEMPLE.add(new LatLng(9.882820,78.082337));
        KSTEMPLE.add(new LatLng(9.883227,78.081976));
        KSTEMPLE.add(new LatLng(9.883262,78.080870));
        KSTEMPLE.add(new LatLng(9.883286,78.080765));
        KSTEMPLE.add(new LatLng(9.883368,78.080711));
        KSTEMPLE.add(new LatLng(9.883896,78.080727));
        KSTEMPLE.add(new LatLng(9.884735,78.080781));
        KSTEMPLE.add(new LatLng(9.885035,78.080792));
        KSTEMPLE.add(new LatLng(9.885443,78.080804));
        KSTEMPLE.add(new LatLng(9.885459,78.080574));


        KSPARKING.add(new LatLng(9.882820,78.082337));
        KSPARKING.add(new LatLng(9.883227,78.081976));
        KSPARKING.add(new LatLng(9.883252,78.081003));
        KSPARKING.add(new LatLng(9.883106,78.080998));
        KSPARKING.add(new LatLng(9.882769,78.080846));

    }
    public void initScienceBlockCoordinates()
    {
        // Science Block
        SBMAINBUILDING.add(new LatLng(9.881876,78.083152));
        SBMAINBUILDING.add(new LatLng(9.881697,78.083028));
        SBMAINBUILDING.add(new LatLng(9.881943,78.083021));
        SBMAINBUILDING.add(new LatLng(9.882004,78.082337));
        SBMAINBUILDING.add(new LatLng(9.882322,78.082336));
        SBMAINBUILDING.add(new LatLng(9.882362,78.082437));
        SBMAINBUILDING.add(new LatLng(9.882744,78.082452));
        SBMAINBUILDING.add(new LatLng(9.882881,78.082511));

        SBIT.add(new LatLng(9.881876,78.083152));
        SBIT.add(new LatLng(9.881816,78.083021));
        SBIT.add(new LatLng(9.882160,78.083029));
        SBIT.add(new LatLng(9.882173,78.083195));
        SBIT.add(new LatLng(9.882178,78.083423));
        SBIT.add(new LatLng(9.882397,78.083426));
        SBIT.add(new LatLng(9.882397,78.083506));
        SBIT.add(new LatLng(9.882397,78.083569));
        SBIT.add(new LatLng(9.882399,78.083630));

        SBCSE.add(new LatLng(9.881876,78.083152));
        SBCSE.add(new LatLng(9.881816,78.083021));
        SBCSE.add(new LatLng(9.882160,78.083029));
        SBCSE.add(new LatLng(9.882173,78.083195));
        SBCSE.add(new LatLng(9.882178,78.083423));
        SBCSE.add(new LatLng(9.882397,78.083426));
        SBCSE.add(new LatLng(9.882893,78.083421));
        SBCSE.add(new LatLng(9.882884,78.083593));
        SBCSE.add(new LatLng(9.882896,78.083745));
        SBCSE.add(new LatLng(9.882797,78.083739));

        SBECE.add(new LatLng(9.881876,78.083152));
        SBECE.add(new LatLng(9.881816,78.083021));
        SBECE.add(new LatLng(9.882160,78.083029));
        SBECE.add(new LatLng(9.882171,78.083267));
        SBECE.add(new LatLng(9.882493,78.083267));
        SBECE.add(new LatLng(9.882691,78.083267));
        SBECE.add(new LatLng(9.882710,78.083130));
        SBECE.add(new LatLng(9.882731,78.082759));
        SBECE.add(new LatLng(9.882750,78.082536));
        SBECE.add(new LatLng(9.882820,78.082338));

        SBEEE.add(new LatLng(9.881876,78.083152));
        SBEEE.add(new LatLng(9.881912,78.083111));
        SBEEE.add(new LatLng(9.881912,78.082744));
        SBEEE.add(new LatLng(9.881912,78.082477));
        SBEEE.add(new LatLng(9.882066,78.082397));
        SBEEE.add(new LatLng(9.882238,78.082342));
        SBEEE.add(new LatLng(9.882341,78.082342));
        SBEEE.add(new LatLng(9.882341,78.082422));
        SBEEE.add(new LatLng(9.882464,78.082422));
        SBEEE.add(new LatLng(9.882464,78.082333));
        SBEEE.add(new LatLng(9.882464,78.082037));
        SBEEE.add(new LatLng(9.882436,78.082038));
        SBEEE.add(new LatLng(9.882433,78.082086));

        SBCIVIL.add(new LatLng(9.881876,78.083152));
        SBCIVIL.add(new LatLng(9.881816,78.083021));
        SBCIVIL.add(new LatLng(9.882160,78.083029));
        SBCIVIL.add(new LatLng(9.882173,78.083195));
        SBCIVIL.add(new LatLng(9.882173,78.083278));
        SBCIVIL.add(new LatLng(9.882324,78.083278));
        SBCIVIL.add(new LatLng(9.882324,78.083199));
        SBCIVIL.add(new LatLng(9.882324,78.082764));
        SBCIVIL.add(new LatLng(9.882278,78.082855));

        SBMECH.add(new LatLng(9.881876,78.083152));
        SBMECH.add(new LatLng(9.881980,78.083111));
        SBMECH.add(new LatLng(9.881980,78.083002));
        SBMECH.add(new LatLng(9.881980,78.082442));
        SBMECH.add(new LatLng(9.882207,78.082300));
        SBMECH.add(new LatLng(9.882321,78.081682));
        SBMECH.add(new LatLng(9.882399,78.081653));
        SBMECH.add(new LatLng(9.882452,78.081388));
        SBMECH.add(new LatLng(9.882707,78.081388));
        SBMECH.add(new LatLng(9.882707,78.081166));
        SBMECH.add(new LatLng(9.882365,78.081429));

        SBMECHT.add(new LatLng(9.881876,78.083152));
        SBMECHT.add(new LatLng(9.881980,78.083111));
        SBMECHT.add(new LatLng(9.881980,78.083002));
        SBMECHT.add(new LatLng(9.881980,78.082442));
        SBMECHT.add(new LatLng(9.882207,78.082300));
        SBMECHT.add(new LatLng(9.882321,78.081682));
        SBMECHT.add(new LatLng(9.882399,78.081653));
        SBMECHT.add(new LatLng(9.882452,78.081388));
        SBMECHT.add(new LatLng(9.882707,78.081388));
        SBMECHT.add(new LatLng(9.882707,78.081166));
        SBMECHT.add(new LatLng(9.882365,78.081428));

        SBARCH.add(new LatLng(9.881876,78.083152));
        SBARCH.add(new LatLng(9.881684,78.083002));
        SBARCH.add(new LatLng(9.882124,78.083002));
        SBARCH.add(new LatLng(9.882124,78.083251));
        SBARCH.add(new LatLng(9.882124,78.083426));
        SBARCH.add(new LatLng(9.881682,78.083426));
        SBARCH.add(new LatLng(9.881301,78.083517));
        SBARCH.add(new LatLng(9.880672,78.083442));
        SBARCH.add(new LatLng(9.880558,78.083080));
        SBARCH.add(new LatLng(9.880201,78.083158));
        SBARCH.add(new LatLng(9.878790,78.082110));

        SBFRESHERBLOCK.add(new LatLng(9.881876,78.083152));
        SBFRESHERBLOCK.add(new LatLng(9.881924,78.083109));
        SBFRESHERBLOCK.add(new LatLng(9.881924,78.082817 ));
        SBFRESHERBLOCK.add(new LatLng(9.88172,78.082617));

        SBNCCBLOCK.add(new LatLng(9.881876,78.083152));
        SBNCCBLOCK.add(new LatLng(9.881980,78.083111));
        SBNCCBLOCK.add(new LatLng(9.881980,78.083002));
        SBNCCBLOCK.add(new LatLng(9.881980,78.082442));
        SBNCCBLOCK.add(new LatLng(9.882207,78.082300));
        SBNCCBLOCK.add(new LatLng(9.882321,78.081682));
        SBNCCBLOCK.add(new LatLng(9.882399,78.081653));
        SBNCCBLOCK.add(new LatLng(9.883234,78.081681));
        SBNCCBLOCK.add(new LatLng(9.883262,78.080870));
        SBNCCBLOCK.add(new LatLng(9.883286,78.080765));
        SBNCCBLOCK.add(new LatLng(9.883458,78.080706));
        SBNCCBLOCK.add(new LatLng(9.883560,78.079803));

        SBINDOOR.add(new LatLng(9.881876,78.083152));
        SBINDOOR.add(new LatLng(9.881686,78.083034));
        SBINDOOR.add(new LatLng(9.882148,78.083023));
        SBINDOOR.add(new LatLng(9.882169,78.083412));
        SBINDOOR.add(new LatLng(9.881682,78.083426));
        SBINDOOR.add(new LatLng(9.881452,78.083488));
        SBINDOOR.add(new LatLng(9.881540,78.082662));
        SBINDOOR.add(new LatLng(9.880959,78.082606));
        SBINDOOR.add(new LatLng(9.880761,78.082324));
        SBINDOOR.add(new LatLng(9.880621,78.082225));
        SBINDOOR.add(new LatLng(9.879701,78.081978));
        SBINDOOR.add(new LatLng(9.879215,78.081785));
        SBINDOOR.add(new LatLng(9.878496,78.081654));
        SBINDOOR.add(new LatLng(9.877774,78.081405));
        SBINDOOR.add(new LatLng(9.877578,78.081330));
        SBINDOOR.add(new LatLng(9.877596,78.080995));
        SBINDOOR.add(new LatLng(9.882838,78.082683));

        SBOUTDOOR.add(new LatLng(9.881876,78.083152));
        SBOUTDOOR.add(new LatLng(9.881980,78.083111));
        SBOUTDOOR.add(new LatLng(9.881980,78.083002));
        SBOUTDOOR.add(new LatLng(9.881980,78.082442));
        SBOUTDOOR.add(new LatLng(9.882207,78.082300));
        SBOUTDOOR.add(new LatLng(9.882321,78.081682));
        SBOUTDOOR.add(new LatLng(9.882399,78.081653));
        SBOUTDOOR.add(new LatLng(9.883234,78.081681));
        SBOUTDOOR.add(new LatLng(9.883842,78.081407));

        SBKSAUDITORIUM.add(new LatLng(9.881876,78.083152));
        SBKSAUDITORIUM.add(new LatLng(9.881697,78.083028));
        SBKSAUDITORIUM.add(new LatLng(9.881943,78.083021));
        SBKSAUDITORIUM.add(new LatLng(9.882004,78.082337));
        SBKSAUDITORIUM.add(new LatLng(9.882322,78.082336));
        SBKSAUDITORIUM.add(new LatLng(9.882362,78.082437));
        SBKSAUDITORIUM.add(new LatLng(9.882744,78.082452));
        SBKSAUDITORIUM.add(new LatLng(9.882744,78.081976));
        SBKSAUDITORIUM.add(new LatLng(9.882820,78.082337));

        SBKMAUDITORIUM.add(new LatLng(9.881876,78.083152));
        SBKMAUDITORIUM.add(new LatLng(9.881697,78.083028));
        SBKMAUDITORIUM.add(new LatLng(9.881943,78.083021));
        SBKMAUDITORIUM.add(new LatLng(9.882004,78.082337));
        SBKMAUDITORIUM.add(new LatLng(9.882322,78.082336));
        SBKMAUDITORIUM.add(new LatLng(9.882362,78.082437));
        SBKMAUDITORIUM.add(new LatLng(9.882744,78.082452));
        SBKMAUDITORIUM.add(new LatLng(9.882744,78.082540));
        SBKMAUDITORIUM.add(new LatLng(9.882480,78.082541));

        SBPLACEMENTCELL.add(new LatLng(9.881876,78.083152));
        SBPLACEMENTCELL.add(new LatLng(9.881980,78.083111));
        SBPLACEMENTCELL.add(new LatLng(9.881980,78.083002));
        SBPLACEMENTCELL.add(new LatLng(9.881980,78.082442));
        SBPLACEMENTCELL.add(new LatLng(9.882207,78.082300));
        SBPLACEMENTCELL.add(new LatLng(9.882321,78.081682));
        SBPLACEMENTCELL.add(new LatLng(9.882399,78.081653));
        SBPLACEMENTCELL.add(new LatLng(9.883234,78.081681));
        SBPLACEMENTCELL.add(new LatLng(9.883262,78.080870));
        SBPLACEMENTCELL.add(new LatLng(9.883286,78.080765));
        SBPLACEMENTCELL.add(new LatLng(9.883368,78.080711));
        SBPLACEMENTCELL.add(new LatLng(9.883896,78.080727));
        SBPLACEMENTCELL.add(new LatLng(9.884735,78.080781));
        SBPLACEMENTCELL.add(new LatLng(9.885035,78.080792));
        SBPLACEMENTCELL.add(new LatLng(9.885026,78.080954));

        SBGUESTHOUSE.add(new LatLng(9.881876,78.083152));
        SBGUESTHOUSE.add(new LatLng(9.881980,78.083111));
        SBGUESTHOUSE.add(new LatLng(9.881980,78.083002));
        SBGUESTHOUSE.add(new LatLng(9.881980,78.082442));
        SBGUESTHOUSE.add(new LatLng(9.882207,78.082300));
        SBGUESTHOUSE.add(new LatLng(9.882321,78.081682));
        SBGUESTHOUSE.add(new LatLng(9.882399,78.081653));
        SBGUESTHOUSE.add(new LatLng(9.883234,78.081681));
        SBGUESTHOUSE.add(new LatLng(9.883262,78.080870));
        SBGUESTHOUSE.add(new LatLng(9.883286,78.080765));
        SBGUESTHOUSE.add(new LatLng(9.883368,78.080711));
        SBGUESTHOUSE.add(new LatLng(9.883896,78.080727));
        SBGUESTHOUSE.add(new LatLng(9.884735,78.080781));
        SBGUESTHOUSE.add(new LatLng(9.885035,78.080792));
        SBGUESTHOUSE.add(new LatLng(9.885210,78.080791));
        SBGUESTHOUSE.add(new LatLng(9.885211,78.080632));

        SBMAINCANTEEN.add(new LatLng(9.881876,78.083152));
        SBMAINCANTEEN.add(new LatLng(9.881980,78.083111));
        SBMAINCANTEEN.add(new LatLng(9.881980,78.083002));
        SBMAINCANTEEN.add(new LatLng(9.881980,78.082442));
        SBMAINCANTEEN.add(new LatLng(9.882207,78.082300));
        SBMAINCANTEEN.add(new LatLng(9.882321,78.081682));
        SBMAINCANTEEN.add(new LatLng(9.882399,78.081653));
        SBMAINCANTEEN.add(new LatLng(9.883234,78.081681));
        SBMAINCANTEEN.add(new LatLng(9.883262,78.080870));
        SBMAINCANTEEN.add(new LatLng(9.883286,78.080765));
        SBMAINCANTEEN.add(new LatLng(9.883277,78.080255));
        SBMAINCANTEEN.add(new LatLng(9.883264,78.079857));

        SBFOODCOURT.add(new LatLng(9.881876,78.083152));
        SBFOODCOURT.add(new LatLng(9.881816,78.083021));
        SBFOODCOURT.add(new LatLng(9.882160,78.083029));
        SBFOODCOURT.add(new LatLng(9.882173,78.083195));
        SBFOODCOURT.add(new LatLng(9.882178,78.083426));
        SBFOODCOURT.add(new LatLng(9.882982,78.083426));
        SBFOODCOURT.add(new LatLng(9.883168,78.083267));
        SBFOODCOURT.add(new LatLng(9.883198,78.083240));
        SBFOODCOURT.add(new LatLng(9.883282,78.083236));

        SBMENSHOSTEL.add(new LatLng(9.881876,78.083152));
        SBMENSHOSTEL.add(new LatLng(9.881980,78.083111));
        SBMENSHOSTEL.add(new LatLng(9.881980,78.083002));
        SBMENSHOSTEL.add(new LatLng(9.881980,78.082442));
        SBMENSHOSTEL.add(new LatLng(9.882207,78.082300));
        SBMENSHOSTEL.add(new LatLng(9.882321,78.081682));
        SBMENSHOSTEL.add(new LatLng(9.882399,78.081653));
        SBMENSHOSTEL.add(new LatLng(9.883234,78.081681));
        SBMENSHOSTEL.add(new LatLng(9.883262,78.080870));
        SBMENSHOSTEL.add(new LatLng(9.883286,78.080765));
        SBMENSHOSTEL.add(new LatLng(9.883368,78.080711));
        SBMENSHOSTEL.add(new LatLng(9.883896,78.080727));
        SBMENSHOSTEL.add(new LatLng(9.884735,78.080781));
        SBMENSHOSTEL.add(new LatLng(9.884765,78.080405));
        SBMENSHOSTEL.add(new LatLng(9.884738,78.080071));

        SBWOMENSHOSTEL.add(new LatLng(9.881876,78.083152));
        SBWOMENSHOSTEL.add(new LatLng(9.881686,78.083034));
        SBWOMENSHOSTEL.add(new LatLng(9.882148,78.083023));
        SBWOMENSHOSTEL.add(new LatLng(9.882169,78.083412));
        SBWOMENSHOSTEL.add(new LatLng(9.881682,78.083426));
        SBWOMENSHOSTEL.add(new LatLng(9.881301,78.083517));
        SBWOMENSHOSTEL.add(new LatLng(9.880672,78.083442));
        SBWOMENSHOSTEL.add(new LatLng(9.880375,78.083386));
        SBWOMENSHOSTEL.add(new LatLng(9.879979,78.083493));
        SBWOMENSHOSTEL.add(new LatLng(9.879832,78.083329));
        SBWOMENSHOSTEL.add(new LatLng(9.879632,78.083372));
        SBWOMENSHOSTEL.add(new LatLng(9.879518,78.082975));
        SBWOMENSHOSTEL.add(new LatLng(9.879373,78.082685));
        SBWOMENSHOSTEL.add(new LatLng(9.879288,78.082626));
        SBWOMENSHOSTEL.add(new LatLng(9.878910,78.082653));
        SBWOMENSHOSTEL.add(new LatLng(9.878479,78.082776));
        SBWOMENSHOSTEL.add(new LatLng(9.878434,78.082095));
        SBWOMENSHOSTEL.add(new LatLng(9.878201,78.082072));

        SBLIBRARY.add(new LatLng(9.881876,78.083152));
        SBLIBRARY.add(new LatLng(9.881980,78.083111));
        SBLIBRARY.add(new LatLng(9.881980,78.083002));
        SBLIBRARY.add(new LatLng(9.881980,78.082442));
        SBLIBRARY.add(new LatLng(9.882207,78.082300));
        SBLIBRARY.add(new LatLng(9.882321,78.081682));
        SBLIBRARY.add(new LatLng(9.882399,78.081653));
        SBLIBRARY.add(new LatLng(9.882982,78.081681));
        SBLIBRARY.add(new LatLng(9.882982,78.081445));
        SBLIBRARY.add(new LatLng(9.883105,78.081445));
        SBLIBRARY.add(new LatLng(9.882854,78.081243));

        SBBANK.add(new LatLng(9.881876,78.083152));
        SBBANK.add(new LatLng(9.881980,78.083111));
        SBBANK.add(new LatLng(9.881980,78.083002));
        SBBANK.add(new LatLng(9.881980,78.082442));
        SBBANK.add(new LatLng(9.882207,78.082300));
        SBBANK.add(new LatLng(9.882321,78.081682));
        SBBANK.add(new LatLng(9.882399,78.081653));
        SBBANK.add(new LatLng(9.883234,78.081681));
        SBBANK.add(new LatLng(9.883262,78.080870));
        SBBANK.add(new LatLng(9.883286,78.080765));
        SBBANK.add(new LatLng(9.883458,78.080706));
        SBBANK.add(new LatLng(9.883496,78.079848));

        SBTEMPLE.add(new LatLng(9.881876,78.083152));
        SBTEMPLE.add(new LatLng(9.881980,78.083111));
        SBTEMPLE.add(new LatLng(9.881980,78.083002));
        SBTEMPLE.add(new LatLng(9.881980,78.082442));
        SBTEMPLE.add(new LatLng(9.882207,78.082300));
        SBTEMPLE.add(new LatLng(9.882321,78.081682));
        SBTEMPLE.add(new LatLng(9.882399,78.081653));
        SBTEMPLE.add(new LatLng(9.883234,78.081681));
        SBTEMPLE.add(new LatLng(9.883262,78.080870));
        SBTEMPLE.add(new LatLng(9.883286,78.080765));
        SBTEMPLE.add(new LatLng(9.883368,78.080711));
        SBTEMPLE.add(new LatLng(9.883896,78.080727));
        SBTEMPLE.add(new LatLng(9.884735,78.080781));
        SBTEMPLE.add(new LatLng(9.885035,78.080792));
        SBTEMPLE.add(new LatLng(9.885443,78.080804));
        SBTEMPLE.add(new LatLng(9.885459,78.080574));

        SBPARKING.add(new LatLng(9.881876,78.083152));
        SBPARKING.add(new LatLng(9.881980,78.083111));
        SBPARKING.add(new LatLng(9.881980,78.083002));
        SBPARKING.add(new LatLng(9.881980,78.082442));
        SBPARKING.add(new LatLng(9.882207,78.082300));
        SBPARKING.add(new LatLng(9.882321,78.081682));
        SBPARKING.add(new LatLng(9.882399,78.081653));
        SBPARKING.add(new LatLng(9.883234,78.081681));
        SBPARKING.add(new LatLng(9.883252,78.081003));
        SBPARKING.add(new LatLng(9.883106,78.080998));
        SBPARKING.add(new LatLng(9.882769,78.080846));

    }
    public void initFreshersBlockCoordinates()
    {
        //Freshers Block

        FBMAINBUILDING.add(new LatLng(9.88172,78.082617));
        FBMAINBUILDING.add(new LatLng(9.882004,78.082817));
        FBMAINBUILDING.add(new LatLng(9.882004,78.082337));
        FBMAINBUILDING.add(new LatLng(9.882322,78.082336));
        FBMAINBUILDING.add(new LatLng(9.882362,78.082437));
        FBMAINBUILDING.add(new LatLng(9.882744,78.082452));
        FBMAINBUILDING.add(new LatLng(9.882881,78.082511));

        FBIT.add(new LatLng(9.88172,78.082617));
        FBIT.add(new LatLng(9.881946,78.082825));
        FBIT.add(new LatLng(9.881950,78.083021));
        FBIT.add(new LatLng(9.882160,78.083029));
        FBIT.add(new LatLng(9.882173,78.083195));
        FBIT.add(new LatLng(9.882178,78.083423));
        FBIT.add(new LatLng(9.882397,78.083426));
        FBIT.add(new LatLng(9.882397,78.083506));
        FBIT.add(new LatLng(9.882397,78.083569));
        FBIT.add(new LatLng(9.882399,78.083630));

        FBCSE.add(new LatLng(9.88172,78.082617));
        FBCSE.add(new LatLng(9.881946,78.082825));
        FBCSE.add(new LatLng(9.881950,78.083021));
        FBCSE.add(new LatLng(9.882160,78.083029));
        FBCSE.add(new LatLng(9.882173,78.083195));
        FBCSE.add(new LatLng(9.882178,78.083423));
        FBCSE.add(new LatLng(9.882397,78.083426));
        FBCSE.add(new LatLng(9.882893,78.083421));
        FBCSE.add(new LatLng(9.882884,78.083593));
        FBCSE.add(new LatLng(9.882896,78.083745));
        FBCSE.add(new LatLng(9.882797,78.083739));

        FBECE.add(new LatLng(9.88172,78.082617));
        FBECE.add(new LatLng(9.881946,78.082825));
        FBECE.add(new LatLng(9.881950,78.083021));
        FBECE.add(new LatLng(9.882160,78.083029));
        FBECE.add(new LatLng(9.882171,78.083267));
        FBECE.add(new LatLng(9.882493,78.083267));
        FBECE.add(new LatLng(9.882691,78.083267));
        FBECE.add(new LatLng(9.882710,78.083130));
        FBECE.add(new LatLng(9.882731,78.082759));
        FBECE.add(new LatLng(9.882750,78.082536));
        FBECE.add(new LatLng(9.882820,78.082338));

        FBEEE.add(new LatLng(9.88172,78.082617));
        FBEEE.add(new LatLng(9.881912,78.082817));
        FBEEE.add(new LatLng(9.881912,78.082477));
        FBEEE.add(new LatLng(9.882066,78.082397));
        FBEEE.add(new LatLng(9.882238,78.082342));
        FBEEE.add(new LatLng(9.882341,78.082342));
        FBEEE.add(new LatLng(9.882341,78.082422));
        FBEEE.add(new LatLng(9.882464,78.082422));
        FBEEE.add(new LatLng(9.882464,78.082333));
        FBEEE.add(new LatLng(9.882464,78.082037));
        FBEEE.add(new LatLng(9.882436,78.082038));
        FBEEE.add(new LatLng(9.882433,78.082086));

        FBCIVIL.add(new LatLng(9.88172,78.082617));
        FBCIVIL.add(new LatLng(9.881946,78.082825));
        FBCIVIL.add(new LatLng(9.881950,78.083021));
        FBCIVIL.add(new LatLng(9.882160,78.083029));
        FBCIVIL.add(new LatLng(9.882173,78.083195));
        FBCIVIL.add(new LatLng(9.882173,78.083278));
        FBCIVIL.add(new LatLng(9.882324,78.083278));
        FBCIVIL.add(new LatLng(9.882324,78.083199));
        FBCIVIL.add(new LatLng(9.882324,78.082764));
        FBCIVIL.add(new LatLng(9.882278,78.082855));

        FBMECH.add(new LatLng(9.88172,78.082617));
        FBMECH.add(new LatLng(9.881980,78.082817));
        FBMECH.add(new LatLng(9.881980,78.082442));
        FBMECH.add(new LatLng(9.882207,78.082300));
        FBMECH.add(new LatLng(9.882321,78.081682));
        FBMECH.add(new LatLng(9.882399,78.081653));
        FBMECH.add(new LatLng(9.882452,78.081388));
        FBMECH.add(new LatLng(9.882707,78.081388));
        FBMECH.add(new LatLng(9.882365,78.081429));

        FBMECHT.add(new LatLng(9.88172,78.082617));
        FBMECHT.add(new LatLng(9.881980,78.082817));
        FBMECHT.add(new LatLng(9.881980,78.082442));
        FBMECHT.add(new LatLng(9.882207,78.082300));
        FBMECHT.add(new LatLng(9.882321,78.081682));
        FBMECHT.add(new LatLng(9.882399,78.081653));
        FBMECHT.add(new LatLng(9.882452,78.081388));
        FBMECHT.add(new LatLng(9.882707,78.081388));
        FBMECHT.add(new LatLng(9.882365,78.081428));

        FBARCH.add(new LatLng(9.88172,78.082617));
        FBARCH.add(new LatLng(9.881936,78.082817));
        FBARCH.add(new LatLng(9.881936,78.083002));
        FBARCH.add(new LatLng(9.882124,78.083002));
        FBARCH.add(new LatLng(9.882124,78.083251));
        FBARCH.add(new LatLng(9.882124,78.083426));
        FBARCH.add(new LatLng(9.881682,78.083426));
        FBARCH.add(new LatLng(9.881301,78.083517));
        FBARCH.add(new LatLng(9.880672,78.083442));
        FBARCH.add(new LatLng(9.880558,78.083080));
        FBARCH.add(new LatLng(9.880201,78.083158));
        FBARCH.add(new LatLng(9.878790,78.082110));

        FBSCIENCEBLOCK.add(new LatLng(9.88172,78.082617));
        FBSCIENCEBLOCK.add(new LatLng(9.881924,78.082817));
        FBSCIENCEBLOCK.add(new LatLng(9.881924,78.083109));
        FBSCIENCEBLOCK.add(new LatLng(9.881876,78.083152));

        FBNCCBLOCK.add(new LatLng(9.88172,78.082617));
        FBNCCBLOCK.add(new LatLng(9.881980,78.082817));
        FBNCCBLOCK.add(new LatLng(9.881980,78.082442));
        FBNCCBLOCK.add(new LatLng(9.882207,78.082300));
        FBNCCBLOCK.add(new LatLng(9.882321,78.081682));
        FBNCCBLOCK.add(new LatLng(9.882399,78.081653));
        FBNCCBLOCK.add(new LatLng(9.883234,78.081681));
        FBNCCBLOCK.add(new LatLng(9.883262,78.080870));
        FBNCCBLOCK.add(new LatLng(9.883286,78.080765));
        FBNCCBLOCK.add(new LatLng(9.883458,78.080706));
        FBNCCBLOCK.add(new LatLng(9.883560,78.079803));

        FBINDOOR.add(new LatLng(9.88172,78.082617));
        FBINDOOR.add(new LatLng(9.881834,78.083032));
        FBINDOOR.add(new LatLng(9.882148,78.083023));
        FBINDOOR.add(new LatLng(9.882169,78.083412));
        FBINDOOR.add(new LatLng(9.881682,78.083426));
        FBINDOOR.add(new LatLng(9.881452,78.083488));
        FBINDOOR.add(new LatLng(9.881540,78.082662));
        FBINDOOR.add(new LatLng(9.880959,78.082606));
        FBINDOOR.add(new LatLng(9.880761,78.082324));
        FBINDOOR.add(new LatLng(9.880621,78.082225));
        FBINDOOR.add(new LatLng(9.879701,78.081978));
        FBINDOOR.add(new LatLng(9.879215,78.081785));
        FBINDOOR.add(new LatLng(9.878496,78.081654));
        FBINDOOR.add(new LatLng(9.877774,78.081405));
        FBINDOOR.add(new LatLng(9.877578,78.081330));
        FBINDOOR.add(new LatLng(9.877596,78.080995));
        FBINDOOR.add(new LatLng(9.882838,78.082683));

        FBOUTDOOR.add(new LatLng(9.88172,78.082617));
        FBOUTDOOR.add(new LatLng(9.881980,78.082817));
        FBOUTDOOR.add(new LatLng(9.881980,78.082442));
        FBOUTDOOR.add(new LatLng(9.882207,78.082300));
        FBOUTDOOR.add(new LatLng(9.882321,78.081682));
        FBOUTDOOR.add(new LatLng(9.882399,78.081653));
        FBOUTDOOR.add(new LatLng(9.883234,78.081681));
        FBOUTDOOR.add(new LatLng(9.883842,78.081407));

        FBKSAUDITORIUM.add(new LatLng(9.88172,78.082617));
        FBKSAUDITORIUM.add(new LatLng(9.881912,78.082817));
        FBKSAUDITORIUM.add(new LatLng(9.881912,78.082477));
        FBKSAUDITORIUM.add(new LatLng(9.882066,78.082397));
        FBKSAUDITORIUM.add(new LatLng(9.882238,78.082342));
        FBKSAUDITORIUM.add(new LatLng(9.882341,78.082342));
        FBKSAUDITORIUM.add(new LatLng(9.882341,78.082422));
        FBKSAUDITORIUM.add(new LatLng(9.882717,78.082435));
        FBKSAUDITORIUM.add(new LatLng(9.882791,78.081976));
        FBKSAUDITORIUM.add(new LatLng(9.882820,78.082337));

        FBKMAUDITORIUM.add(new LatLng(9.88172,78.082617));
        FBKMAUDITORIUM.add(new LatLng(9.881912,78.082817));
        FBKMAUDITORIUM.add(new LatLng(9.881912,78.082477));
        FBKMAUDITORIUM.add(new LatLng(9.882066,78.082397));
        FBKMAUDITORIUM.add(new LatLng(9.882238,78.082342));
        FBKMAUDITORIUM.add(new LatLng(9.882341,78.082342));
        FBKMAUDITORIUM.add(new LatLng(9.882341,78.082422));
        FBKMAUDITORIUM.add(new LatLng(9.882717,78.082435));
        FBKMAUDITORIUM.add(new LatLng(9.882717,78.082540));
        FBKMAUDITORIUM.add(new LatLng(9.882480,78.082541));

        FBPLACEMENTCELL.add(new LatLng(9.88172,78.082617));
        FBPLACEMENTCELL.add(new LatLng(9.881980,78.082817));
        FBPLACEMENTCELL.add(new LatLng(9.881980,78.082442));
        FBPLACEMENTCELL.add(new LatLng(9.882207,78.082300));
        FBPLACEMENTCELL.add(new LatLng(9.882321,78.081682));
        FBPLACEMENTCELL.add(new LatLng(9.882399,78.081653));
        FBPLACEMENTCELL.add(new LatLng(9.883234,78.081681));
        FBPLACEMENTCELL.add(new LatLng(9.883262,78.080870));
        FBPLACEMENTCELL.add(new LatLng(9.883286,78.080765));
        FBPLACEMENTCELL.add(new LatLng(9.883368,78.080711));
        FBPLACEMENTCELL.add(new LatLng(9.883896,78.080727));
        FBPLACEMENTCELL.add(new LatLng(9.884735,78.080781));
        FBPLACEMENTCELL.add(new LatLng(9.885035,78.080792));
        FBPLACEMENTCELL.add(new LatLng(9.885026,78.080954));

        FBGUESTHOUSE.add(new LatLng(9.88172,78.082617));
        FBGUESTHOUSE.add(new LatLng(9.881980,78.082817));
        FBGUESTHOUSE.add(new LatLng(9.881980,78.082442));
        FBGUESTHOUSE.add(new LatLng(9.882207,78.082300));
        FBGUESTHOUSE.add(new LatLng(9.882321,78.081682));
        FBGUESTHOUSE.add(new LatLng(9.882399,78.081653));
        FBGUESTHOUSE.add(new LatLng(9.883234,78.081681));
        FBGUESTHOUSE.add(new LatLng(9.883262,78.080870));
        FBGUESTHOUSE.add(new LatLng(9.883286,78.080765));
        FBGUESTHOUSE.add(new LatLng(9.883368,78.080711));
        FBGUESTHOUSE.add(new LatLng(9.883896,78.080727));
        FBGUESTHOUSE.add(new LatLng(9.884735,78.080781));
        FBGUESTHOUSE.add(new LatLng(9.885035,78.080792));
        FBGUESTHOUSE.add(new LatLng(9.885210,78.080791));
        FBGUESTHOUSE.add(new LatLng(9.885211,78.080632));

        FBMAINCANTEEN.add(new LatLng(9.88172,78.082617));
        FBMAINCANTEEN.add(new LatLng(9.881980,78.082817));
        FBMAINCANTEEN.add(new LatLng(9.881980,78.082442));
        FBMAINCANTEEN.add(new LatLng(9.882207,78.082300));
        FBMAINCANTEEN.add(new LatLng(9.882321,78.081682));
        FBMAINCANTEEN.add(new LatLng(9.882399,78.081653));
        FBMAINCANTEEN.add(new LatLng(9.883234,78.081681));
        FBMAINCANTEEN.add(new LatLng(9.883262,78.080870));
        FBMAINCANTEEN.add(new LatLng(9.883286,78.080765));
        FBMAINCANTEEN.add(new LatLng(9.883277,78.080255));
        FBMAINCANTEEN.add(new LatLng(9.883264,78.079857));

        FBFOODCOURT.add(new LatLng(9.88172,78.082617));
        FBFOODCOURT.add(new LatLng(9.881946,78.082825));
        FBFOODCOURT.add(new LatLng(9.881950,78.083021));
        FBFOODCOURT.add(new LatLng(9.882160,78.083029));
        FBFOODCOURT.add(new LatLng(9.882173,78.083195));
        FBFOODCOURT.add(new LatLng(9.882178,78.083426));
        FBFOODCOURT.add(new LatLng(9.882982,78.083426));
        FBFOODCOURT.add(new LatLng(9.883168,78.083267));
        FBFOODCOURT.add(new LatLng(9.883198,78.083240));
        FBFOODCOURT.add(new LatLng(9.883282,78.083236));

        FBMENSHOSTEL.add(new LatLng(9.88172,78.082617));
        FBMENSHOSTEL.add(new LatLng(9.881980,78.082817));
        FBMENSHOSTEL.add(new LatLng(9.881980,78.082442));
        FBMENSHOSTEL.add(new LatLng(9.882207,78.082300));
        FBMENSHOSTEL.add(new LatLng(9.882321,78.081682));
        FBMENSHOSTEL.add(new LatLng(9.882399,78.081653));
        FBMENSHOSTEL.add(new LatLng(9.883234,78.081681));
        FBMENSHOSTEL.add(new LatLng(9.883262,78.080870));
        FBMENSHOSTEL.add(new LatLng(9.883286,78.080765));
        FBMENSHOSTEL.add(new LatLng(9.883368,78.080711));
        FBMENSHOSTEL.add(new LatLng(9.883896,78.080727));
        FBMENSHOSTEL.add(new LatLng(9.884735,78.080781));
        FBMENSHOSTEL.add(new LatLng(9.884765,78.080405));
        FBMENSHOSTEL.add(new LatLng(9.884738,78.080071));

        FBWOMENSHOSTEL.add(new LatLng(9.88172,78.082617));
        FBWOMENSHOSTEL.add(new LatLng(9.881834,78.083032));
        FBWOMENSHOSTEL.add(new LatLng(9.882148,78.083023));
        FBWOMENSHOSTEL.add(new LatLng(9.882169,78.083412));
        FBWOMENSHOSTEL.add(new LatLng(9.881682,78.083426));
        FBWOMENSHOSTEL.add(new LatLng(9.881301,78.083517));
        FBWOMENSHOSTEL.add(new LatLng(9.880672,78.083442));
        FBWOMENSHOSTEL.add(new LatLng(9.880375,78.083386));
        FBWOMENSHOSTEL.add(new LatLng(9.879979,78.083493));
        FBWOMENSHOSTEL.add(new LatLng(9.879832,78.083329));
        FBWOMENSHOSTEL.add(new LatLng(9.879632,78.083372));
        FBWOMENSHOSTEL.add(new LatLng(9.879518,78.082975));
        FBWOMENSHOSTEL.add(new LatLng(9.879373,78.082685));
        FBWOMENSHOSTEL.add(new LatLng(9.879288,78.082626));
        FBWOMENSHOSTEL.add(new LatLng(9.878910,78.082653));
        FBWOMENSHOSTEL.add(new LatLng(9.878479,78.082776));
        FBWOMENSHOSTEL.add(new LatLng(9.878434,78.082095));
        FBWOMENSHOSTEL.add(new LatLng(9.878201,78.082072));

        FBLIBRARY.add(new LatLng(9.88172,78.082617));
        FBLIBRARY.add(new LatLng(9.881980,78.082817));
        FBLIBRARY.add(new LatLng(9.881980,78.082442));
        FBLIBRARY.add(new LatLng(9.882207,78.082300));
        FBLIBRARY.add(new LatLng(9.882321,78.081682));
        FBLIBRARY.add(new LatLng(9.882399,78.081653));
        FBLIBRARY.add(new LatLng(9.882982,78.081445));
        FBLIBRARY.add(new LatLng(9.883105,78.081445));
        FBLIBRARY.add(new LatLng(9.882854,78.081243));

        FBBANK.add(new LatLng(9.88172,78.082617));
        FBBANK.add(new LatLng(9.881980,78.082817));
        FBBANK.add(new LatLng(9.881980,78.082442));
        FBBANK.add(new LatLng(9.882207,78.082300));
        FBBANK.add(new LatLng(9.882321,78.081682));
        FBBANK.add(new LatLng(9.882399,78.081653));
        FBBANK.add(new LatLng(9.883234,78.081681));
        FBBANK.add(new LatLng(9.883262,78.080870));
        FBBANK.add(new LatLng(9.883286,78.080765));
        FBBANK.add(new LatLng(9.883458,78.080706));
        FBBANK.add(new LatLng(9.883496,78.079848));

        FBTEMPLE.add(new LatLng(9.88172,78.082617));
        FBTEMPLE.add(new LatLng(9.881980,78.082817));
        FBTEMPLE.add(new LatLng(9.881980,78.082442));
        FBTEMPLE.add(new LatLng(9.882207,78.082300));
        FBTEMPLE.add(new LatLng(9.882321,78.081682));
        FBTEMPLE.add(new LatLng(9.882399,78.081653));
        FBTEMPLE.add(new LatLng(9.883234,78.081681));
        FBTEMPLE.add(new LatLng(9.883262,78.080870));
        FBTEMPLE.add(new LatLng(9.883286,78.080765));
        FBTEMPLE.add(new LatLng(9.883368,78.080711));
        FBTEMPLE.add(new LatLng(9.883896,78.080727));
        FBTEMPLE.add(new LatLng(9.884735,78.080781));
        FBTEMPLE.add(new LatLng(9.885035,78.080792));
        FBTEMPLE.add(new LatLng(9.885443,78.080804));
        FBTEMPLE.add(new LatLng(9.885459,78.080574));

        FBPARKING.add(new LatLng(9.88172,78.082617));
        FBPARKING.add(new LatLng(9.881980,78.082817));
        FBPARKING.add(new LatLng(9.881980,78.082442));
        FBPARKING.add(new LatLng(9.882207,78.082300));
        FBPARKING.add(new LatLng(9.882321,78.081682));
        FBPARKING.add(new LatLng(9.882399,78.081653));
        FBPARKING.add(new LatLng(9.883234,78.081681));
        FBPARKING.add(new LatLng(9.883234,78.081681));
        FBPARKING.add(new LatLng(9.883252,78.081003));
        FBPARKING.add(new LatLng(9.883106,78.080998));
        FBPARKING.add(new LatLng(9.882769,78.080846));

    }
    public void initNCCBlockCoordinates()
    {
        //NCC Block
        NCCBMAINBUILDING.add(new LatLng(9.883560,78.079803));
        NCCBMAINBUILDING.add(new LatLng(9.883458,78.080706));
        NCCBMAINBUILDING.add(new LatLng(9.883286,78.080765));
        NCCBMAINBUILDING.add(new LatLng(9.883262,78.080870));
        NCCBMAINBUILDING.add(new LatLng(9.883236,78.081833));
        NCCBMAINBUILDING.add(new LatLng(9.883225,78.082341));
        NCCBMAINBUILDING.add(new LatLng(9.883225,78.082530));
        NCCBMAINBUILDING.add(new LatLng(9.882881,78.082511));



        NCCBIT.add(new LatLng(9.883560,78.079803));
        NCCBIT.add(new LatLng(9.883458,78.080706));
        NCCBIT.add(new LatLng(9.883286,78.080765));
        NCCBIT.add(new LatLng(9.883262,78.080870));
        NCCBIT.add(new LatLng(9.883236,78.081833));
        NCCBIT.add(new LatLng(9.883211,78.082630));
        NCCBIT.add(new LatLng(9.883168,78.083267));
        NCCBIT.add(new LatLng(9.882982,78.083423));
        NCCBIT.add(new LatLng(9.882397,78.083426));
        NCCBIT.add(new LatLng(9.882397,78.083506));
        NCCBIT.add(new LatLng(9.882397,78.083569));
        NCCBIT.add(new LatLng(9.882399,78.083630));



        NCCBCSE.add(new LatLng(9.883560,78.079803));
        NCCBCSE.add(new LatLng(9.883458,78.080706));
        NCCBCSE.add(new LatLng(9.883286,78.080765));
        NCCBCSE.add(new LatLng(9.883262,78.080870));
        NCCBCSE.add(new LatLng(9.883236,78.081833));
        NCCBCSE.add(new LatLng(9.883211,78.082630));
        NCCBCSE.add(new LatLng(9.883168,78.083267));
        NCCBCSE.add(new LatLng(9.882982,78.083423));
        NCCBCSE.add(new LatLng(9.882893,78.083421));
        NCCBCSE.add(new LatLng(9.882884,78.083593));
        NCCBCSE.add(new LatLng(9.882896,78.083745));
        NCCBCSE.add(new LatLng(9.882797,78.083739));



        NCCBECE.add(new LatLng(9.883560,78.079803));
        NCCBECE.add(new LatLng(9.883458,78.080706));
        NCCBECE.add(new LatLng(9.883286,78.080765));
        NCCBECE.add(new LatLng(9.883262,78.080870));
        NCCBECE.add(new LatLng(9.883236,78.081833));
        NCCBECE.add(new LatLng(9.883225,78.082341));
        NCCBECE.add(new LatLng(9.883016,78.082341));
        NCCBECE.add(new LatLng(9.882820,78.082338));



        NCCBEEE.add(new LatLng(9.883560,78.079803));
        NCCBEEE.add(new LatLng(9.883458,78.080706));
        NCCBEEE.add(new LatLng(9.883286,78.080765));
        NCCBEEE.add(new LatLng(9.883262,78.080870));
        NCCBEEE.add(new LatLng(9.883225,78.081854));
        NCCBEEE.add(new LatLng(9.882816,78.081854));
        NCCBEEE.add(new LatLng(9.882466,78.081854));
        NCCBEEE.add(new LatLng(9.882466,78.082038));
        NCCBEEE.add(new LatLng(9.882433,78.082086));



        NCCBCIVIL.add(new LatLng(9.883560,78.079803));
        NCCBCIVIL.add(new LatLng(9.883458,78.080706));
        NCCBCIVIL.add(new LatLng(9.883286,78.080765));
        NCCBCIVIL.add(new LatLng(9.883262,78.080870));
        NCCBCIVIL.add(new LatLng(9.883225,78.081854));
        NCCBCIVIL.add(new LatLng(9.882816,78.081854));
        NCCBCIVIL.add(new LatLng(9.882466,78.081854));
        NCCBCIVIL.add(new LatLng(9.882464,78.082037));
        NCCBCIVIL.add(new LatLng(9.882464,78.082333));
        NCCBCIVIL.add(new LatLng(9.882464,78.082422));
        NCCBCIVIL.add(new LatLng(9.882341,78.082422));
        NCCBCIVIL.add(new LatLng(9.882341,78.082764));
        NCCBCIVIL.add(new LatLng(9.882278,78.082855));



        NCCBMECH.add(new LatLng(9.883560,78.079803));
        NCCBMECH.add(new LatLng(9.883458,78.080706));
        NCCBMECH.add(new LatLng(9.883286,78.080765));
        NCCBMECH.add(new LatLng(9.883262,78.080870));
        NCCBMECH.add(new LatLng(9.883234,78.081681));
        NCCBMECH.add(new LatLng(9.882949,78.081681));
        NCCBMECH.add(new LatLng(9.882707,78.081253));
        NCCBMECH.add(new LatLng(9.882365,78.081429));



        NCCBMECHT.add(new LatLng(9.883560,78.079803));
        NCCBMECHT.add(new LatLng(9.883458,78.080706));
        NCCBMECHT.add(new LatLng(9.883286,78.080765));
        NCCBMECHT.add(new LatLng(9.883262,78.080870));
        NCCBMECHT.add(new LatLng(9.883234,78.081681));
        NCCBMECHT.add(new LatLng(9.882949,78.081681));
        NCCBMECHT.add(new LatLng(9.882707,78.081253));
        NCCBMECHT.add(new LatLng(9.882365,78.081428));



        NCCBARCH.add(new LatLng(9.883560,78.079803));
        NCCBARCH.add(new LatLng(9.883458,78.080706));
        NCCBARCH.add(new LatLng(9.883286,78.080765));
        NCCBARCH.add(new LatLng(9.883262,78.080870));
        NCCBARCH.add(new LatLng(9.883236,78.081653));
        NCCBARCH.add(new LatLng(9.882771,78.081653));
        NCCBARCH.add(new LatLng(9.882399,78.081653));
        NCCBARCH.add(new LatLng(9.882321,78.081682));
        NCCBARCH.add(new LatLng(9.882207,78.082300));
        NCCBARCH.add(new LatLng(9.881980,78.082442));
        NCCBARCH.add(new LatLng(9.881980,78.083002));
        NCCBARCH.add(new LatLng(9.882124,78.083002));
        NCCBARCH.add(new LatLng(9.882124,78.083251));
        NCCBARCH.add(new LatLng(9.882124,78.083426));
        NCCBARCH.add(new LatLng(9.881682,78.083426));
        NCCBARCH.add(new LatLng(9.881301,78.083517));
        NCCBARCH.add(new LatLng(9.880672,78.083442));
        NCCBARCH.add(new LatLng(9.880558,78.083080));
        NCCBARCH.add(new LatLng(9.880201,78.083158));
        NCCBARCH.add(new LatLng(9.878790,78.082110));



        NCCBSCIENCEBLOCK.add(new LatLng(9.883560,78.079803));
        NCCBSCIENCEBLOCK.add(new LatLng(9.883458,78.080706));
        NCCBSCIENCEBLOCK.add(new LatLng(9.883286,78.080765));
        NCCBSCIENCEBLOCK.add(new LatLng(9.883262,78.080870));
        NCCBSCIENCEBLOCK.add(new LatLng(9.883234,78.081681));
        NCCBSCIENCEBLOCK.add(new LatLng(9.882399,78.081653));
        NCCBSCIENCEBLOCK.add(new LatLng(9.882321,78.081682));
        NCCBSCIENCEBLOCK.add(new LatLng(9.882207,78.082300));
        NCCBSCIENCEBLOCK.add(new LatLng(9.881980,78.082442));
        NCCBSCIENCEBLOCK.add(new LatLng(9.881980,78.083002));
        NCCBSCIENCEBLOCK.add(new LatLng(9.881980,78.083111));
        NCCBSCIENCEBLOCK.add(new LatLng(9.881876,78.083152));

        NCCBFRESHERBLOCK.add(new LatLng(9.883560,78.079803));
        NCCBFRESHERBLOCK.add(new LatLng(9.883458,78.080706));
        NCCBFRESHERBLOCK.add(new LatLng(9.883286,78.080765));
        NCCBFRESHERBLOCK.add(new LatLng(9.883262,78.080870));
        NCCBFRESHERBLOCK.add(new LatLng(9.883234,78.081681));
        NCCBFRESHERBLOCK.add(new LatLng(9.882399,78.081653));
        NCCBFRESHERBLOCK.add(new LatLng(9.882321,78.081682));
        NCCBFRESHERBLOCK.add(new LatLng(9.882207,78.082300));
        NCCBFRESHERBLOCK.add(new LatLng(9.881980,78.082442));
        NCCBFRESHERBLOCK.add(new LatLng(9.881980,78.082817));
        NCCBFRESHERBLOCK.add(new LatLng(9.88172,78.082617));

        NCCBINDOOR.add(new LatLng(9.883560,78.079803));
        NCCBINDOOR.add(new LatLng(9.883458,78.080706));
        NCCBINDOOR.add(new LatLng(9.883286,78.080765));
        NCCBINDOOR.add(new LatLng(9.883262,78.080870));
        NCCBINDOOR.add(new LatLng(9.883234,78.081681));
        NCCBINDOOR.add(new LatLng(9.882399,78.081653));
        NCCBINDOOR.add(new LatLng(9.882321,78.081682));
        NCCBINDOOR.add(new LatLng(9.882207,78.082300));
        NCCBINDOOR.add(new LatLng(9.881980,78.082442));
        NCCBINDOOR.add(new LatLng(9.881980,78.083002));
        NCCBINDOOR.add(new LatLng(9.882124,78.083002));
        NCCBINDOOR.add(new LatLng(9.882124,78.083251));
        NCCBINDOOR.add(new LatLng(9.882124,78.083426));
        NCCBINDOOR.add(new LatLng(9.881682,78.083426));
        NCCBINDOOR.add(new LatLng(9.881452,78.083488));
        NCCBINDOOR.add(new LatLng(9.881540,78.082662));
        NCCBINDOOR.add(new LatLng(9.880959,78.082606));
        NCCBINDOOR.add(new LatLng(9.880761,78.082324));
        NCCBINDOOR.add(new LatLng(9.880621,78.082225));
        NCCBINDOOR.add(new LatLng(9.879701,78.081978));
        NCCBINDOOR.add(new LatLng(9.879215,78.081785));
        NCCBINDOOR.add(new LatLng(9.878496,78.081654));
        NCCBINDOOR.add(new LatLng(9.877774,78.081405));
        NCCBINDOOR.add(new LatLng(9.877578,78.081330));
        NCCBINDOOR.add(new LatLng(9.877596,78.080995));
        NCCBINDOOR.add(new LatLng(9.882838,78.082683));

        NCCBOUTDOOR.add(new LatLng(9.883560,78.079803));
        NCCBOUTDOOR.add(new LatLng(9.883458,78.080706));
        NCCBOUTDOOR.add(new LatLng(9.883286,78.080765));
        NCCBOUTDOOR.add(new LatLng(9.883262,78.080870));
        NCCBOUTDOOR.add(new LatLng(9.883262,78.081539));
        NCCBOUTDOOR.add(new LatLng(9.883842,78.081407));

        NCCBKSAUDITORIUM.add(new LatLng(9.883560,78.079803));
        NCCBKSAUDITORIUM.add(new LatLng(9.883458,78.080706));
        NCCBKSAUDITORIUM.add(new LatLng(9.883286,78.080765));
        NCCBKSAUDITORIUM.add(new LatLng(9.883262,78.080870));
        NCCBKSAUDITORIUM.add(new LatLng(9.883234,78.081681));
        NCCBKSAUDITORIUM.add(new LatLng(9.883234,78.081976));
        NCCBKSAUDITORIUM.add(new LatLng(9.882820,78.082337));

        NCCBKMAUDITORIUM.add(new LatLng(9.883560,78.079803));
        NCCBKMAUDITORIUM.add(new LatLng(9.883458,78.080706));
        NCCBKMAUDITORIUM.add(new LatLng(9.883286,78.080765));
        NCCBKMAUDITORIUM.add(new LatLng(9.883262,78.080870));
        NCCBKMAUDITORIUM.add(new LatLng(9.883234,78.081681));
        NCCBKMAUDITORIUM.add(new LatLng(9.883234,78.082540));
        NCCBKMAUDITORIUM.add(new LatLng(9.882480,78.082541));

        NCCBPLACEMENTCELL.add(new LatLng(9.883560,78.079803));
        NCCBPLACEMENTCELL.add(new LatLng(9.883483,78.080696));
        NCCBPLACEMENTCELL.add(new LatLng(9.883896,78.080727));
        NCCBPLACEMENTCELL.add(new LatLng(9.884735,78.080781));
        NCCBPLACEMENTCELL.add(new LatLng(9.885035,78.080792));
        NCCBPLACEMENTCELL.add(new LatLng(9.885033,78.080967));

        NCCBGUESTHOUSE.add(new LatLng(9.883560,78.079803));
        NCCBGUESTHOUSE.add(new LatLng(9.883483,78.080696));
        NCCBGUESTHOUSE.add(new LatLng(9.883896,78.080727));
        NCCBGUESTHOUSE.add(new LatLng(9.884735,78.080781));
        NCCBGUESTHOUSE.add(new LatLng(9.885035,78.080792));
        NCCBGUESTHOUSE.add(new LatLng(9.885210,78.080791));
        NCCBGUESTHOUSE.add(new LatLng(9.885211,78.080632));

        NCCBMAINCANTEEN.add(new LatLng(9.883560,78.079803));
        NCCBMAINCANTEEN.add(new LatLng(9.883483,78.080020));
        NCCBMAINCANTEEN.add(new LatLng(9.883294,78.080024));
        NCCBMAINCANTEEN.add(new LatLng(9.883264,78.079857));

        NCCBFOODCOURT.add(new LatLng(9.883560,78.079803));
        NCCBFOODCOURT.add(new LatLng(9.883458,78.080706));
        NCCBFOODCOURT.add(new LatLng(9.883286,78.080765));
        NCCBFOODCOURT.add(new LatLng(9.883262,78.080870));
        NCCBFOODCOURT.add(new LatLng(9.883234,78.081681));
        NCCBFOODCOURT.add(new LatLng(9.883234,78.082540));
        NCCBFOODCOURT.add(new LatLng(9.883234,78.083246));
        NCCBFOODCOURT.add(new LatLng(9.883282,78.083236));

        NCCBMENSHOSTEL.add(new LatLng(9.883560,78.079803));
        NCCBMENSHOSTEL.add(new LatLng(9.883483,78.080696));
        NCCBMENSHOSTEL.add(new LatLng(9.883896,78.080727));
        NCCBMENSHOSTEL.add(new LatLng(9.884735,78.080781));
        NCCBMENSHOSTEL.add(new LatLng(9.884765,78.080405));
        NCCBMENSHOSTEL.add(new LatLng(9.884738,78.080071));

        NCCBWOMENSHOSTEL.add(new LatLng(9.883560,78.079803));
        NCCBWOMENSHOSTEL.add(new LatLng(9.883458,78.080706));
        NCCBWOMENSHOSTEL.add(new LatLng(9.883286,78.080765));
        NCCBWOMENSHOSTEL.add(new LatLng(9.883262,78.080870));
        NCCBWOMENSHOSTEL.add(new LatLng(9.883234,78.081681));
        NCCBWOMENSHOSTEL.add(new LatLng(9.882399,78.081653));
        NCCBWOMENSHOSTEL.add(new LatLng(9.882321,78.081682));
        NCCBWOMENSHOSTEL.add(new LatLng(9.882207,78.082300));
        NCCBWOMENSHOSTEL.add(new LatLng(9.881980,78.082442));
        NCCBWOMENSHOSTEL.add(new LatLng(9.881980,78.083002));
        NCCBWOMENSHOSTEL.add(new LatLng(9.882124,78.083002));
        NCCBWOMENSHOSTEL.add(new LatLng(9.882124,78.083251));
        NCCBWOMENSHOSTEL.add(new LatLng(9.882124,78.083426));
        NCCBWOMENSHOSTEL.add(new LatLng(9.881682,78.083426));
        NCCBWOMENSHOSTEL.add(new LatLng(9.881301,78.083517));
        NCCBWOMENSHOSTEL.add(new LatLng(9.880672,78.083442));
        NCCBWOMENSHOSTEL.add(new LatLng(9.880375,78.083386));
        NCCBWOMENSHOSTEL.add(new LatLng(9.879979,78.083493));
        NCCBWOMENSHOSTEL.add(new LatLng(9.879832,78.083329));
        NCCBWOMENSHOSTEL.add(new LatLng(9.879632,78.083372));
        NCCBWOMENSHOSTEL.add(new LatLng(9.879518,78.082975));
        NCCBWOMENSHOSTEL.add(new LatLng(9.879373,78.082685));
        NCCBWOMENSHOSTEL.add(new LatLng(9.879288,78.082626));
        NCCBWOMENSHOSTEL.add(new LatLng(9.878910,78.082653));
        NCCBWOMENSHOSTEL.add(new LatLng(9.878479,78.082776));
        NCCBWOMENSHOSTEL.add(new LatLng(9.878434,78.082095));
        NCCBWOMENSHOSTEL.add(new LatLng(9.878201,78.082072));

        NCCBLIBRARY.add(new LatLng(9.883560,78.079803));
        NCCBLIBRARY.add(new LatLng(9.883458,78.080706));
        NCCBLIBRARY.add(new LatLng(9.883286,78.080765));
        NCCBLIBRARY.add(new LatLng(9.883262,78.080870));
        NCCBLIBRARY.add(new LatLng(9.883262,78.081264));
        NCCBLIBRARY.add(new LatLng(9.882854,78.081243));

        NCCBBANK.add(new LatLng(9.883560,78.079803));
        NCCBBANK.add(new LatLng(9.883496,78.079848));

        NCCBTEMPLE.add(new LatLng(9.883560,78.079803));
        NCCBTEMPLE.add(new LatLng(9.883458,78.080706));
        NCCBTEMPLE.add(new LatLng(9.883896,78.080727));
        NCCBTEMPLE.add(new LatLng(9.884735,78.080781));
        NCCBTEMPLE.add(new LatLng(9.885035,78.080792));
        NCCBTEMPLE.add(new LatLng(9.885443,78.080804));
        NCCBTEMPLE.add(new LatLng(9.885459,78.080574));

        NCCBPARKING.add(new LatLng(9.883560,78.079803));
        NCCBPARKING.add(new LatLng(9.883458,78.080706));
        NCCBPARKING.add(new LatLng(9.883250,78.080715));
        NCCBPARKING.add(new LatLng(9.882416,78.080715));
        NCCBPARKING.add(new LatLng(9.882416,78.080942));
        NCCBPARKING.add(new LatLng(9.882769,78.080846));

    }
    public void initIndoorCoordinates()
    {
        //Indoor
        //INMAINBUILDING.add(new LatLng(9.877326,78.080994));
        INMAINBUILDING.add(new LatLng(9.877596,78.080995));
        INMAINBUILDING.add(new LatLng(9.877578,78.081330));
        INMAINBUILDING.add(new LatLng(9.877774,78.081405));
        INMAINBUILDING.add(new LatLng(9.878496,78.081654));
        INMAINBUILDING.add(new LatLng(9.879215,78.081785));
        INMAINBUILDING.add(new LatLng(9.879701,78.081978));
        INMAINBUILDING.add(new LatLng(9.880621,78.082225));
        INMAINBUILDING.add(new LatLng(9.880761,78.082324));
        INMAINBUILDING.add(new LatLng(9.880959,78.082606));
        INMAINBUILDING.add(new LatLng(9.881540,78.082662));
        INMAINBUILDING.add(new LatLng(9.881452,78.083488));
        INMAINBUILDING.add(new LatLng(9.881682,78.083426));
        INMAINBUILDING.add(new LatLng(9.882692,78.083426));
        INMAINBUILDING.add(new LatLng(9.882710,78.083130));
        INMAINBUILDING.add(new LatLng(9.882731,78.082759));
        INMAINBUILDING.add(new LatLng(9.882750,78.082536));
        INMAINBUILDING.add(new LatLng(9.882829,78.082341));
        INMAINBUILDING.add(new LatLng(9.882881,78.082511));

        //INIT.add(new LatLng(9.877326,78.080994));
        INIT.add(new LatLng(9.877596,78.080995));
        INIT.add(new LatLng(9.877578,78.081330));
        INIT.add(new LatLng(9.877774,78.081405));
        INIT.add(new LatLng(9.878496,78.081654));
        INIT.add(new LatLng(9.879215,78.081785));
        INIT.add(new LatLng(9.879701,78.081978));
        INIT.add(new LatLng(9.880621,78.082225));
        INIT.add(new LatLng(9.880761,78.082324));
        INIT.add(new LatLng(9.880959,78.082606));
        INIT.add(new LatLng(9.881540,78.082662));
        INIT.add(new LatLng(9.881452,78.083488));
        INIT.add(new LatLng(9.881682,78.083426));
        INIT.add(new LatLng(9.882397,78.083426));
        INIT.add(new LatLng(9.882397,78.083506));
        INIT.add(new LatLng(9.882397,78.083569));
        INIT.add(new LatLng(9.882399,78.083630));

        //INCSE.add(new LatLng(9.877326,78.080994));
        INCSE.add(new LatLng(9.877596,78.080995));
        INCSE.add(new LatLng(9.877578,78.081330));
        INCSE.add(new LatLng(9.877774,78.081405));
        INCSE.add(new LatLng(9.878496,78.081654));
        INCSE.add(new LatLng(9.879215,78.081785));
        INCSE.add(new LatLng(9.879701,78.081978));
        INCSE.add(new LatLng(9.880621,78.082225));
        INCSE.add(new LatLng(9.880761,78.082324));
        INCSE.add(new LatLng(9.880959,78.082606));
        INCSE.add(new LatLng(9.881540,78.082662));
        INCSE.add(new LatLng(9.881452,78.083488));
        INCSE.add(new LatLng(9.881682,78.083426));
        INCSE.add(new LatLng(9.882397,78.083426));
        INCSE.add(new LatLng(9.882893,78.083421));
        INCSE.add(new LatLng(9.882884,78.083593));
        INCSE.add(new LatLng(9.882896,78.083745));
        INCSE.add(new LatLng(9.882797,78.083739));

        //INECE.add(new LatLng(9.877326,78.080994));
        INECE.add(new LatLng(9.877596,78.080995));
        INECE.add(new LatLng(9.877578,78.081330));
        INECE.add(new LatLng(9.877774,78.081405));
        INECE.add(new LatLng(9.878496,78.081654));
        INECE.add(new LatLng(9.879215,78.081785));
        INECE.add(new LatLng(9.879701,78.081978));
        INECE.add(new LatLng(9.880621,78.082225));
        INECE.add(new LatLng(9.880761,78.082324));
        INECE.add(new LatLng(9.880959,78.082606));
        INECE.add(new LatLng(9.881540,78.082662));
        INECE.add(new LatLng(9.881452,78.083488));
        INECE.add(new LatLng(9.881682,78.083426));
        INECE.add(new LatLng(9.882208,78.083411));
        INECE.add(new LatLng(9.882319,78.083360));
        INECE.add(new LatLng(9.882398,78.083309));
        INECE.add(new LatLng(9.882554,78.083288));
        INECE.add(new LatLng(9.882691,78.083267));
        INECE.add(new LatLng(9.882710,78.083130));
        INECE.add(new LatLng(9.882731,78.082759));
        INECE.add(new LatLng(9.882750,78.082536));
        INECE.add(new LatLng(9.882820,78.082338));

        //INEEE.add(new LatLng(9.877326,78.080994));
        INEEE.add(new LatLng(9.877596,78.080995));
        INEEE.add(new LatLng(9.877578,78.081330));
        INEEE.add(new LatLng(9.877774,78.081405));
        INEEE.add(new LatLng(9.878496,78.081654));
        INEEE.add(new LatLng(9.879215,78.081785));
        INEEE.add(new LatLng(9.879701,78.081978));
        INEEE.add(new LatLng(9.880621,78.082225));
        INEEE.add(new LatLng(9.880761,78.082324));
        INEEE.add(new LatLng(9.880959,78.082606));
        INEEE.add(new LatLng(9.881540,78.082662));
        INEEE.add(new LatLng(9.881452,78.083488));
        INEEE.add(new LatLng(9.881682,78.083426));
        INEEE.add(new LatLng(9.882341,78.083402));
        INEEE.add(new LatLng(9.882341,78.083190));
        INEEE.add(new LatLng(9.882341,78.082764));
        INEEE.add(new LatLng(9.882341,78.082422));
        INEEE.add(new LatLng(9.882464,78.082422));
        INEEE.add(new LatLng(9.882464,78.082333));
        INEEE.add(new LatLng(9.882464,78.082037));
        INEEE.add(new LatLng(9.882433,78.082086));

        //INCIVIL.add(new LatLng(9.877326,78.080994));
        INCIVIL.add(new LatLng(9.877596,78.080995));
        INCIVIL.add(new LatLng(9.877578,78.081330));
        INCIVIL.add(new LatLng(9.877774,78.081405));
        INCIVIL.add(new LatLng(9.878496,78.081654));
        INCIVIL.add(new LatLng(9.879215,78.081785));
        INCIVIL.add(new LatLng(9.879701,78.081978));
        INCIVIL.add(new LatLng(9.880621,78.082225));
        INCIVIL.add(new LatLng(9.880761,78.082324));
        INCIVIL.add(new LatLng(9.880959,78.082606));
        INCIVIL.add(new LatLng(9.881540,78.082662));
        INCIVIL.add(new LatLng(9.881452,78.083488));
        INCIVIL.add(new LatLng(9.881682,78.083426));
        INCIVIL.add(new LatLng(9.882326,78.083423));
        INCIVIL.add(new LatLng(9.882324,78.083199));
        INCIVIL.add(new LatLng(9.882324,78.082764));
        INCIVIL.add(new LatLng(9.882278,78.082855));

        //INMECH.add(new LatLng(9.877326,78.080994));
        INMECH.add(new LatLng(9.877596,78.080995));
        INMECH.add(new LatLng(9.877578,78.081330));
        INMECH.add(new LatLng(9.877774,78.081405));
        INMECH.add(new LatLng(9.878496,78.081654));
        INMECH.add(new LatLng(9.879215,78.081785));
        INMECH.add(new LatLng(9.879701,78.081978));
        INMECH.add(new LatLng(9.880621,78.082225));
        INMECH.add(new LatLng(9.880761,78.082324));
        INMECH.add(new LatLng(9.880959,78.082606));
        INMECH.add(new LatLng(9.881540,78.082662));
        INMECH.add(new LatLng(9.881452,78.083488));
        INMECH.add(new LatLng(9.881682,78.083426));
        INMECH.add(new LatLng(9.882124,78.083426));
        INMECH.add(new LatLng(9.882124,78.083251));
        INMECH.add(new LatLng(9.882124,78.083002));
        INMECH.add(new LatLng(9.881980,78.083002));
        INMECH.add(new LatLng(9.881980,78.082442));
        INMECH.add(new LatLng(9.882207,78.082300));
        INMECH.add(new LatLng(9.882321,78.081682));
        INMECH.add(new LatLng(9.882399,78.081653));
        INMECH.add(new LatLng(9.882452,78.081388));
        INMECH.add(new LatLng(9.882707,78.081388));
        INMECH.add(new LatLng(9.882365,78.081429));

        //INMECHT.add(new LatLng(9.877326,78.080994));
        INMECHT.add(new LatLng(9.877596,78.080995));
        INMECHT.add(new LatLng(9.877578,78.081330));
        INMECHT.add(new LatLng(9.877774,78.081405));
        INMECHT.add(new LatLng(9.878496,78.081654));
        INMECHT.add(new LatLng(9.879215,78.081785));
        INMECHT.add(new LatLng(9.879701,78.081978));
        INMECHT.add(new LatLng(9.880621,78.082225));
        INMECHT.add(new LatLng(9.880761,78.082324));
        INMECHT.add(new LatLng(9.880959,78.082606));
        INMECHT.add(new LatLng(9.881540,78.082662));
        INMECHT.add(new LatLng(9.881452,78.083488));
        INMECHT.add(new LatLng(9.881682,78.083426));
        INMECHT.add(new LatLng(9.882124,78.083426));
        INMECHT.add(new LatLng(9.882124,78.083251));
        INMECHT.add(new LatLng(9.882124,78.083002));
        INMECHT.add(new LatLng(9.881980,78.083002));
        INMECHT.add(new LatLng(9.881980,78.082442));
        INMECHT.add(new LatLng(9.882207,78.082300));
        INMECHT.add(new LatLng(9.882321,78.081682));
        INMECHT.add(new LatLng(9.882399,78.081653));
        INMECHT.add(new LatLng(9.882452,78.081388));
        INMECHT.add(new LatLng(9.882707,78.081388));
        INMECHT.add(new LatLng(9.882365,78.081428));

        //INARCH.add(new LatLng(9.877326,78.080994));
        INARCH.add(new LatLng(9.877596,78.080995));
        INARCH.add(new LatLng(9.877578,78.081330));
        INARCH.add(new LatLng(9.877774,78.081405));
        INARCH.add(new LatLng(9.878496,78.081654));
        INARCH.add(new LatLng(9.879215,78.081785));
        INARCH.add(new LatLng(9.879701,78.081978));
        INARCH.add(new LatLng(9.880621,78.082225));
        INARCH.add(new LatLng(9.880761,78.082324));
        INARCH.add(new LatLng(9.880959,78.082606));
        INARCH.add(new LatLng(9.881540,78.082662));
        INARCH.add(new LatLng(9.881452,78.083488));
        INARCH.add(new LatLng(9.881301,78.083517));
        INARCH.add(new LatLng(9.880672,78.083442));
        INARCH.add(new LatLng(9.880558,78.083080));
        INARCH.add(new LatLng(9.880201,78.083158));
        INARCH.add(new LatLng(9.878790,78.082110));

        //INSCIENCEBLOCK.add(new LatLng(9.877326,78.080994));
        INSCIENCEBLOCK.add(new LatLng(9.877596,78.080995));
        INSCIENCEBLOCK.add(new LatLng(9.877578,78.081330));
        INSCIENCEBLOCK.add(new LatLng(9.877774,78.081405));
        INSCIENCEBLOCK.add(new LatLng(9.878496,78.081654));
        INSCIENCEBLOCK.add(new LatLng(9.879215,78.081785));
        INSCIENCEBLOCK.add(new LatLng(9.879701,78.081978));
        INSCIENCEBLOCK.add(new LatLng(9.880621,78.082225));
        INSCIENCEBLOCK.add(new LatLng(9.880761,78.082324));
        INSCIENCEBLOCK.add(new LatLng(9.880959,78.082606));
        INSCIENCEBLOCK.add(new LatLng(9.881540,78.082662));
        INSCIENCEBLOCK.add(new LatLng(9.881452,78.083488));
        INSCIENCEBLOCK.add(new LatLng(9.881682,78.083426));
        INSCIENCEBLOCK.add(new LatLng(9.882169,78.083412));
        INSCIENCEBLOCK.add(new LatLng(9.882148,78.083023));
        INSCIENCEBLOCK.add(new LatLng(9.881686,78.083034));
        INSCIENCEBLOCK.add(new LatLng(9.881876,78.083152));

        //INFRESHERBLOCK.add(new LatLng(9.877326,78.080994));
        INFRESHERBLOCK.add(new LatLng(9.877596,78.080995));
        INFRESHERBLOCK.add(new LatLng(9.877578,78.081330));
        INFRESHERBLOCK.add(new LatLng(9.877774,78.081405));
        INFRESHERBLOCK.add(new LatLng(9.878496,78.081654));
        INFRESHERBLOCK.add(new LatLng(9.879215,78.081785));
        INFRESHERBLOCK.add(new LatLng(9.879701,78.081978));
        INFRESHERBLOCK.add(new LatLng(9.880621,78.082225));
        INFRESHERBLOCK.add(new LatLng(9.880761,78.082324));
        INFRESHERBLOCK.add(new LatLng(9.880959,78.082606));
        INFRESHERBLOCK.add(new LatLng(9.881540,78.082662));
        INFRESHERBLOCK.add(new LatLng(9.881452,78.083488));
        INFRESHERBLOCK.add(new LatLng(9.881682,78.083426));
        INFRESHERBLOCK.add(new LatLng(9.882169,78.083412));
        INFRESHERBLOCK.add(new LatLng(9.882148,78.083023));
        INFRESHERBLOCK.add(new LatLng(9.881834,78.083032));
        INFRESHERBLOCK.add(new LatLng(9.88172,78.082617));

        //INNCCBLOCK.add(new LatLng(9.877326,78.080994));
        INNCCBLOCK.add(new LatLng(9.877596,78.080995));
        INNCCBLOCK.add(new LatLng(9.877578,78.081330));
        INNCCBLOCK.add(new LatLng(9.877774,78.081405));
        INNCCBLOCK.add(new LatLng(9.878496,78.081654));
        INNCCBLOCK.add(new LatLng(9.879215,78.081785));
        INNCCBLOCK.add(new LatLng(9.879701,78.081978));
        INNCCBLOCK.add(new LatLng(9.880621,78.082225));
        INNCCBLOCK.add(new LatLng(9.880761,78.082324));
        INNCCBLOCK.add(new LatLng(9.880959,78.082606));
        INNCCBLOCK.add(new LatLng(9.881540,78.082662));
        INNCCBLOCK.add(new LatLng(9.881452,78.083488));
        INNCCBLOCK.add(new LatLng(9.881682,78.083426));
        INNCCBLOCK.add(new LatLng(9.882124,78.083426));
        INNCCBLOCK.add(new LatLng(9.882124,78.083251));
        INNCCBLOCK.add(new LatLng(9.882124,78.083002));
        INNCCBLOCK.add(new LatLng(9.881980,78.083002));
        INNCCBLOCK.add(new LatLng(9.881980,78.082442));
        INNCCBLOCK.add(new LatLng(9.882207,78.082300));
        INNCCBLOCK.add(new LatLng(9.882321,78.081682));
        INNCCBLOCK.add(new LatLng(9.882399,78.081653));
        INNCCBLOCK.add(new LatLng(9.883234,78.081681));
        INNCCBLOCK.add(new LatLng(9.883262,78.080870));
        INNCCBLOCK.add(new LatLng(9.883286,78.080765));
        INNCCBLOCK.add(new LatLng(9.883458,78.080706));
        INNCCBLOCK.add(new LatLng(9.883560,78.079803));

        //INOUTDOOR.add(new LatLng(9.877326,78.080994));
        INOUTDOOR.add(new LatLng(9.877596,78.080995));
        INOUTDOOR.add(new LatLng(9.877578,78.081330));
        INOUTDOOR.add(new LatLng(9.877774,78.081405));
        INOUTDOOR.add(new LatLng(9.878496,78.081654));
        INOUTDOOR.add(new LatLng(9.879215,78.081785));
        INOUTDOOR.add(new LatLng(9.879701,78.081978));
        INOUTDOOR.add(new LatLng(9.880621,78.082225));
        INOUTDOOR.add(new LatLng(9.880761,78.082324));
        INOUTDOOR.add(new LatLng(9.880959,78.082606));
        INOUTDOOR.add(new LatLng(9.881540,78.082662));
        INOUTDOOR.add(new LatLng(9.881452,78.083488));
        INOUTDOOR.add(new LatLng(9.881682,78.083426));
        INOUTDOOR.add(new LatLng(9.882124,78.083426));
        INOUTDOOR.add(new LatLng(9.882124,78.083251));
        INOUTDOOR.add(new LatLng(9.882124,78.083002));
        INOUTDOOR.add(new LatLng(9.881980,78.083002));
        INOUTDOOR.add(new LatLng(9.881980,78.082442));
        INOUTDOOR.add(new LatLng(9.882207,78.082300));
        INOUTDOOR.add(new LatLng(9.882321,78.081682));
        INOUTDOOR.add(new LatLng(9.882399,78.081653));
        INOUTDOOR.add(new LatLng(9.882771,78.081653));
        INOUTDOOR.add(new LatLng(9.883236,78.081653));
        INOUTDOOR.add(new LatLng(9.883842,78.081407));

        //INKSAUDITORIUM.add(new LatLng(9.877326,78.080994));
        INKSAUDITORIUM.add(new LatLng(9.877596,78.080995));
        INKSAUDITORIUM.add(new LatLng(9.877578,78.081330));
        INKSAUDITORIUM.add(new LatLng(9.877774,78.081405));
        INKSAUDITORIUM.add(new LatLng(9.878496,78.081654));
        INKSAUDITORIUM.add(new LatLng(9.879215,78.081785));
        INKSAUDITORIUM.add(new LatLng(9.879701,78.081978));
        INKSAUDITORIUM.add(new LatLng(9.880621,78.082225));
        INKSAUDITORIUM.add(new LatLng(9.880761,78.082324));
        INKSAUDITORIUM.add(new LatLng(9.880959,78.082606));
        INKSAUDITORIUM.add(new LatLng(9.881540,78.082662));
        INKSAUDITORIUM.add(new LatLng(9.881452,78.083488));
        INKSAUDITORIUM.add(new LatLng(9.881682,78.083426));
        INKSAUDITORIUM.add(new LatLng(9.882124,78.083426));
        INKSAUDITORIUM.add(new LatLng(9.882692,78.083426));
        INKSAUDITORIUM.add(new LatLng(9.882710,78.083130));
        INKSAUDITORIUM.add(new LatLng(9.882731,78.082759));
        INKSAUDITORIUM.add(new LatLng(9.882750,78.082536));
        INKSAUDITORIUM.add(new LatLng(9.882770,78.082258));
        INKSAUDITORIUM.add(new LatLng(9.882783,78.082046));
        INKSAUDITORIUM.add(new LatLng(9.882820,78.082337));

        //INKMAUDITORIUM.add(new LatLng(9.877326,78.080994));
        INKMAUDITORIUM.add(new LatLng(9.877596,78.080995));
        INKMAUDITORIUM.add(new LatLng(9.877578,78.081330));
        INKMAUDITORIUM.add(new LatLng(9.877774,78.081405));
        INKMAUDITORIUM.add(new LatLng(9.878496,78.081654));
        INKMAUDITORIUM.add(new LatLng(9.879215,78.081785));
        INKMAUDITORIUM.add(new LatLng(9.879701,78.081978));
        INKMAUDITORIUM.add(new LatLng(9.880621,78.082225));
        INKMAUDITORIUM.add(new LatLng(9.880761,78.082324));
        INKMAUDITORIUM.add(new LatLng(9.880959,78.082606));
        INKMAUDITORIUM.add(new LatLng(9.881540,78.082662));
        INKMAUDITORIUM.add(new LatLng(9.881452,78.083488));
        INKMAUDITORIUM.add(new LatLng(9.881682,78.083426));
        INKMAUDITORIUM.add(new LatLng(9.882692,78.083426));
        INKMAUDITORIUM.add(new LatLng(9.882710,78.083130));
        INKMAUDITORIUM.add(new LatLng(9.882731,78.082759));
        INKMAUDITORIUM.add(new LatLng(9.882750,78.082536));
        INKMAUDITORIUM.add(new LatLng(9.882626,78.082537));
        INKMAUDITORIUM.add(new LatLng(9.882480,78.082541));

        //INPLACEMENTCELL.add(new LatLng(9.877326,78.080994));
        INPLACEMENTCELL.add(new LatLng(9.877596,78.080995));
        INPLACEMENTCELL.add(new LatLng(9.877578,78.081330));
        INPLACEMENTCELL.add(new LatLng(9.877774,78.081405));
        INPLACEMENTCELL.add(new LatLng(9.878496,78.081654));
        INPLACEMENTCELL.add(new LatLng(9.879215,78.081785));
        INPLACEMENTCELL.add(new LatLng(9.879701,78.081978));
        INPLACEMENTCELL.add(new LatLng(9.880621,78.082225));
        INPLACEMENTCELL.add(new LatLng(9.880761,78.082324));
        INPLACEMENTCELL.add(new LatLng(9.880959,78.082606));
        INPLACEMENTCELL.add(new LatLng(9.881540,78.082662));
        INPLACEMENTCELL.add(new LatLng(9.881452,78.083488));
        INPLACEMENTCELL.add(new LatLng(9.881682,78.083426));
        INPLACEMENTCELL.add(new LatLng(9.882124,78.083426));
        INPLACEMENTCELL.add(new LatLng(9.882124,78.083251));
        INPLACEMENTCELL.add(new LatLng(9.882124,78.083002));
        INPLACEMENTCELL.add(new LatLng(9.881980,78.083002));
        INPLACEMENTCELL.add(new LatLng(9.881980,78.082442));
        INPLACEMENTCELL.add(new LatLng(9.882207,78.082300));
        INPLACEMENTCELL.add(new LatLng(9.882321,78.081682));
        INPLACEMENTCELL.add(new LatLng(9.882399,78.081653));
        INPLACEMENTCELL.add(new LatLng(9.882771,78.081653));
        INPLACEMENTCELL.add(new LatLng(9.883236,78.081653));
        INPLACEMENTCELL.add(new LatLng(9.883262,78.080870));
        INPLACEMENTCELL.add(new LatLng(9.883286,78.080765));
        INPLACEMENTCELL.add(new LatLng(9.883368,78.080711));
        INPLACEMENTCELL.add(new LatLng(9.883896,78.080727));
        INPLACEMENTCELL.add(new LatLng(9.884735,78.080781));
        INPLACEMENTCELL.add(new LatLng(9.885035,78.080792));
        INPLACEMENTCELL.add(new LatLng(9.885026,78.080954));

        //INGUESTHOUSE.add(new LatLng(9.877326,78.080994));
        INGUESTHOUSE.add(new LatLng(9.877596,78.080995));
        INGUESTHOUSE.add(new LatLng(9.877578,78.081330));
        INGUESTHOUSE.add(new LatLng(9.877774,78.081405));
        INGUESTHOUSE.add(new LatLng(9.878496,78.081654));
        INGUESTHOUSE.add(new LatLng(9.879215,78.081785));
        INGUESTHOUSE.add(new LatLng(9.879701,78.081978));
        INGUESTHOUSE.add(new LatLng(9.880621,78.082225));
        INGUESTHOUSE.add(new LatLng(9.880761,78.082324));
        INGUESTHOUSE.add(new LatLng(9.880959,78.082606));
        INGUESTHOUSE.add(new LatLng(9.881540,78.082662));
        INGUESTHOUSE.add(new LatLng(9.881452,78.083488));
        INGUESTHOUSE.add(new LatLng(9.881682,78.083426));
        INGUESTHOUSE.add(new LatLng(9.882124,78.083426));
        INGUESTHOUSE.add(new LatLng(9.882124,78.083251));
        INGUESTHOUSE.add(new LatLng(9.882124,78.083002));
        INGUESTHOUSE.add(new LatLng(9.881980,78.083002));
        INGUESTHOUSE.add(new LatLng(9.881980,78.082442));
        INGUESTHOUSE.add(new LatLng(9.882207,78.082300));
        INGUESTHOUSE.add(new LatLng(9.882321,78.081682));
        INGUESTHOUSE.add(new LatLng(9.882399,78.081653));
        INGUESTHOUSE.add(new LatLng(9.882771,78.081653));
        INGUESTHOUSE.add(new LatLng(9.883236,78.081653));
        INGUESTHOUSE.add(new LatLng(9.883262,78.080870));
        INGUESTHOUSE.add(new LatLng(9.883286,78.080765));
        INGUESTHOUSE.add(new LatLng(9.883368,78.080711));
        INGUESTHOUSE.add(new LatLng(9.883896,78.080727));
        INGUESTHOUSE.add(new LatLng(9.884735,78.080781));
        INGUESTHOUSE.add(new LatLng(9.885035,78.080792));
        INGUESTHOUSE.add(new LatLng(9.885210,78.080791));
        INGUESTHOUSE.add(new LatLng(9.885211,78.080632));

        //INMAINCANTEEN.add(new LatLng(9.877326,78.080994));
        INMAINCANTEEN.add(new LatLng(9.877596,78.080995));
        INMAINCANTEEN.add(new LatLng(9.877578,78.081330));
        INMAINCANTEEN.add(new LatLng(9.877774,78.081405));
        INMAINCANTEEN.add(new LatLng(9.878496,78.081654));
        INMAINCANTEEN.add(new LatLng(9.879215,78.081785));
        INMAINCANTEEN.add(new LatLng(9.879701,78.081978));
        INMAINCANTEEN.add(new LatLng(9.880621,78.082225));
        INMAINCANTEEN.add(new LatLng(9.880761,78.082324));
        INMAINCANTEEN.add(new LatLng(9.880959,78.082606));
        INMAINCANTEEN.add(new LatLng(9.881540,78.082662));
        INMAINCANTEEN.add(new LatLng(9.881452,78.083488));
        INMAINCANTEEN.add(new LatLng(9.881682,78.083426));
        INMAINCANTEEN.add(new LatLng(9.882124,78.083426));
        INMAINCANTEEN.add(new LatLng(9.882124,78.083251));
        INMAINCANTEEN.add(new LatLng(9.882124,78.083002));
        INMAINCANTEEN.add(new LatLng(9.881980,78.083002));
        INMAINCANTEEN.add(new LatLng(9.881980,78.082442));
        INMAINCANTEEN.add(new LatLng(9.882207,78.082300));
        INMAINCANTEEN.add(new LatLng(9.882321,78.081682));
        INMAINCANTEEN.add(new LatLng(9.882399,78.081653));
        INMAINCANTEEN.add(new LatLng(9.882771,78.081653));
        INMAINCANTEEN.add(new LatLng(9.883236,78.081653));
        INMAINCANTEEN.add(new LatLng(9.883286,78.080765));
        INMAINCANTEEN.add(new LatLng(9.883277,78.080255));
        INMAINCANTEEN.add(new LatLng(9.883264,78.079857));

        //INFOODCOURT.add(new LatLng(9.877326,78.080994));
        INFOODCOURT.add(new LatLng(9.877596,78.080995));
        INFOODCOURT.add(new LatLng(9.877578,78.081330));
        INFOODCOURT.add(new LatLng(9.877774,78.081405));
        INFOODCOURT.add(new LatLng(9.878496,78.081654));
        INFOODCOURT.add(new LatLng(9.879215,78.081785));
        INFOODCOURT.add(new LatLng(9.879701,78.081978));
        INFOODCOURT.add(new LatLng(9.880621,78.082225));
        INFOODCOURT.add(new LatLng(9.880761,78.082324));
        INFOODCOURT.add(new LatLng(9.880959,78.082606));
        INFOODCOURT.add(new LatLng(9.881540,78.082662));
        INFOODCOURT.add(new LatLng(9.881452,78.083488));
        INFOODCOURT.add(new LatLng(9.881682,78.083426));
        INFOODCOURT.add(new LatLng(9.882982,78.083426));
        INFOODCOURT.add(new LatLng(9.883168,78.083267));
        INFOODCOURT.add(new LatLng(9.883198,78.083240));
        INFOODCOURT.add(new LatLng(9.883282,78.083236));

        //INMENSHOSTEL.add(new LatLng(9.877326,78.080994));
        INMENSHOSTEL.add(new LatLng(9.877596,78.080995));
        INMENSHOSTEL.add(new LatLng(9.877578,78.081330));
        INMENSHOSTEL.add(new LatLng(9.877774,78.081405));
        INMENSHOSTEL.add(new LatLng(9.878496,78.081654));
        INMENSHOSTEL.add(new LatLng(9.879215,78.081785));
        INMENSHOSTEL.add(new LatLng(9.879701,78.081978));
        INMENSHOSTEL.add(new LatLng(9.880621,78.082225));
        INMENSHOSTEL.add(new LatLng(9.880761,78.082324));
        INMENSHOSTEL.add(new LatLng(9.880959,78.082606));
        INMENSHOSTEL.add(new LatLng(9.881540,78.082662));
        INMENSHOSTEL.add(new LatLng(9.881452,78.083488));
        INMENSHOSTEL.add(new LatLng(9.881682,78.083426));
        INMENSHOSTEL.add(new LatLng(9.882124,78.083426));
        INMENSHOSTEL.add(new LatLng(9.882124,78.083251));
        INMENSHOSTEL.add(new LatLng(9.882124,78.083002));
        INMENSHOSTEL.add(new LatLng(9.881980,78.083002));
        INMENSHOSTEL.add(new LatLng(9.881980,78.082442));
        INMENSHOSTEL.add(new LatLng(9.882207,78.082300));
        INMENSHOSTEL.add(new LatLng(9.882321,78.081682));
        INMENSHOSTEL.add(new LatLng(9.882399,78.081653));
        INMENSHOSTEL.add(new LatLng(9.882771,78.081653));
        INMENSHOSTEL.add(new LatLng(9.883236,78.081653));
        INMENSHOSTEL.add(new LatLng(9.883262,78.080870));
        INMENSHOSTEL.add(new LatLng(9.883286,78.080765));
        INMENSHOSTEL.add(new LatLng(9.883368,78.080711));
        INMENSHOSTEL.add(new LatLng(9.883896,78.080727));
        INMENSHOSTEL.add(new LatLng(9.884735,78.080781));
        INMENSHOSTEL.add(new LatLng(9.884765,78.080405));
        INMENSHOSTEL.add(new LatLng(9.884738,78.080071));

        //INWOMENSHOSTEL.add(new LatLng(9.877326,78.080994));
        INWOMENSHOSTEL.add(new LatLng(9.877596,78.080995));
        INWOMENSHOSTEL.add(new LatLng(9.877578,78.081330));
        INWOMENSHOSTEL.add(new LatLng(9.877774,78.081405));
        INWOMENSHOSTEL.add(new LatLng(9.878496,78.081654));
        INWOMENSHOSTEL.add(new LatLng(9.879215,78.081785));
        INWOMENSHOSTEL.add(new LatLng(9.879701,78.081978));
        INWOMENSHOSTEL.add(new LatLng(9.880621,78.082225));
        INWOMENSHOSTEL.add(new LatLng(9.880761,78.082324));
        INWOMENSHOSTEL.add(new LatLng(9.880959,78.082606));
        INWOMENSHOSTEL.add(new LatLng(9.881540,78.082662));
        INWOMENSHOSTEL.add(new LatLng(9.881452,78.083488));
        INWOMENSHOSTEL.add(new LatLng(9.881301,78.083517));
        INWOMENSHOSTEL.add(new LatLng(9.880672,78.083442));
        INWOMENSHOSTEL.add(new LatLng(9.880375,78.083386));
        INWOMENSHOSTEL.add(new LatLng(9.879979,78.083493));
        INWOMENSHOSTEL.add(new LatLng(9.879832,78.083329));
        INWOMENSHOSTEL.add(new LatLng(9.879632,78.083372));
        INWOMENSHOSTEL.add(new LatLng(9.879518,78.082975));
        INWOMENSHOSTEL.add(new LatLng(9.879373,78.082685));
        INWOMENSHOSTEL.add(new LatLng(9.879288,78.082626));
        INWOMENSHOSTEL.add(new LatLng(9.878910,78.082653));
        INWOMENSHOSTEL.add(new LatLng(9.878479,78.082776));
        INWOMENSHOSTEL.add(new LatLng(9.878434,78.082095));
        INWOMENSHOSTEL.add(new LatLng(9.878201,78.082072));

        //INLIBRARY.add(new LatLng(9.877326,78.080994));
        INLIBRARY.add(new LatLng(9.877596,78.080995));
        INLIBRARY.add(new LatLng(9.877578,78.081330));
        INLIBRARY.add(new LatLng(9.877774,78.081405));
        INLIBRARY.add(new LatLng(9.878496,78.081654));
        INLIBRARY.add(new LatLng(9.879215,78.081785));
        INLIBRARY.add(new LatLng(9.879701,78.081978));
        INLIBRARY.add(new LatLng(9.880621,78.082225));
        INLIBRARY.add(new LatLng(9.880761,78.082324));
        INLIBRARY.add(new LatLng(9.880959,78.082606));
        INLIBRARY.add(new LatLng(9.881540,78.082662));
        INLIBRARY.add(new LatLng(9.881452,78.083488));
        INLIBRARY.add(new LatLng(9.881682,78.083426));
        INLIBRARY.add(new LatLng(9.882124,78.083426));
        INLIBRARY.add(new LatLng(9.882124,78.083251));
        INLIBRARY.add(new LatLng(9.882124,78.083002));
        INLIBRARY.add(new LatLng(9.881980,78.083002));
        INLIBRARY.add(new LatLng(9.881980,78.082442));
        INLIBRARY.add(new LatLng(9.882207,78.082300));
        INLIBRARY.add(new LatLng(9.882321,78.081682));
        INLIBRARY.add(new LatLng(9.882399,78.081681));
        INLIBRARY.add(new LatLng(9.882982,78.081681));
        INLIBRARY.add(new LatLng(9.882982,78.081445));
        INLIBRARY.add(new LatLng(9.883105,78.081445));
        INLIBRARY.add(new LatLng(9.882854,78.081243));

        //INBANK.add(new LatLng(9.877326,78.080994));
        INBANK.add(new LatLng(9.877596,78.080995));
        INBANK.add(new LatLng(9.877578,78.081330));
        INBANK.add(new LatLng(9.877774,78.081405));
        INBANK.add(new LatLng(9.878496,78.081654));
        INBANK.add(new LatLng(9.879215,78.081785));
        INBANK.add(new LatLng(9.879701,78.081978));
        INBANK.add(new LatLng(9.880621,78.082225));
        INBANK.add(new LatLng(9.880761,78.082324));
        INBANK.add(new LatLng(9.880959,78.082606));
        INBANK.add(new LatLng(9.881540,78.082662));
        INBANK.add(new LatLng(9.881452,78.083488));
        INBANK.add(new LatLng(9.881682,78.083426));
        INBANK.add(new LatLng(9.882124,78.083426));
        INBANK.add(new LatLng(9.882124,78.083251));
        INBANK.add(new LatLng(9.882124,78.083002));
        INBANK.add(new LatLng(9.881980,78.083002));
        INBANK.add(new LatLng(9.881980,78.082442));
        INBANK.add(new LatLng(9.882207,78.082300));
        INBANK.add(new LatLng(9.882321,78.081682));
        INBANK.add(new LatLng(9.882399,78.081653));
        INBANK.add(new LatLng(9.882771,78.081653));
        INBANK.add(new LatLng(9.883236,78.081653));
        INBANK.add(new LatLng(9.883262,78.080870));
        INBANK.add(new LatLng(9.883286,78.080765));
        INBANK.add(new LatLng(9.883458,78.080706));
        INBANK.add(new LatLng(9.883496,78.079848));

        //INTEMPLE.add(new LatLng(9.877326,78.080994));
        INTEMPLE.add(new LatLng(9.877596,78.080995));
        INTEMPLE.add(new LatLng(9.877578,78.081330));
        INTEMPLE.add(new LatLng(9.877774,78.081405));
        INTEMPLE.add(new LatLng(9.878496,78.081654));
        INTEMPLE.add(new LatLng(9.879215,78.081785));
        INTEMPLE.add(new LatLng(9.879701,78.081978));
        INTEMPLE.add(new LatLng(9.880621,78.082225));
        INTEMPLE.add(new LatLng(9.880761,78.082324));
        INTEMPLE.add(new LatLng(9.880959,78.082606));
        INTEMPLE.add(new LatLng(9.881540,78.082662));
        INTEMPLE.add(new LatLng(9.881452,78.083488));
        INTEMPLE.add(new LatLng(9.881682,78.083426));
        INTEMPLE.add(new LatLng(9.882124,78.083426));
        INTEMPLE.add(new LatLng(9.882124,78.083251));
        INTEMPLE.add(new LatLng(9.882124,78.083002));
        INTEMPLE.add(new LatLng(9.881980,78.083002));
        INTEMPLE.add(new LatLng(9.881980,78.082442));
        INTEMPLE.add(new LatLng(9.882207,78.082300));
        INTEMPLE.add(new LatLng(9.882321,78.081682));
        INTEMPLE.add(new LatLng(9.882399,78.081653));
        INTEMPLE.add(new LatLng(9.882771,78.081653));
        INTEMPLE.add(new LatLng(9.883236,78.081653));
        INTEMPLE.add(new LatLng(9.883262,78.080870));
        INTEMPLE.add(new LatLng(9.883286,78.080765));
        INTEMPLE.add(new LatLng(9.883368,78.080711));
        INTEMPLE.add(new LatLng(9.883896,78.080727));
        INTEMPLE.add(new LatLng(9.884735,78.080781));
        INTEMPLE.add(new LatLng(9.885035,78.080792));
        INTEMPLE.add(new LatLng(9.885443,78.080804));
        INTEMPLE.add(new LatLng(9.885459,78.080574));

        //INPARKING.add(new LatLng(9.877326,78.080994));
        INPARKING.add(new LatLng(9.877596,78.080995));
        INPARKING.add(new LatLng(9.877578,78.081330));
        INPARKING.add(new LatLng(9.877774,78.081405));
        INPARKING.add(new LatLng(9.878496,78.081654));
        INPARKING.add(new LatLng(9.879215,78.081785));
        INPARKING.add(new LatLng(9.879701,78.081978));
        INPARKING.add(new LatLng(9.880621,78.082225));
        INPARKING.add(new LatLng(9.880761,78.082324));
        INPARKING.add(new LatLng(9.880959,78.082606));
        INPARKING.add(new LatLng(9.881540,78.082662));
        INPARKING.add(new LatLng(9.881452,78.083488));
        INPARKING.add(new LatLng(9.881682,78.083426));
        INPARKING.add(new LatLng(9.882124,78.083426));
        INPARKING.add(new LatLng(9.882124,78.083251));
        INPARKING.add(new LatLng(9.882124,78.083002));
        INPARKING.add(new LatLng(9.881980,78.083002));
        INPARKING.add(new LatLng(9.881980,78.082442));
        INPARKING.add(new LatLng(9.882207,78.082300));
        INPARKING.add(new LatLng(9.882321,78.081682));
        INPARKING.add(new LatLng(9.882399,78.081653));
        INPARKING.add(new LatLng(9.882771,78.081653));
        INPARKING.add(new LatLng(9.883236,78.081653));
        INPARKING.add(new LatLng(9.883252,78.081003));
        INPARKING.add(new LatLng(9.883106,78.080998));
        INPARKING.add(new LatLng(9.882769,78.080846));

    }
    public void initOutdoorCoordinates()
    {
        //Outdoor
        OUTMAINBUILDING.add(new LatLng(9.883842,78.081407));
        OUTMAINBUILDING.add(new LatLng(9.883218,78.082530));
        OUTMAINBUILDING.add(new LatLng(9.882881,78.082511));

        OUTIT.add(new LatLng(9.883842,78.081407));
        OUTIT.add(new LatLng(9.883236,78.081833));
        OUTIT.add(new LatLng(9.883211,78.082630));
        OUTIT.add(new LatLng(9.883168,78.083267));
        OUTIT.add(new LatLng(9.882982,78.083423));
        OUTIT.add(new LatLng(9.882397,78.083426));
        OUTIT.add(new LatLng(9.882397,78.083506));
        OUTIT.add(new LatLng(9.882397,78.083569));
        OUTIT.add(new LatLng(9.882399,78.083630));

        OUTCSE.add(new LatLng(9.883842,78.081407));
        OUTCSE.add(new LatLng(9.883236,78.081833));
        OUTCSE.add(new LatLng(9.883211,78.082630));
        OUTCSE.add(new LatLng(9.883168,78.083267));
        OUTCSE.add(new LatLng(9.882982,78.083423));
        OUTCSE.add(new LatLng(9.882893,78.083421));
        OUTCSE.add(new LatLng(9.882884,78.083593));
        OUTCSE.add(new LatLng(9.882896,78.083745));
        OUTCSE.add(new LatLng(9.882797,78.083739));

        OUTECE.add(new LatLng(9.883842,78.081407));
        OUTECE.add(new LatLng(9.883236,78.081833));
        OUTECE.add(new LatLng(9.883225,78.082341));
        OUTECE.add(new LatLng(9.883016,78.082341));
        OUTECE.add(new LatLng(9.882820,78.082338));

        OUTEEE.add(new LatLng(9.883842,78.081407));
        OUTEEE.add(new LatLng(9.883225,78.081854));
        OUTEEE.add(new LatLng(9.882816,78.081854));
        OUTEEE.add(new LatLng(9.882466,78.081854));
        OUTEEE.add(new LatLng(9.882466,78.082038));
        OUTEEE.add(new LatLng(9.882433,78.082086));

        OUTCIVIL.add(new LatLng(9.883842,78.081407));
        OUTCIVIL.add(new LatLng(9.883225,78.081854));
        OUTCIVIL.add(new LatLng(9.882816,78.081854));
        OUTCIVIL.add(new LatLng(9.882466,78.081854));
        OUTCIVIL.add(new LatLng(9.882464,78.082037));
        OUTCIVIL.add(new LatLng(9.882464,78.082333));
        OUTCIVIL.add(new LatLng(9.882464,78.082422));
        OUTCIVIL.add(new LatLng(9.882341,78.082422));
        OUTCIVIL.add(new LatLng(9.882341,78.082764));
        OUTCIVIL.add(new LatLng(9.882278,78.082855));

        OUTMECH.add(new LatLng(9.883842,78.081407));
        OUTMECH.add(new LatLng(9.883234,78.081681));
        OUTMECH.add(new LatLng(9.882949,78.081681));
        OUTMECH.add(new LatLng(9.882707,78.081253));
        OUTMECH.add(new LatLng(9.882365,78.081429));

        OUTMECHT.add(new LatLng(9.883842,78.081407));
        OUTMECHT.add(new LatLng(9.883234,78.081681));
        OUTMECHT.add(new LatLng(9.882949,78.081681));
        OUTMECHT.add(new LatLng(9.882707,78.081253));
        OUTMECHT.add(new LatLng(9.882365,78.081428));

        OUTARCH.add(new LatLng(9.883842,78.081407));
        OUTARCH.add(new LatLng(9.883236,78.081653));
        OUTARCH.add(new LatLng(9.882771,78.081653));
        OUTARCH.add(new LatLng(9.882399,78.081653));
        OUTARCH.add(new LatLng(9.882321,78.081682));
        OUTARCH.add(new LatLng(9.882207,78.082300));
        OUTARCH.add(new LatLng(9.881980,78.082442));
        OUTARCH.add(new LatLng(9.881980,78.083002));
        OUTARCH.add(new LatLng(9.882124,78.083002));
        OUTARCH.add(new LatLng(9.882124,78.083251));
        OUTARCH.add(new LatLng(9.882124,78.083426));
        OUTARCH.add(new LatLng(9.881682,78.083426));
        OUTARCH.add(new LatLng(9.881301,78.083517));
        OUTARCH.add(new LatLng(9.880672,78.083442));
        OUTARCH.add(new LatLng(9.880558,78.083080));
        OUTARCH.add(new LatLng(9.880201,78.083158));
        OUTARCH.add(new LatLng(9.878790,78.082110));

        OUTSCIENCEBLOCK.add(new LatLng(9.883842,78.081407));
        OUTSCIENCEBLOCK.add(new LatLng(9.883234,78.081681));
        OUTSCIENCEBLOCK.add(new LatLng(9.882399,78.081653));
        OUTSCIENCEBLOCK.add(new LatLng(9.882321,78.081682));
        OUTSCIENCEBLOCK.add(new LatLng(9.882207,78.082300));
        OUTSCIENCEBLOCK.add(new LatLng(9.881980,78.082442));
        OUTSCIENCEBLOCK.add(new LatLng(9.881980,78.083002));
        OUTSCIENCEBLOCK.add(new LatLng(9.881980,78.083111));
        OUTSCIENCEBLOCK.add(new LatLng(9.881876,78.083152));

        OUTFRESHERBLOCK.add(new LatLng(9.883842,78.081407));
        OUTFRESHERBLOCK.add(new LatLng(9.883234,78.081681));
        OUTFRESHERBLOCK.add(new LatLng(9.882399,78.081653));
        OUTFRESHERBLOCK.add(new LatLng(9.882321,78.081682));
        OUTFRESHERBLOCK.add(new LatLng(9.882207,78.082300));
        OUTFRESHERBLOCK.add(new LatLng(9.881980,78.082442));
        OUTFRESHERBLOCK.add(new LatLng(9.881980,78.082817));
        OUTFRESHERBLOCK.add(new LatLng(9.88172,78.082617));

        OUTNCCBLOCK.add(new LatLng(9.883842,78.081407));
        OUTNCCBLOCK.add(new LatLng(9.883262,78.081539));
        OUTNCCBLOCK.add(new LatLng(9.883262,78.080870));
        OUTNCCBLOCK.add(new LatLng(9.883286,78.080765));
        OUTNCCBLOCK.add(new LatLng(9.883458,78.080706));
        OUTNCCBLOCK.add(new LatLng(9.883560,78.079803));

        OUTINDOOR.add(new LatLng(9.883842,78.081407));
        OUTINDOOR.add(new LatLng(9.883236,78.081653));
        OUTINDOOR.add(new LatLng(9.882771,78.081653));
        OUTINDOOR.add(new LatLng(9.882399,78.081653));
        OUTINDOOR.add(new LatLng(9.882321,78.081682));
        OUTINDOOR.add(new LatLng(9.882207,78.082300));
        OUTINDOOR.add(new LatLng(9.881980,78.082442));
        OUTINDOOR.add(new LatLng(9.881980,78.083002));
        OUTINDOOR.add(new LatLng(9.882124,78.083002));
        OUTINDOOR.add(new LatLng(9.882124,78.083251));
        OUTINDOOR.add(new LatLng(9.882124,78.083426));
        OUTINDOOR.add(new LatLng(9.881682,78.083426));
        OUTINDOOR.add(new LatLng(9.881452,78.083488));
        OUTINDOOR.add(new LatLng(9.881540,78.082662));
        OUTINDOOR.add(new LatLng(9.880959,78.082606));
        OUTINDOOR.add(new LatLng(9.880761,78.082324));
        OUTINDOOR.add(new LatLng(9.880621,78.082225));
        OUTINDOOR.add(new LatLng(9.879701,78.081978));
        OUTINDOOR.add(new LatLng(9.879215,78.081785));
        OUTINDOOR.add(new LatLng(9.878496,78.081654));
        OUTINDOOR.add(new LatLng(9.877774,78.081405));
        OUTINDOOR.add(new LatLng(9.877578,78.081330));
        OUTINDOOR.add(new LatLng(9.877596,78.080995));
        OUTINDOOR.add(new LatLng(9.882838,78.082683));

        OUTKSAUDITORIUM.add(new LatLng(9.883842,78.081407));
        OUTKSAUDITORIUM.add(new LatLng(9.883250,78.081539));
        OUTKSAUDITORIUM.add(new LatLng(9.883250,78.081976));
        OUTKSAUDITORIUM.add(new LatLng(9.882820,78.082337));

        OUTKMAUDITORIUM.add(new LatLng(9.883842,78.081407));
        OUTKMAUDITORIUM.add(new LatLng(9.883250,78.081539));
        OUTKMAUDITORIUM.add(new LatLng(9.883250,78.082540));
        OUTKMAUDITORIUM.add(new LatLng(9.882933,78.082540));
        OUTKMAUDITORIUM.add(new LatLng(9.882711,78.082540));
        OUTKMAUDITORIUM.add(new LatLng(9.882480,78.082541));


        OUTPLACEMENTCELL.add(new LatLng(9.883842,78.081407));
        OUTPLACEMENTCELL.add(new LatLng(9.883759,78.080721));
        OUTPLACEMENTCELL.add(new LatLng(9.884735,78.080781));
        OUTPLACEMENTCELL.add(new LatLng(9.885035,78.080792));
        OUTPLACEMENTCELL.add(new LatLng(9.885026,78.080954));

        OUTGUESTHOUSE.add(new LatLng(9.883842,78.081407));
        OUTGUESTHOUSE.add(new LatLng(9.883759,78.080721));
        OUTGUESTHOUSE.add(new LatLng(9.884735,78.080781));
        OUTGUESTHOUSE.add(new LatLng(9.885035,78.080792));
        OUTGUESTHOUSE.add(new LatLng(9.885210,78.080791));
        OUTGUESTHOUSE.add(new LatLng(9.885211,78.080632));

        OUTMAINCANTEEN.add(new LatLng(9.883842,78.081407));
        OUTMAINCANTEEN.add(new LatLng(9.883759,78.080721));
        OUTMAINCANTEEN.add(new LatLng(9.883277,78.080721));
        OUTMAINCANTEEN.add(new LatLng(9.883277,78.080255));
        OUTMAINCANTEEN.add(new LatLng(9.883264,78.079857));

        OUTFOODCOURT.add(new LatLng(9.883842,78.081407));
        OUTFOODCOURT.add(new LatLng(9.883250,78.081539));
        OUTFOODCOURT.add(new LatLng(9.883173,78.083246));
        OUTFOODCOURT.add(new LatLng(9.883282,78.083236));

        OUTMENSHOSTEL.add(new LatLng(9.883842,78.081407));
        OUTMENSHOSTEL.add(new LatLng(9.883759,78.080721));
        OUTMENSHOSTEL.add(new LatLng(9.884778,78.080721));
        OUTMENSHOSTEL.add(new LatLng(9.884738,78.080071));

        OUTWOMENSHOSTEL.add(new LatLng(9.883842,78.081407));
        OUTWOMENSHOSTEL.add(new LatLng(9.883250,78.081539));
        OUTWOMENSHOSTEL.add(new LatLng(9.883234,78.081681));
        OUTWOMENSHOSTEL.add(new LatLng(9.882399,78.081653));
        OUTWOMENSHOSTEL.add(new LatLng(9.882321,78.081682));
        OUTWOMENSHOSTEL.add(new LatLng(9.882207,78.082300));
        OUTWOMENSHOSTEL.add(new LatLng(9.881980,78.082442));
        OUTWOMENSHOSTEL.add(new LatLng(9.881980,78.083002));
        OUTWOMENSHOSTEL.add(new LatLng(9.882124,78.083002));
        OUTWOMENSHOSTEL.add(new LatLng(9.882124,78.083251));
        OUTWOMENSHOSTEL.add(new LatLng(9.882124,78.083426));
        OUTWOMENSHOSTEL.add(new LatLng(9.881682,78.083426));
        OUTWOMENSHOSTEL.add(new LatLng(9.881301,78.083517));
        OUTWOMENSHOSTEL.add(new LatLng(9.880672,78.083442));
        OUTWOMENSHOSTEL.add(new LatLng(9.880375,78.083386));
        OUTWOMENSHOSTEL.add(new LatLng(9.879979,78.083493));
        OUTWOMENSHOSTEL.add(new LatLng(9.879832,78.083329));
        OUTWOMENSHOSTEL.add(new LatLng(9.879632,78.083372));
        OUTWOMENSHOSTEL.add(new LatLng(9.879518,78.082975));
        OUTWOMENSHOSTEL.add(new LatLng(9.879373,78.082685));
        OUTWOMENSHOSTEL.add(new LatLng(9.879288,78.082626));
        OUTWOMENSHOSTEL.add(new LatLng(9.878910,78.082653));
        OUTWOMENSHOSTEL.add(new LatLng(9.878479,78.082776));
        OUTWOMENSHOSTEL.add(new LatLng(9.878434,78.082095));
        OUTWOMENSHOSTEL.add(new LatLng(9.878201,78.082072));

        OUTLIBRARY.add(new LatLng(9.883842,78.081407));
        OUTLIBRARY.add(new LatLng(9.883250,78.081539));
        OUTLIBRARY.add(new LatLng(9.883250,78.081264));
        OUTLIBRARY.add(new LatLng(9.882854,78.081243));

        OUTBANK.add(new LatLng(9.883842,78.081407));
        OUTBANK.add(new LatLng(9.883759,78.080721));
        OUTBANK.add(new LatLng(9.883489,78.080721));
        OUTBANK.add(new LatLng(9.883496,78.079848));

        OUTTEMPLE.add(new LatLng(9.883842,78.081407));
        OUTTEMPLE.add(new LatLng(9.883759,78.080721));
        OUTTEMPLE.add(new LatLng(9.884735,78.080781));
        OUTTEMPLE.add(new LatLng(9.885035,78.080792));
        OUTTEMPLE.add(new LatLng(9.885443,78.080804));
        OUTTEMPLE.add(new LatLng(9.885459,78.080574));

        OUTPARKING.add(new LatLng(9.883842,78.081407));
        OUTPARKING.add(new LatLng(9.883250,78.081539));
        OUTPARKING.add(new LatLng(9.883252,78.081003));
        OUTPARKING.add(new LatLng(9.883106,78.080998));
        OUTPARKING.add(new LatLng(9.882769,78.080846));
    }
    public void initPlacementCellCoordinates()
    {
        PCMAINBUILDING.add(new LatLng(9.885026,78.080954));
        PCMAINBUILDING.add(new LatLng(9.885033,78.080787));
        PCMAINBUILDING.add(new LatLng(9.883458,78.080706));
        PCMAINBUILDING.add(new LatLng(9.883286,78.080765));
        PCMAINBUILDING.add(new LatLng(9.883262,78.080870));
        PCMAINBUILDING.add(new LatLng(9.883236,78.081833));
        PCMAINBUILDING.add(new LatLng(9.883225,78.082341));
        PCMAINBUILDING.add(new LatLng(9.883225,78.082530));
        PCMAINBUILDING.add(new LatLng(9.882881,78.082511));



        PCIT.add(new LatLng(9.885026,78.080954));
        PCIT.add(new LatLng(9.885035,78.080792));
        PCIT.add(new LatLng(9.884735,78.080781));
        PCIT.add(new LatLng(9.883896,78.080727));
        PCIT.add(new LatLng(9.883368,78.080711));
        PCIT.add(new LatLng(9.883286,78.080765));
        PCIT.add(new LatLng(9.883262,78.080870));
        PCIT.add(new LatLng(9.883236,78.081833));
        PCIT.add(new LatLng(9.883211,78.082630));
        PCIT.add(new LatLng(9.883168,78.083267));
        PCIT.add(new LatLng(9.882982,78.083423));
        PCIT.add(new LatLng(9.882397,78.083426));
        PCIT.add(new LatLng(9.882397,78.083506));
        PCIT.add(new LatLng(9.882397,78.083569));
        PCIT.add(new LatLng(9.882399,78.083630));



        PCCSE.add(new LatLng(9.885026,78.080954));
        PCCSE.add(new LatLng(9.885035,78.080792));
        PCCSE.add(new LatLng(9.884735,78.080781));
        PCCSE.add(new LatLng(9.883896,78.080727));
        PCCSE.add(new LatLng(9.883368,78.080711));
        PCCSE.add(new LatLng(9.883286,78.080765));
        PCCSE.add(new LatLng(9.883262,78.080870));
        PCCSE.add(new LatLng(9.883236,78.081833));
        PCCSE.add(new LatLng(9.883211,78.082630));
        PCCSE.add(new LatLng(9.883168,78.083267));
        PCCSE.add(new LatLng(9.882982,78.083423));
        PCCSE.add(new LatLng(9.882893,78.083421));
        PCCSE.add(new LatLng(9.882884,78.083593));
        PCCSE.add(new LatLng(9.882896,78.083745));
        PCCSE.add(new LatLng(9.882797,78.083739));



        PCECE.add(new LatLng(9.885026,78.080954));
        PCECE.add(new LatLng(9.885035,78.080792));
        PCECE.add(new LatLng(9.884735,78.080781));
        PCECE.add(new LatLng(9.883896,78.080727));
        PCECE.add(new LatLng(9.883368,78.080711));
        PCECE.add(new LatLng(9.883286,78.080765));
        PCECE.add(new LatLng(9.883262,78.080870));
        PCECE.add(new LatLng(9.883236,78.081833));
        PCECE.add(new LatLng(9.883225,78.082341));
        PCECE.add(new LatLng(9.883016,78.082341));
        PCECE.add(new LatLng(9.882820,78.082338));



        PCEEE.add(new LatLng(9.885026,78.080954));
        PCEEE.add(new LatLng(9.885035,78.080792));
        PCEEE.add(new LatLng(9.884735,78.080781));
        PCEEE.add(new LatLng(9.883896,78.080727));
        PCEEE.add(new LatLng(9.883368,78.080711));
        PCEEE.add(new LatLng(9.883286,78.080765));
        PCEEE.add(new LatLng(9.883262,78.080870));
        PCEEE.add(new LatLng(9.883225,78.081854));
        PCEEE.add(new LatLng(9.882816,78.081854));
        PCEEE.add(new LatLng(9.882466,78.081854));
        PCEEE.add(new LatLng(9.882466,78.082038));
        PCEEE.add(new LatLng(9.882433,78.082086));



        PCCIVIL.add(new LatLng(9.885026,78.080954));
        PCCIVIL.add(new LatLng(9.885035,78.080792));
        PCCIVIL.add(new LatLng(9.884735,78.080781));
        PCCIVIL.add(new LatLng(9.883896,78.080727));
        PCCIVIL.add(new LatLng(9.883368,78.080711));
        PCCIVIL.add(new LatLng(9.883286,78.080765));
        PCCIVIL.add(new LatLng(9.883262,78.080870));
        PCCIVIL.add(new LatLng(9.883225,78.081854));
        PCCIVIL.add(new LatLng(9.882816,78.081854));
        PCCIVIL.add(new LatLng(9.882466,78.081854));
        PCCIVIL.add(new LatLng(9.882464,78.082037));
        PCCIVIL.add(new LatLng(9.882464,78.082333));
        PCCIVIL.add(new LatLng(9.882464,78.082422));
        PCCIVIL.add(new LatLng(9.882341,78.082422));
        PCCIVIL.add(new LatLng(9.882341,78.082764));
        PCCIVIL.add(new LatLng(9.882278,78.082855));



        PCMECH.add(new LatLng(9.885026,78.080954));
        PCMECH.add(new LatLng(9.885035,78.080792));
        PCMECH.add(new LatLng(9.884735,78.080781));
        PCMECH.add(new LatLng(9.883896,78.080727));
        PCMECH.add(new LatLng(9.883368,78.080711));
        PCMECH.add(new LatLng(9.883286,78.080765));
        PCMECH.add(new LatLng(9.883262,78.080870));
        PCMECH.add(new LatLng(9.883234,78.081681));
        PCMECH.add(new LatLng(9.882949,78.081681));
        PCMECH.add(new LatLng(9.882707,78.081253));
        PCMECH.add(new LatLng(9.882365,78.081429));



        PCMECHT.add(new LatLng(9.885026,78.080954));
        PCMECHT.add(new LatLng(9.885035,78.080792));
        PCMECHT.add(new LatLng(9.884735,78.080781));
        PCMECHT.add(new LatLng(9.883896,78.080727));
        PCMECHT.add(new LatLng(9.883368,78.080711));
        PCMECHT.add(new LatLng(9.883286,78.080765));
        PCMECHT.add(new LatLng(9.883262,78.080870));
        PCMECHT.add(new LatLng(9.883234,78.081681));
        PCMECHT.add(new LatLng(9.882949,78.081681));
        PCMECHT.add(new LatLng(9.882707,78.081253));
        PCMECHT.add(new LatLng(9.882365,78.081428));



        PCARCH.add(new LatLng(9.885026,78.080954));
        PCARCH.add(new LatLng(9.885035,78.080792));
        PCARCH.add(new LatLng(9.884735,78.080781));
        PCARCH.add(new LatLng(9.883896,78.080727));
        PCARCH.add(new LatLng(9.883368,78.080711));
        PCARCH.add(new LatLng(9.883286,78.080765));
        PCARCH.add(new LatLng(9.883262,78.080870));
        PCARCH.add(new LatLng(9.883236,78.081653));
        PCARCH.add(new LatLng(9.882771,78.081653));
        PCARCH.add(new LatLng(9.882399,78.081653));
        PCARCH.add(new LatLng(9.882321,78.081682));
        PCARCH.add(new LatLng(9.882207,78.082300));
        PCARCH.add(new LatLng(9.881980,78.082442));
        PCARCH.add(new LatLng(9.881980,78.083002));
        PCARCH.add(new LatLng(9.882124,78.083002));
        PCARCH.add(new LatLng(9.882124,78.083251));
        PCARCH.add(new LatLng(9.882124,78.083426));
        PCARCH.add(new LatLng(9.881682,78.083426));
        PCARCH.add(new LatLng(9.881301,78.083517));
        PCARCH.add(new LatLng(9.880672,78.083442));
        PCARCH.add(new LatLng(9.880558,78.083080));
        PCARCH.add(new LatLng(9.880201,78.083158));
        PCARCH.add(new LatLng(9.878790,78.082110));



        PCSCIENCEBLOCK.add(new LatLng(9.885026,78.080954));
        PCSCIENCEBLOCK.add(new LatLng(9.885035,78.080792));
        PCSCIENCEBLOCK.add(new LatLng(9.884735,78.080781));
        PCSCIENCEBLOCK.add(new LatLng(9.883896,78.080727));
        PCSCIENCEBLOCK.add(new LatLng(9.883368,78.080711));
        PCSCIENCEBLOCK.add(new LatLng(9.883286,78.080765));
        PCSCIENCEBLOCK.add(new LatLng(9.883262,78.080870));
        PCSCIENCEBLOCK.add(new LatLng(9.883234,78.081681));
        PCSCIENCEBLOCK.add(new LatLng(9.882399,78.081653));
        PCSCIENCEBLOCK.add(new LatLng(9.882321,78.081682));
        PCSCIENCEBLOCK.add(new LatLng(9.882207,78.082300));
        PCSCIENCEBLOCK.add(new LatLng(9.881980,78.082442));
        PCSCIENCEBLOCK.add(new LatLng(9.881980,78.083002));
        PCSCIENCEBLOCK.add(new LatLng(9.881980,78.083111));
        PCSCIENCEBLOCK.add(new LatLng(9.881876,78.083152));



        PCFRESHERBLOCK.add(new LatLng(9.885026,78.080954));
        PCFRESHERBLOCK.add(new LatLng(9.885035,78.080792));
        PCFRESHERBLOCK.add(new LatLng(9.884735,78.080781));
        PCFRESHERBLOCK.add(new LatLng(9.883896,78.080727));
        PCFRESHERBLOCK.add(new LatLng(9.883368,78.080711));
        PCFRESHERBLOCK.add(new LatLng(9.883286,78.080765));
        PCFRESHERBLOCK.add(new LatLng(9.883262,78.080870));
        PCFRESHERBLOCK.add(new LatLng(9.883234,78.081681));
        PCFRESHERBLOCK.add(new LatLng(9.882399,78.081653));
        PCFRESHERBLOCK.add(new LatLng(9.882321,78.081682));
        PCFRESHERBLOCK.add(new LatLng(9.882207,78.082300));
        PCFRESHERBLOCK.add(new LatLng(9.881980,78.082442));
        PCFRESHERBLOCK.add(new LatLng(9.881980,78.082817));
        PCFRESHERBLOCK.add(new LatLng(9.88172,78.082617));



        PCNCCBLOCK.add(new LatLng(9.885026,78.080954));
        PCNCCBLOCK.add(new LatLng(9.885035,78.080792));
        PCNCCBLOCK.add(new LatLng(9.884735,78.080781));
        PCNCCBLOCK.add(new LatLng(9.883896,78.080727));
        PCNCCBLOCK.add(new LatLng(9.883483,78.080696));
        PCNCCBLOCK.add(new LatLng(9.883560,78.079803));



        PCINDOOR.add(new LatLng(9.885026,78.080954));
        PCINDOOR.add(new LatLng(9.885035,78.080792));
        PCINDOOR.add(new LatLng(9.884735,78.080781));
        PCINDOOR.add(new LatLng(9.883896,78.080727));
        PCINDOOR.add(new LatLng(9.883368,78.080711));
        PCINDOOR.add(new LatLng(9.883286,78.080765));
        PCINDOOR.add(new LatLng(9.883262,78.080870));
        PCINDOOR.add(new LatLng(9.883236,78.081653));
        PCINDOOR.add(new LatLng(9.882771,78.081653));
        PCINDOOR.add(new LatLng(9.882399,78.081653));
        PCINDOOR.add(new LatLng(9.882321,78.081682));
        PCINDOOR.add(new LatLng(9.882207,78.082300));
        PCINDOOR.add(new LatLng(9.881980,78.082442));
        PCINDOOR.add(new LatLng(9.881980,78.083002));
        PCINDOOR.add(new LatLng(9.882124,78.083002));
        PCINDOOR.add(new LatLng(9.882124,78.083251));
        PCINDOOR.add(new LatLng(9.882124,78.083426));
        PCINDOOR.add(new LatLng(9.881682,78.083426));
        PCINDOOR.add(new LatLng(9.881452,78.083488));
        PCINDOOR.add(new LatLng(9.881540,78.082662));
        PCINDOOR.add(new LatLng(9.880959,78.082606));
        PCINDOOR.add(new LatLng(9.880761,78.082324));
        PCINDOOR.add(new LatLng(9.880621,78.082225));
        PCINDOOR.add(new LatLng(9.879701,78.081978));
        PCINDOOR.add(new LatLng(9.879215,78.081785));
        PCINDOOR.add(new LatLng(9.878496,78.081654));
        PCINDOOR.add(new LatLng(9.877774,78.081405));
        PCINDOOR.add(new LatLng(9.877578,78.081330));
        PCINDOOR.add(new LatLng(9.877596,78.080995));
        PCINDOOR.add(new LatLng(9.882838,78.082683));



        PCOUTDOOR.add(new LatLng(9.885026,78.080954));
        PCOUTDOOR.add(new LatLng(9.885035,78.080792));
        PCOUTDOOR.add(new LatLng(9.884735,78.080781));
        PCOUTDOOR.add(new LatLng(9.883759,78.080721));
        PCOUTDOOR.add(new LatLng(9.883842,78.081407));



        PCKSAUDITORIUM.add(new LatLng(9.885026,78.080954));
        PCKSAUDITORIUM.add(new LatLng(9.885035,78.080792));
        PCKSAUDITORIUM.add(new LatLng(9.884735,78.080781));
        PCKSAUDITORIUM.add(new LatLng(9.883896,78.080727));
        PCKSAUDITORIUM.add(new LatLng(9.883368,78.080711));
        PCKSAUDITORIUM.add(new LatLng(9.883286,78.080765));
        PCKSAUDITORIUM.add(new LatLng(9.883262,78.080870));
        PCKSAUDITORIUM.add(new LatLng(9.883227,78.081976));
        PCKSAUDITORIUM.add(new LatLng(9.885026,78.080954));



        PCKMAUDITORIUM.add(new LatLng(9.885026,78.080954));
        PCKMAUDITORIUM.add(new LatLng(9.885035,78.080792));
        PCKMAUDITORIUM.add(new LatLng(9.884735,78.080781));
        PCKMAUDITORIUM.add(new LatLng(9.883896,78.080727));
        PCKMAUDITORIUM.add(new LatLng(9.883368,78.080711));
        PCKMAUDITORIUM.add(new LatLng(9.883286,78.080765));
        PCKMAUDITORIUM.add(new LatLng(9.883262,78.080870));
        PCKMAUDITORIUM.add(new LatLng(9.883210,78.082540));
        PCKMAUDITORIUM.add(new LatLng(9.882716,78.082540));
        PCKMAUDITORIUM.add(new LatLng(9.882480,78.082541));



        PCGUESTHOUSE.add(new LatLng(9.885026,78.080954));
        PCGUESTHOUSE.add(new LatLng(9.885033,78.080787));
        PCGUESTHOUSE.add(new LatLng(9.885210,78.080791));
        PCGUESTHOUSE.add(new LatLng(9.885211,78.080632));



        PCMAINCANTEEN.add(new LatLng(9.885026,78.080954));
        PCMAINCANTEEN.add(new LatLng(9.885033,78.080787));
        PCMAINCANTEEN.add(new LatLng(9.883286,78.080765));
        PCMAINCANTEEN.add(new LatLng(9.883277,78.080255));
        PCMAINCANTEEN.add(new LatLng(9.883264,78.079857));



        PCFOODCOURT.add(new LatLng(9.885026,78.080954));
        PCFOODCOURT.add(new LatLng(9.885033,78.080787));
        PCFOODCOURT.add(new LatLng(9.883458,78.080706));
        PCFOODCOURT.add(new LatLng(9.883286,78.080765));
        PCFOODCOURT.add(new LatLng(9.883262,78.080870));
        PCFOODCOURT.add(new LatLng(9.883234,78.081681));
        PCFOODCOURT.add(new LatLng(9.883234,78.082540));
        PCFOODCOURT.add(new LatLng(9.883234,78.083246));
        PCFOODCOURT.add(new LatLng(9.883282,78.083236));



        PCMENSHOSTEL.add(new LatLng(9.885026,78.080954));
        PCMENSHOSTEL.add(new LatLng(9.885033,78.080787));
        PCMENSHOSTEL.add(new LatLng(9.883896,78.080727));
        PCMENSHOSTEL.add(new LatLng(9.884735,78.080781));
        PCMENSHOSTEL.add(new LatLng(9.884765,78.080405));
        PCMENSHOSTEL.add(new LatLng(9.884738,78.080071));



        PCWOMENSHOSTEL.add(new LatLng(9.885026,78.080954));
        PCWOMENSHOSTEL.add(new LatLng(9.885033,78.080787));
        PCWOMENSHOSTEL.add(new LatLng(9.883458,78.080706));
        PCWOMENSHOSTEL.add(new LatLng(9.883286,78.080765));
        PCWOMENSHOSTEL.add(new LatLng(9.883262,78.080870));
        PCWOMENSHOSTEL.add(new LatLng(9.883234,78.081681));
        PCWOMENSHOSTEL.add(new LatLng(9.882399,78.081653));
        PCWOMENSHOSTEL.add(new LatLng(9.882321,78.081682));
        PCWOMENSHOSTEL.add(new LatLng(9.882207,78.082300));
        PCWOMENSHOSTEL.add(new LatLng(9.881980,78.082442));
        PCWOMENSHOSTEL.add(new LatLng(9.881980,78.083002));
        PCWOMENSHOSTEL.add(new LatLng(9.882124,78.083002));
        PCWOMENSHOSTEL.add(new LatLng(9.882124,78.083251));
        PCWOMENSHOSTEL.add(new LatLng(9.882124,78.083426));
        PCWOMENSHOSTEL.add(new LatLng(9.881682,78.083426));
        PCWOMENSHOSTEL.add(new LatLng(9.881301,78.083517));
        PCWOMENSHOSTEL.add(new LatLng(9.880672,78.083442));
        PCWOMENSHOSTEL.add(new LatLng(9.880375,78.083386));
        PCWOMENSHOSTEL.add(new LatLng(9.879979,78.083493));
        PCWOMENSHOSTEL.add(new LatLng(9.879832,78.083329));
        PCWOMENSHOSTEL.add(new LatLng(9.879632,78.083372));
        PCWOMENSHOSTEL.add(new LatLng(9.879518,78.082975));
        PCWOMENSHOSTEL.add(new LatLng(9.879373,78.082685));
        PCWOMENSHOSTEL.add(new LatLng(9.879288,78.082626));
        PCWOMENSHOSTEL.add(new LatLng(9.878910,78.082653));
        PCWOMENSHOSTEL.add(new LatLng(9.878479,78.082776));
        PCWOMENSHOSTEL.add(new LatLng(9.878434,78.082095));
        PCWOMENSHOSTEL.add(new LatLng(9.878201,78.082072));



        PCLIBRARY.add(new LatLng(9.885026,78.080954));
        PCLIBRARY.add(new LatLng(9.885033,78.080787));
        PCLIBRARY.add(new LatLng(9.883458,78.080706));
        PCLIBRARY.add(new LatLng(9.883286,78.080765));
        PCLIBRARY.add(new LatLng(9.883262,78.080870));
        PCLIBRARY.add(new LatLng(9.883262,78.081264));
        PCLIBRARY.add(new LatLng(9.882854,78.081243));



        PCBANK.add(new LatLng(9.885026,78.080954));
        PCBANK.add(new LatLng(9.885033,78.080787));
        PCBANK.add(new LatLng(9.883458,78.080706));
        PCBANK.add(new LatLng(9.883496,78.079848));



        PCTEMPLE.add(new LatLng(9.885026,78.080954));
        PCTEMPLE.add(new LatLng(9.885033,78.080787));
        PCTEMPLE.add(new LatLng(9.885443,78.080804));
        PCTEMPLE.add(new LatLng(9.885459,78.080574));



        PCPARKING.add(new LatLng(9.885026,78.080954));
        PCPARKING.add(new LatLng(9.885033,78.080787));
        PCPARKING.add(new LatLng(9.883250,78.080715));
        PCPARKING.add(new LatLng(9.882416,78.080715));
        PCPARKING.add(new LatLng(9.882416,78.080942));
        PCPARKING.add(new LatLng(9.882769,78.080846));
    }
    public void initGuestHouseCoordinates()
    {
        GHMAINBUILDING.add(new LatLng(9.885211,78.080632));
        GHMAINBUILDING.add(new LatLng(9.885219,78.080794));
        GHMAINBUILDING.add(new LatLng(9.883458,78.080706));
        GHMAINBUILDING.add(new LatLng(9.883286,78.080765));
        GHMAINBUILDING.add(new LatLng(9.883262,78.080870));
        GHMAINBUILDING.add(new LatLng(9.883236,78.081833));
        GHMAINBUILDING.add(new LatLng(9.883225,78.082341));
        GHMAINBUILDING.add(new LatLng(9.883225,78.082530));
        GHMAINBUILDING.add(new LatLng(9.882881,78.082511));

        GHIT.add(new LatLng(9.885211,78.080632));
        GHIT.add(new LatLng(9.885210,78.080791));
        GHIT.add(new LatLng(9.885035,78.080792));
        GHIT.add(new LatLng(9.884735,78.080781));
        GHIT.add(new LatLng(9.883896,78.080727));
        GHIT.add(new LatLng(9.883368,78.080711));
        GHIT.add(new LatLng(9.883286,78.080765));
        GHIT.add(new LatLng(9.883262,78.080870));
        GHIT.add(new LatLng(9.883236,78.081833));
        GHIT.add(new LatLng(9.883211,78.082630));
        GHIT.add(new LatLng(9.883168,78.083267));
        GHIT.add(new LatLng(9.882982,78.083423));
        GHIT.add(new LatLng(9.882397,78.083426));
        GHIT.add(new LatLng(9.882397,78.083506));
        GHIT.add(new LatLng(9.882397,78.083569));
        GHIT.add(new LatLng(9.882399,78.083630));

        GHCSE.add(new LatLng(9.885211,78.080632));
        GHCSE.add(new LatLng(9.885210,78.080791));
        GHCSE.add(new LatLng(9.885035,78.080792));
        GHCSE.add(new LatLng(9.884735,78.080781));
        GHCSE.add(new LatLng(9.883896,78.080727));
        GHCSE.add(new LatLng(9.883368,78.080711));
        GHCSE.add(new LatLng(9.883286,78.080765));
        GHCSE.add(new LatLng(9.883262,78.080870));
        GHCSE.add(new LatLng(9.883236,78.081833));
        GHCSE.add(new LatLng(9.883211,78.082630));
        GHCSE.add(new LatLng(9.883168,78.083267));
        GHCSE.add(new LatLng(9.882982,78.083423));
        GHCSE.add(new LatLng(9.882893,78.083421));
        GHCSE.add(new LatLng(9.882884,78.083593));
        GHCSE.add(new LatLng(9.882896,78.083745));
        GHCSE.add(new LatLng(9.882797,78.083739));

        GHECE.add(new LatLng(9.885211,78.080632));
        GHECE.add(new LatLng(9.885210,78.080791));
        GHECE.add(new LatLng(9.885035,78.080792));
        GHECE.add(new LatLng(9.884735,78.080781));
        GHECE.add(new LatLng(9.883896,78.080727));
        GHECE.add(new LatLng(9.883368,78.080711));
        GHECE.add(new LatLng(9.883286,78.080765));
        GHECE.add(new LatLng(9.883262,78.080870));
        GHECE.add(new LatLng(9.883236,78.081833));
        GHECE.add(new LatLng(9.883225,78.082341));
        GHECE.add(new LatLng(9.883016,78.082341));
        GHECE.add(new LatLng(9.882820,78.082338));

        GHEEE.add(new LatLng(9.885211,78.080632));
        GHEEE.add(new LatLng(9.885210,78.080791));
        GHEEE.add(new LatLng(9.885035,78.080792));
        GHEEE.add(new LatLng(9.884735,78.080781));
        GHEEE.add(new LatLng(9.883896,78.080727));
        GHEEE.add(new LatLng(9.883368,78.080711));
        GHEEE.add(new LatLng(9.883286,78.080765));
        GHEEE.add(new LatLng(9.883262,78.080870));
        GHEEE.add(new LatLng(9.883225,78.081854));
        GHEEE.add(new LatLng(9.882816,78.081854));
        GHEEE.add(new LatLng(9.882466,78.081854));
        GHEEE.add(new LatLng(9.882466,78.082038));
        GHEEE.add(new LatLng(9.882433,78.082086));

        GHCIVIL.add(new LatLng(9.885211,78.080632));
        GHCIVIL.add(new LatLng(9.885210,78.080791));
        GHCIVIL.add(new LatLng(9.885035,78.080792));
        GHCIVIL.add(new LatLng(9.884735,78.080781));
        GHCIVIL.add(new LatLng(9.883896,78.080727));
        GHCIVIL.add(new LatLng(9.883368,78.080711));
        GHCIVIL.add(new LatLng(9.883286,78.080765));
        GHCIVIL.add(new LatLng(9.883262,78.080870));
        GHCIVIL.add(new LatLng(9.883225,78.081854));
        GHCIVIL.add(new LatLng(9.882816,78.081854));
        GHCIVIL.add(new LatLng(9.882466,78.081854));
        GHCIVIL.add(new LatLng(9.882464,78.082037));
        GHCIVIL.add(new LatLng(9.882464,78.082333));
        GHCIVIL.add(new LatLng(9.882464,78.082422));
        GHCIVIL.add(new LatLng(9.882341,78.082422));
        GHCIVIL.add(new LatLng(9.882341,78.082764));
        GHCIVIL.add(new LatLng(9.882278,78.082855));

        GHMECH.add(new LatLng(9.885211,78.080632));
        GHMECH.add(new LatLng(9.885210,78.080791));
        GHMECH.add(new LatLng(9.885035,78.080792));
        GHMECH.add(new LatLng(9.884735,78.080781));
        GHMECH.add(new LatLng(9.883896,78.080727));
        GHMECH.add(new LatLng(9.883368,78.080711));
        GHMECH.add(new LatLng(9.883286,78.080765));
        GHMECH.add(new LatLng(9.883262,78.080870));
        GHMECH.add(new LatLng(9.883234,78.081681));
        GHMECH.add(new LatLng(9.882949,78.081681));
        GHMECH.add(new LatLng(9.882707,78.081253));
        GHMECH.add(new LatLng(9.882365,78.081429));

        GHMECHT.add(new LatLng(9.885211,78.080632));
        GHMECHT.add(new LatLng(9.885210,78.080791));
        GHMECHT.add(new LatLng(9.885035,78.080792));
        GHMECHT.add(new LatLng(9.884735,78.080781));
        GHMECHT.add(new LatLng(9.883896,78.080727));
        GHMECHT.add(new LatLng(9.883368,78.080711));
        GHMECHT.add(new LatLng(9.883286,78.080765));
        GHMECHT.add(new LatLng(9.883262,78.080870));
        GHMECHT.add(new LatLng(9.883234,78.081681));
        GHMECHT.add(new LatLng(9.882949,78.081681));
        GHMECHT.add(new LatLng(9.882707,78.081253));
        GHMECHT.add(new LatLng(9.882365,78.081428));

        GHARCH.add(new LatLng(9.885211,78.080632));
        GHARCH.add(new LatLng(9.885210,78.080791));
        GHARCH.add(new LatLng(9.885035,78.080792));
        GHARCH.add(new LatLng(9.884735,78.080781));
        GHARCH.add(new LatLng(9.883896,78.080727));
        GHARCH.add(new LatLng(9.883368,78.080711));
        GHARCH.add(new LatLng(9.883286,78.080765));
        GHARCH.add(new LatLng(9.883262,78.080870));
        GHARCH.add(new LatLng(9.883236,78.081653));
        GHARCH.add(new LatLng(9.882771,78.081653));
        GHARCH.add(new LatLng(9.882399,78.081653));
        GHARCH.add(new LatLng(9.882321,78.081682));
        GHARCH.add(new LatLng(9.882207,78.082300));
        GHARCH.add(new LatLng(9.881980,78.082442));
        GHARCH.add(new LatLng(9.881980,78.083002));
        GHARCH.add(new LatLng(9.882124,78.083002));
        GHARCH.add(new LatLng(9.882124,78.083251));
        GHARCH.add(new LatLng(9.882124,78.083426));
        GHARCH.add(new LatLng(9.881682,78.083426));
        GHARCH.add(new LatLng(9.881301,78.083517));
        GHARCH.add(new LatLng(9.880672,78.083442));
        GHARCH.add(new LatLng(9.880558,78.083080));
        GHARCH.add(new LatLng(9.880201,78.083158));
        GHARCH.add(new LatLng(9.878790,78.082110));

        GHSCIENCEBLOCK.add(new LatLng(9.885211,78.080632));
        GHSCIENCEBLOCK.add(new LatLng(9.885210,78.080791));
        GHSCIENCEBLOCK.add(new LatLng(9.885035,78.080792));
        GHSCIENCEBLOCK.add(new LatLng(9.884735,78.080781));
        GHSCIENCEBLOCK.add(new LatLng(9.883896,78.080727));
        GHSCIENCEBLOCK.add(new LatLng(9.883368,78.080711));
        GHSCIENCEBLOCK.add(new LatLng(9.883286,78.080765));
        GHSCIENCEBLOCK.add(new LatLng(9.883262,78.080870));
        GHSCIENCEBLOCK.add(new LatLng(9.883234,78.081681));
        GHSCIENCEBLOCK.add(new LatLng(9.882399,78.081653));
        GHSCIENCEBLOCK.add(new LatLng(9.882321,78.081682));
        GHSCIENCEBLOCK.add(new LatLng(9.882207,78.082300));
        GHSCIENCEBLOCK.add(new LatLng(9.881980,78.082442));
        GHSCIENCEBLOCK.add(new LatLng(9.881980,78.083002));
        GHSCIENCEBLOCK.add(new LatLng(9.881980,78.083111));
        GHSCIENCEBLOCK.add(new LatLng(9.881876,78.083152));

        GHFRESHERBLOCK.add(new LatLng(9.885211,78.080632));
        GHFRESHERBLOCK.add(new LatLng(9.885210,78.080791));
        GHFRESHERBLOCK.add(new LatLng(9.885035,78.080792));
        GHFRESHERBLOCK.add(new LatLng(9.884735,78.080781));
        GHFRESHERBLOCK.add(new LatLng(9.883896,78.080727));
        GHFRESHERBLOCK.add(new LatLng(9.883368,78.080711));
        GHFRESHERBLOCK.add(new LatLng(9.883286,78.080765));
        GHFRESHERBLOCK.add(new LatLng(9.883262,78.080870));
        GHFRESHERBLOCK.add(new LatLng(9.883234,78.081681));
        GHFRESHERBLOCK.add(new LatLng(9.882399,78.081653));
        GHFRESHERBLOCK.add(new LatLng(9.882321,78.081682));
        GHFRESHERBLOCK.add(new LatLng(9.882207,78.082300));
        GHFRESHERBLOCK.add(new LatLng(9.881980,78.082442));
        GHFRESHERBLOCK.add(new LatLng(9.881980,78.082817));
        GHFRESHERBLOCK.add(new LatLng(9.88172,78.082617));

        GHNCCBLOCK.add(new LatLng(9.885211,78.080632));
        GHNCCBLOCK.add(new LatLng(9.885210,78.080791));
        GHNCCBLOCK.add(new LatLng(9.885035,78.080792));
        GHNCCBLOCK.add(new LatLng(9.884735,78.080781));
        GHNCCBLOCK.add(new LatLng(9.883896,78.080727));
        GHNCCBLOCK.add(new LatLng(9.883483,78.080696));
        GHNCCBLOCK.add(new LatLng(9.883560,78.079803));

        GHINDOOR.add(new LatLng(9.885211,78.080632));
        GHINDOOR.add(new LatLng(9.885210,78.080791));
        GHINDOOR.add(new LatLng(9.885035,78.080792));
        GHINDOOR.add(new LatLng(9.884735,78.080781));
        GHINDOOR.add(new LatLng(9.883896,78.080727));
        GHINDOOR.add(new LatLng(9.883368,78.080711));
        GHINDOOR.add(new LatLng(9.883286,78.080765));
        GHINDOOR.add(new LatLng(9.883262,78.080870));
        GHINDOOR.add(new LatLng(9.883236,78.081653));
        GHINDOOR.add(new LatLng(9.882771,78.081653));
        GHINDOOR.add(new LatLng(9.882399,78.081653));
        GHINDOOR.add(new LatLng(9.882321,78.081682));
        GHINDOOR.add(new LatLng(9.882207,78.082300));
        GHINDOOR.add(new LatLng(9.881980,78.082442));
        GHINDOOR.add(new LatLng(9.881980,78.083002));
        GHINDOOR.add(new LatLng(9.882124,78.083002));
        GHINDOOR.add(new LatLng(9.882124,78.083251));
        GHINDOOR.add(new LatLng(9.882124,78.083426));
        GHINDOOR.add(new LatLng(9.881682,78.083426));
        GHINDOOR.add(new LatLng(9.881452,78.083488));
        GHINDOOR.add(new LatLng(9.881540,78.082662));
        GHINDOOR.add(new LatLng(9.880959,78.082606));
        GHINDOOR.add(new LatLng(9.880761,78.082324));
        GHINDOOR.add(new LatLng(9.880621,78.082225));
        GHINDOOR.add(new LatLng(9.879701,78.081978));
        GHINDOOR.add(new LatLng(9.879215,78.081785));
        GHINDOOR.add(new LatLng(9.878496,78.081654));
        GHINDOOR.add(new LatLng(9.877774,78.081405));
        GHINDOOR.add(new LatLng(9.877578,78.081330));
        GHINDOOR.add(new LatLng(9.877596,78.080995));
        GHINDOOR.add(new LatLng(9.882838,78.082683));

        GHOUTDOOR.add(new LatLng(9.885211,78.080632));
        GHOUTDOOR.add(new LatLng(9.885210,78.080791));
        GHOUTDOOR.add(new LatLng(9.885035,78.080792));
        GHOUTDOOR.add(new LatLng(9.884735,78.080781));
        GHOUTDOOR.add(new LatLng(9.883759,78.080721));
        GHOUTDOOR.add(new LatLng(9.883842,78.081407));

        GHKSAUDITORIUM.add(new LatLng(9.885211,78.080632));
        GHKSAUDITORIUM.add(new LatLng(9.885210,78.080791));
        GHKSAUDITORIUM.add(new LatLng(9.885035,78.080792));
        GHKSAUDITORIUM.add(new LatLng(9.884735,78.080781));
        GHKSAUDITORIUM.add(new LatLng(9.883896,78.080727));
        GHKSAUDITORIUM.add(new LatLng(9.883368,78.080711));
        GHKSAUDITORIUM.add(new LatLng(9.883286,78.080765));
        GHKSAUDITORIUM.add(new LatLng(9.883262,78.080870));
        GHKSAUDITORIUM.add(new LatLng(9.883227,78.081976));
        GHKSAUDITORIUM.add(new LatLng(9.882820,78.082337));

        GHKMAUDITORIUM.add(new LatLng(9.885211,78.080632));
        GHKMAUDITORIUM.add(new LatLng(9.885210,78.080791));
        GHKMAUDITORIUM.add(new LatLng(9.885035,78.080792));
        GHKMAUDITORIUM.add(new LatLng(9.884735,78.080781));
        GHKMAUDITORIUM.add(new LatLng(9.883896,78.080727));
        GHKMAUDITORIUM.add(new LatLng(9.883368,78.080711));
        GHKMAUDITORIUM.add(new LatLng(9.883286,78.080765));
        GHKMAUDITORIUM.add(new LatLng(9.883262,78.080870));
        GHKMAUDITORIUM.add(new LatLng(9.883210,78.082540));
        GHKMAUDITORIUM.add(new LatLng(9.882716,78.082540));
        GHKMAUDITORIUM.add(new LatLng(9.882480,78.082541));

        GHPLACEMENTCELL.add(new LatLng(9.885211,78.080632));
        GHPLACEMENTCELL.add(new LatLng(9.885210,78.080791));
        GHPLACEMENTCELL.add(new LatLng(9.885033,78.080787));
        GHPLACEMENTCELL.add(new LatLng(9.885026,78.080954));

        GHMAINCANTEEN.add(new LatLng(9.885211,78.080632));
        GHMAINCANTEEN.add(new LatLng(9.885219,78.080794));
        GHMAINCANTEEN.add(new LatLng(9.883286,78.080765));
        GHMAINCANTEEN.add(new LatLng(9.883277,78.080255));
        GHMAINCANTEEN.add(new LatLng(9.883264,78.079857));

        GHFOODCOURT.add(new LatLng(9.885211,78.080632));
        GHFOODCOURT.add(new LatLng(9.885219,78.080794));
        GHFOODCOURT.add(new LatLng(9.883458,78.080706));
        GHFOODCOURT.add(new LatLng(9.883286,78.080765));
        GHFOODCOURT.add(new LatLng(9.883262,78.080870));
        GHFOODCOURT.add(new LatLng(9.883234,78.081681));
        GHFOODCOURT.add(new LatLng(9.883234,78.082540));
        GHFOODCOURT.add(new LatLng(9.883234,78.083246));
        GHFOODCOURT.add(new LatLng(9.883282,78.083236));

        GHMENSHOSTEL.add(new LatLng(9.885211,78.080632));
        GHMENSHOSTEL.add(new LatLng(9.885219,78.080794));
        GHMENSHOSTEL.add(new LatLng(9.884735,78.080781));
        GHMENSHOSTEL.add(new LatLng(9.884765,78.080405));
        GHMENSHOSTEL.add(new LatLng(9.884738,78.080071));

        GHWOMENSHOSTEL.add(new LatLng(9.885211,78.080632));
        GHWOMENSHOSTEL.add(new LatLng(9.885219,78.080794));
        GHWOMENSHOSTEL.add(new LatLng(9.883458,78.080706));
        GHWOMENSHOSTEL.add(new LatLng(9.883286,78.080765));
        GHWOMENSHOSTEL.add(new LatLng(9.883262,78.080870));
        GHWOMENSHOSTEL.add(new LatLng(9.883234,78.081681));
        GHWOMENSHOSTEL.add(new LatLng(9.882399,78.081653));
        GHWOMENSHOSTEL.add(new LatLng(9.882321,78.081682));
        GHWOMENSHOSTEL.add(new LatLng(9.882207,78.082300));
        GHWOMENSHOSTEL.add(new LatLng(9.881980,78.082442));
        GHWOMENSHOSTEL.add(new LatLng(9.881980,78.083002));
        GHWOMENSHOSTEL.add(new LatLng(9.882124,78.083002));
        GHWOMENSHOSTEL.add(new LatLng(9.882124,78.083251));
        GHWOMENSHOSTEL.add(new LatLng(9.882124,78.083426));
        GHWOMENSHOSTEL.add(new LatLng(9.881682,78.083426));
        GHWOMENSHOSTEL.add(new LatLng(9.881301,78.083517));
        GHWOMENSHOSTEL.add(new LatLng(9.880672,78.083442));
        GHWOMENSHOSTEL.add(new LatLng(9.880375,78.083386));
        GHWOMENSHOSTEL.add(new LatLng(9.879979,78.083493));
        GHWOMENSHOSTEL.add(new LatLng(9.879832,78.083329));
        GHWOMENSHOSTEL.add(new LatLng(9.879632,78.083372));
        GHWOMENSHOSTEL.add(new LatLng(9.879518,78.082975));
        GHWOMENSHOSTEL.add(new LatLng(9.879373,78.082685));
        GHWOMENSHOSTEL.add(new LatLng(9.879288,78.082626));
        GHWOMENSHOSTEL.add(new LatLng(9.878910,78.082653));
        GHWOMENSHOSTEL.add(new LatLng(9.878479,78.082776));
        GHWOMENSHOSTEL.add(new LatLng(9.878434,78.082095));
        GHWOMENSHOSTEL.add(new LatLng(9.878201,78.082072));

        GHLIBRARY.add(new LatLng(9.885211,78.080632));
        GHLIBRARY.add(new LatLng(9.885219,78.080794));
        GHLIBRARY.add(new LatLng(9.883458,78.080706));
        GHLIBRARY.add(new LatLng(9.883286,78.080765));
        GHLIBRARY.add(new LatLng(9.883262,78.080870));
        GHLIBRARY.add(new LatLng(9.883262,78.081264));
        GHLIBRARY.add(new LatLng(9.882854,78.081243));

        GHBANK.add(new LatLng(9.885211,78.080632));
        GHBANK.add(new LatLng(9.885219,78.080794));
        GHBANK.add(new LatLng(9.883458,78.080706));
        GHBANK.add(new LatLng(9.883496,78.079848));

        GHTEMPLE.add(new LatLng(9.885211,78.080632));
        GHTEMPLE.add(new LatLng(9.885219,78.080794));
        GHTEMPLE.add(new LatLng(9.885443,78.080804));
        GHTEMPLE.add(new LatLng(9.885459,78.080574));

        GHPARKING.add(new LatLng(9.885211,78.080632));
        GHPARKING.add(new LatLng(9.885219,78.080794));
        GHPARKING.add(new LatLng(9.883458,78.080706));
        GHPARKING.add(new LatLng(9.883250,78.080715));
        GHPARKING.add(new LatLng(9.882416,78.080715));
        GHPARKING.add(new LatLng(9.882416,78.080942));
        GHPARKING.add(new LatLng(9.882769,78.080846));
    }
    public void initMainCanteenCoordinates()
    {
        //Main Canteen to Main Building
        MCMAINBUILDING.add(new LatLng(9.883264,78.079857));
        MCMAINBUILDING.add(new LatLng(9.883277,78.080255));
        MCMAINBUILDING.add(new LatLng(9.883286,78.080765));
        MCMAINBUILDING.add(new LatLng(9.883236,78.081833));
        MCMAINBUILDING.add(new LatLng(9.883225,78.082341));
        MCMAINBUILDING.add(new LatLng(9.883225,78.082530));
        MCMAINBUILDING.add(new LatLng(9.882855,78.082530));

        MCIT.add(new LatLng(9.883264,78.079857));
        MCIT.add(new LatLng(9.883277,78.080255));
        MCIT.add(new LatLng(9.883286,78.080765));
        MCIT.add(new LatLng(9.883262,78.080870));
        MCIT.add(new LatLng(9.883236,78.081833));
        MCIT.add(new LatLng(9.883211,78.082630));
        MCIT.add(new LatLng(9.883168,78.083267));
        MCIT.add(new LatLng(9.882982,78.083423));
        MCIT.add(new LatLng(9.882397,78.083426));
        MCIT.add(new LatLng(9.882397,78.083506));
        MCIT.add(new LatLng(9.882397,78.083569));
        MCIT.add(new LatLng(9.882399,78.083630));

        MCCSE.add(new LatLng(9.883264,78.079857));
        MCCSE.add(new LatLng(9.883277,78.080255));
        MCCSE.add(new LatLng(9.883286,78.080765));
        MCCSE.add(new LatLng(9.883262,78.080870));
        MCCSE.add(new LatLng(9.883236,78.081833));
        MCCSE.add(new LatLng(9.883211,78.082630));
        MCCSE.add(new LatLng(9.883168,78.083267));
        MCCSE.add(new LatLng(9.882982,78.083423));
        MCCSE.add(new LatLng(9.882893,78.083421));
        MCCSE.add(new LatLng(9.882884,78.083593));
        MCCSE.add(new LatLng(9.882896,78.083745));
        MCCSE.add(new LatLng(9.882797,78.083739));

        MCECE.add(new LatLng(9.883264,78.079857));
        MCECE.add(new LatLng(9.883277,78.080255));
        MCECE.add(new LatLng(9.883286,78.080765));
        MCECE.add(new LatLng(9.883262,78.080870));
        MCECE.add(new LatLng(9.883236,78.081833));
        MCECE.add(new LatLng(9.883225,78.082341));
        MCECE.add(new LatLng(9.883016,78.082341));
        MCECE.add(new LatLng(9.882820,78.082338));

        MCEEE.add(new LatLng(9.883264,78.079857));
        MCEEE.add(new LatLng(9.883277,78.080255));
        MCEEE.add(new LatLng(9.883286,78.080765));
        MCEEE.add(new LatLng(9.883262,78.080870));
        MCEEE.add(new LatLng(9.883225,78.081854));
        MCEEE.add(new LatLng(9.882816,78.081854));
        MCEEE.add(new LatLng(9.882466,78.081854));
        MCEEE.add(new LatLng(9.882466,78.082038));
        MCEEE.add(new LatLng(9.882433,78.082086));

        MCCIVIL.add(new LatLng(9.883264,78.079857));
        MCCIVIL.add(new LatLng(9.883277,78.080255));
        MCCIVIL.add(new LatLng(9.883286,78.080765));
        MCCIVIL.add(new LatLng(9.883262,78.080870));
        MCCIVIL.add(new LatLng(9.883225,78.081854));
        MCCIVIL.add(new LatLng(9.882816,78.081854));
        MCCIVIL.add(new LatLng(9.882466,78.081854));
        MCCIVIL.add(new LatLng(9.882464,78.082037));
        MCCIVIL.add(new LatLng(9.882464,78.082333));
        MCCIVIL.add(new LatLng(9.882464,78.082422));
        MCCIVIL.add(new LatLng(9.882341,78.082422));
        MCCIVIL.add(new LatLng(9.882341,78.082764));
        MCCIVIL.add(new LatLng(9.882278,78.082855));

        MCMECH.add(new LatLng(9.883264,78.079857));
        MCMECH.add(new LatLng(9.883277,78.080255));
        MCMECH.add(new LatLng(9.883286,78.080765));
        MCMECH.add(new LatLng(9.883262,78.080870));
        MCMECH.add(new LatLng(9.883234,78.081681));
        MCMECH.add(new LatLng(9.882949,78.081681));
        MCMECH.add(new LatLng(9.882707,78.081253));
        MCMECH.add(new LatLng(9.882365,78.081429));

        MCMECHT.add(new LatLng(9.883264,78.079857));
        MCMECHT.add(new LatLng(9.883277,78.080255));
        MCMECHT.add(new LatLng(9.883286,78.080765));
        MCMECHT.add(new LatLng(9.883262,78.080870));
        MCMECHT.add(new LatLng(9.883234,78.081681));
        MCMECHT.add(new LatLng(9.882949,78.081681));
        MCMECHT.add(new LatLng(9.882707,78.081253));
        MCMECHT.add(new LatLng(9.882365,78.081428));

        MCARCH.add(new LatLng(9.883264,78.079857));
        MCARCH.add(new LatLng(9.883277,78.080255));
        MCARCH.add(new LatLng(9.883286,78.080765));
        MCARCH.add(new LatLng(9.883236,78.081653));
        MCARCH.add(new LatLng(9.882771,78.081653));
        MCARCH.add(new LatLng(9.882399,78.081653));
        MCARCH.add(new LatLng(9.882321,78.081682));
        MCARCH.add(new LatLng(9.882207,78.082300));
        MCARCH.add(new LatLng(9.881980,78.082442));
        MCARCH.add(new LatLng(9.881980,78.083002));
        MCARCH.add(new LatLng(9.882124,78.083002));
        MCARCH.add(new LatLng(9.882124,78.083251));
        MCARCH.add(new LatLng(9.882124,78.083426));
        MCARCH.add(new LatLng(9.881682,78.083426));
        MCARCH.add(new LatLng(9.881301,78.083517));
        MCARCH.add(new LatLng(9.880672,78.083442));
        MCARCH.add(new LatLng(9.880558,78.083080));
        MCARCH.add(new LatLng(9.880201,78.083158));
        MCARCH.add(new LatLng(9.878790,78.082110));

        MCSCIENCEBLOCK.add(new LatLng(9.883264,78.079857));
        MCSCIENCEBLOCK.add(new LatLng(9.883277,78.080255));
        MCSCIENCEBLOCK.add(new LatLng(9.883286,78.080765));
        MCSCIENCEBLOCK.add(new LatLng(9.883262,78.080870));
        MCSCIENCEBLOCK.add(new LatLng(9.883234,78.081681));
        MCSCIENCEBLOCK.add(new LatLng(9.882399,78.081653));
        MCSCIENCEBLOCK.add(new LatLng(9.882321,78.081682));
        MCSCIENCEBLOCK.add(new LatLng(9.882207,78.082300));
        MCSCIENCEBLOCK.add(new LatLng(9.881980,78.082442));
        MCSCIENCEBLOCK.add(new LatLng(9.881980,78.083002));
        MCSCIENCEBLOCK.add(new LatLng(9.881980,78.083111));
        MCSCIENCEBLOCK.add(new LatLng(9.881876,78.083152));

        MCFRESHERBLOCK.add(new LatLng(9.883264,78.079857));
        MCFRESHERBLOCK.add(new LatLng(9.883277,78.080255));
        MCFRESHERBLOCK.add(new LatLng(9.883286,78.080765));
        MCFRESHERBLOCK.add(new LatLng(9.883262,78.080870));
        MCFRESHERBLOCK.add(new LatLng(9.883234,78.081681));
        MCFRESHERBLOCK.add(new LatLng(9.882399,78.081653));
        MCFRESHERBLOCK.add(new LatLng(9.882321,78.081682));
        MCFRESHERBLOCK.add(new LatLng(9.882207,78.082300));
        MCFRESHERBLOCK.add(new LatLng(9.881980,78.082442));
        MCFRESHERBLOCK.add(new LatLng(9.881980,78.082817));
        MCFRESHERBLOCK.add(new LatLng(9.88172,78.082617));

        MCNCCBLOCK.add(new LatLng(9.883264,78.079857));
        MCNCCBLOCK.add(new LatLng(9.883294,78.080024));
        MCNCCBLOCK.add(new LatLng(9.883483,78.080020));
        MCNCCBLOCK.add(new LatLng(9.883560,78.079803));

        MCINDOOR.add(new LatLng(9.883264,78.079857));
        MCINDOOR.add(new LatLng(9.883277,78.080255));
        MCINDOOR.add(new LatLng(9.883286,78.080765));
        MCINDOOR.add(new LatLng(9.883236,78.081653));
        MCINDOOR.add(new LatLng(9.882771,78.081653));
        MCINDOOR.add(new LatLng(9.882399,78.081653));
        MCINDOOR.add(new LatLng(9.882321,78.081682));
        MCINDOOR.add(new LatLng(9.882207,78.082300));
        MCINDOOR.add(new LatLng(9.881980,78.082442));
        MCINDOOR.add(new LatLng(9.881980,78.083002));
        MCINDOOR.add(new LatLng(9.882124,78.083002));
        MCINDOOR.add(new LatLng(9.882124,78.083251));
        MCINDOOR.add(new LatLng(9.882124,78.083426));
        MCINDOOR.add(new LatLng(9.881682,78.083426));
        MCINDOOR.add(new LatLng(9.881452,78.083488));
        MCINDOOR.add(new LatLng(9.881540,78.082662));
        MCINDOOR.add(new LatLng(9.880959,78.082606));
        MCINDOOR.add(new LatLng(9.880761,78.082324));
        MCINDOOR.add(new LatLng(9.880621,78.082225));
        MCINDOOR.add(new LatLng(9.879701,78.081978));
        MCINDOOR.add(new LatLng(9.879215,78.081785));
        MCINDOOR.add(new LatLng(9.878496,78.081654));
        MCINDOOR.add(new LatLng(9.877774,78.081405));
        MCINDOOR.add(new LatLng(9.877578,78.081330));
        MCINDOOR.add(new LatLng(9.877596,78.080995));
        MCINDOOR.add(new LatLng(9.882838,78.082683));

        MCOUTDOOR.add(new LatLng(9.883264,78.079857));
        MCOUTDOOR.add(new LatLng(9.883277,78.080255));
        MCOUTDOOR.add(new LatLng(9.883277,78.080721));
        MCOUTDOOR.add(new LatLng(9.883759,78.080721));
        MCOUTDOOR.add(new LatLng(9.883842,78.081407));

        MCKSAUDITORIUM.add(new LatLng(9.883264,78.079857));
        MCKSAUDITORIUM.add(new LatLng(9.883277,78.080255));
        MCKSAUDITORIUM.add(new LatLng(9.883286,78.080765));
        MCKSAUDITORIUM.add(new LatLng(9.883262,78.080870));
        MCKSAUDITORIUM.add(new LatLng(9.883227,78.081976));
        MCKSAUDITORIUM.add(new LatLng(9.882820,78.082337));

        MCKMAUDITORIUM.add(new LatLng(9.883264,78.079857));
        MCKMAUDITORIUM.add(new LatLng(9.883277,78.080255));
        MCKMAUDITORIUM.add(new LatLng(9.883286,78.080765));
        MCKMAUDITORIUM.add(new LatLng(9.883262,78.080870));
        MCKMAUDITORIUM.add(new LatLng(9.883210,78.082540));
        MCKMAUDITORIUM.add(new LatLng(9.882716,78.082540));
        MCKMAUDITORIUM.add(new LatLng(9.882480,78.082541));

        MCPLACEMENTCELL.add(new LatLng(9.883264,78.079857));
        MCPLACEMENTCELL.add(new LatLng(9.883277,78.080255));
        MCPLACEMENTCELL.add(new LatLng(9.883286,78.080765));
        MCPLACEMENTCELL.add(new LatLng(9.885033,78.080787));
        MCPLACEMENTCELL.add(new LatLng(9.885026,78.080954));

        MCGUESTHOUSE.add(new LatLng(9.883264,78.079857));
        MCGUESTHOUSE.add(new LatLng(9.883277,78.080255));
        MCGUESTHOUSE.add(new LatLng(9.883286,78.080765));
        MCGUESTHOUSE.add(new LatLng(9.885219,78.080794));
        MCGUESTHOUSE.add(new LatLng(9.885211,78.080632));

        MCFOODCOURT.add(new LatLng(9.883264,78.079857));
        MCFOODCOURT.add(new LatLng(9.883277,78.080255));
        MCFOODCOURT.add(new LatLng(9.883286,78.080765));
        MCFOODCOURT.add(new LatLng(9.883234,78.081681));
        MCFOODCOURT.add(new LatLng(9.883234,78.082540));
        MCFOODCOURT.add(new LatLng(9.883234,78.083246));
        MCFOODCOURT.add(new LatLng(9.883282,78.083236));

        MCMENSHOSTEL.add(new LatLng(9.883264,78.079857));
        MCMENSHOSTEL.add(new LatLng(9.883277,78.080255));
        MCMENSHOSTEL.add(new LatLng(9.883286,78.080765));
        MCMENSHOSTEL.add(new LatLng(9.883896,78.080727));
        MCMENSHOSTEL.add(new LatLng(9.884735,78.080781));
        MCMENSHOSTEL.add(new LatLng(9.884765,78.080405));
        MCMENSHOSTEL.add(new LatLng(9.884738,78.080071));

        MCWOMENSHOSTEL.add(new LatLng(9.883264,78.079857));
        MCWOMENSHOSTEL.add(new LatLng(9.883277,78.080255));
        MCWOMENSHOSTEL.add(new LatLng(9.883286,78.080765));
        MCWOMENSHOSTEL.add(new LatLng(9.883234,78.081681));
        MCWOMENSHOSTEL.add(new LatLng(9.882399,78.081653));
        MCWOMENSHOSTEL.add(new LatLng(9.882321,78.081682));
        MCWOMENSHOSTEL.add(new LatLng(9.882207,78.082300));
        MCWOMENSHOSTEL.add(new LatLng(9.881980,78.082442));
        MCWOMENSHOSTEL.add(new LatLng(9.881980,78.083002));
        MCWOMENSHOSTEL.add(new LatLng(9.882124,78.083002));
        MCWOMENSHOSTEL.add(new LatLng(9.882124,78.083251));
        MCWOMENSHOSTEL.add(new LatLng(9.882124,78.083426));
        MCWOMENSHOSTEL.add(new LatLng(9.881682,78.083426));
        MCWOMENSHOSTEL.add(new LatLng(9.881301,78.083517));
        MCWOMENSHOSTEL.add(new LatLng(9.880672,78.083442));
        MCWOMENSHOSTEL.add(new LatLng(9.880375,78.083386));
        MCWOMENSHOSTEL.add(new LatLng(9.879979,78.083493));
        MCWOMENSHOSTEL.add(new LatLng(9.879832,78.083329));
        MCWOMENSHOSTEL.add(new LatLng(9.879632,78.083372));
        MCWOMENSHOSTEL.add(new LatLng(9.879518,78.082975));
        MCWOMENSHOSTEL.add(new LatLng(9.879373,78.082685));
        MCWOMENSHOSTEL.add(new LatLng(9.879288,78.082626));
        MCWOMENSHOSTEL.add(new LatLng(9.878910,78.082653));
        MCWOMENSHOSTEL.add(new LatLng(9.878479,78.082776));
        MCWOMENSHOSTEL.add(new LatLng(9.878434,78.082095));
        MCWOMENSHOSTEL.add(new LatLng(9.878201,78.082072));

        MCLIBRARY.add(new LatLng(9.883264,78.079857));
        MCLIBRARY.add(new LatLng(9.883277,78.080255));
        MCLIBRARY.add(new LatLng(9.883286,78.080765));
        MCLIBRARY.add(new LatLng(9.883262,78.081264));
        MCLIBRARY.add(new LatLng(9.882854,78.081243));

        MCBANK.add(new LatLng(9.883264,78.079857));
        MCBANK.add(new LatLng(9.883496,78.079848));

        MCTEMPLE.add(new LatLng(9.883264,78.079857));
        MCTEMPLE.add(new LatLng(9.883277,78.080255));
        MCTEMPLE.add(new LatLng(9.883286,78.080765));
        MCTEMPLE.add(new LatLng(9.885443,78.080804));
        MCTEMPLE.add(new LatLng(9.885459,78.080574));

        MCPARKING.add(new LatLng(9.883264,78.079857));
        MCPARKING.add(new LatLng(9.883277,78.080255));
        MCPARKING.add(new LatLng(9.883286,78.080765));
        MCPARKING.add(new LatLng(9.883250,78.080715));
        MCPARKING.add(new LatLng(9.882416,78.080715));
        MCPARKING.add(new LatLng(9.882416,78.080942));
        MCPARKING.add(new LatLng(9.883104,78.080942));
    }
    public void initFoodCourtCoordinates()
    {




        FCMAINBUILDING.add(new LatLng(9.883282,78.083236));
        FCMAINBUILDING.add(new LatLng(9.883181,78.083246));
        FCMAINBUILDING.add(new LatLng(9.883225,78.082530));
        FCMAINBUILDING.add(new LatLng(9.882881,78.082511));



        FCIT.add(new LatLng(9.883282,78.083236));
        FCIT.add(new LatLng(9.883198,78.083240));
        FCIT.add(new LatLng(9.883168,78.083267));
        FCIT.add(new LatLng(9.882982,78.083426));
        FCIT.add(new LatLng(9.882397,78.083426));
        FCIT.add(new LatLng(9.882397,78.083506));
        FCIT.add(new LatLng(9.882397,78.083569));
        FCIT.add(new LatLng(9.882399,78.083630));



        FCCSE.add(new LatLng(9.883282,78.083236));
        FCCSE.add(new LatLng(9.883198,78.083240));
        FCCSE.add(new LatLng(9.883168,78.083267));
        FCCSE.add(new LatLng(9.882982,78.083423));
        FCCSE.add(new LatLng(9.882893,78.083421));
        FCCSE.add(new LatLng(9.882884,78.083593));
        FCCSE.add(new LatLng(9.882896,78.083745));
        FCCSE.add(new LatLng(9.882797,78.083739));



        FCECE.add(new LatLng(9.883282,78.083236));
        FCECE.add(new LatLng(9.883225,78.083187));
        FCECE.add(new LatLng(9.883225,78.082669));
        FCECE.add(new LatLng(9.883225,78.082341));
        FCECE.add(new LatLng(9.883016,78.082341));
        FCECE.add(new LatLng(9.882820,78.082338));



        FCEEE.add(new LatLng(9.883282,78.083236));
        FCEEE.add(new LatLng(9.883225,78.083187));
        FCEEE.add(new LatLng(9.883225,78.082669));
        FCEEE.add(new LatLng(9.883225,78.081854));
        FCEEE.add(new LatLng(9.882816,78.081854));
        FCEEE.add(new LatLng(9.882466,78.081854));
        FCEEE.add(new LatLng(9.882466,78.082038));
        FCEEE.add(new LatLng(9.882433,78.082086));



        FCCIVIL.add(new LatLng(9.883282,78.083236));
        FCCIVIL.add(new LatLng(9.883173,78.083252));
        FCCIVIL.add(new LatLng(9.882345,78.083252));
        FCCIVIL.add(new LatLng(9.882345,78.082764));
        FCCIVIL.add(new LatLng(9.882278,78.082855));




        FCMECH.add(new LatLng(9.883282,78.083236));
        FCMECH.add(new LatLng(9.883225,78.083187));
        FCMECH.add(new LatLng(9.883225,78.082669));
        FCMECH.add(new LatLng(9.883234,78.081681));
        FCMECH.add(new LatLng(9.882949,78.081681));
        FCMECH.add(new LatLng(9.882707,78.081253));
        FCMECH.add(new LatLng(9.882365,78.081429));



        FCMECHT.add(new LatLng(9.883282,78.083236));
        FCMECHT.add(new LatLng(9.883225,78.083187));
        FCMECHT.add(new LatLng(9.883225,78.082669));
        FCMECHT.add(new LatLng(9.883234,78.081681));
        FCMECHT.add(new LatLng(9.882949,78.081681));
        FCMECHT.add(new LatLng(9.882707,78.081253));
        FCMECHT.add(new LatLng(9.882365,78.081428));



        FCARCH.add(new LatLng(9.883282,78.083236));
        FCARCH.add(new LatLng(9.883198,78.083240));
        FCARCH.add(new LatLng(9.883168,78.083267));
        FCARCH.add(new LatLng(9.882982,78.083426));
        FCARCH.add(new LatLng(9.881682,78.083426));
        FCARCH.add(new LatLng(9.881301,78.083517));
        FCARCH.add(new LatLng(9.880672,78.083442));
        FCARCH.add(new LatLng(9.880558,78.083080));
        FCARCH.add(new LatLng(9.880201,78.083158));
        FCARCH.add(new LatLng(9.878790,78.082110));



        FCSCIENCEBLOCK.add(new LatLng(9.883282,78.083236));
        FCSCIENCEBLOCK.add(new LatLng(9.883198,78.083240));
        FCSCIENCEBLOCK.add(new LatLng(9.883168,78.083267));
        FCSCIENCEBLOCK.add(new LatLng(9.882982,78.083426));
        FCSCIENCEBLOCK.add(new LatLng(9.882178,78.083426));
        FCSCIENCEBLOCK.add(new LatLng(9.882173,78.083195));
        FCSCIENCEBLOCK.add(new LatLng(9.882160,78.083029));
        FCSCIENCEBLOCK.add(new LatLng(9.881816,78.083021));
        FCSCIENCEBLOCK.add(new LatLng(9.881876,78.083152));



        FCFRESHERBLOCK.add(new LatLng(9.883282,78.083236));
        FCFRESHERBLOCK.add(new LatLng(9.883198,78.083240));
        FCFRESHERBLOCK.add(new LatLng(9.883168,78.083267));
        FCFRESHERBLOCK.add(new LatLng(9.882982,78.083426));
        FCFRESHERBLOCK.add(new LatLng(9.882178,78.083426));
        FCFRESHERBLOCK.add(new LatLng(9.882173,78.083195));
        FCFRESHERBLOCK.add(new LatLng(9.882160,78.083029));
        FCFRESHERBLOCK.add(new LatLng(9.881950,78.083021));
        FCFRESHERBLOCK.add(new LatLng(9.881946,78.082825));
        FCFRESHERBLOCK.add(new LatLng(9.881876,78.083152));



        FCNCCBLOCK.add(new LatLng(9.883282,78.083236));
        FCNCCBLOCK.add(new LatLng(9.883234,78.083246));
        FCNCCBLOCK.add(new LatLng(9.883234,78.082540));
        FCNCCBLOCK.add(new LatLng(9.883234,78.081681));
        FCNCCBLOCK.add(new LatLng(9.883262,78.080870));
        FCNCCBLOCK.add(new LatLng(9.883286,78.080765));
        FCNCCBLOCK.add(new LatLng(9.883458,78.080706));
        FCNCCBLOCK.add(new LatLng(9.883560,78.079803));

        FCINDOOR.add(new LatLng(9.883282,78.083236));
        FCINDOOR.add(new LatLng(9.883198,78.083240));
        FCINDOOR.add(new LatLng(9.883168,78.083267));
        FCINDOOR.add(new LatLng(9.882982,78.083426));
        FCINDOOR.add(new LatLng(9.881682,78.083426));
        FCINDOOR.add(new LatLng(9.881452,78.083488));
        FCINDOOR.add(new LatLng(9.881540,78.082662));
        FCINDOOR.add(new LatLng(9.880959,78.082606));
        FCINDOOR.add(new LatLng(9.880761,78.082324));
        FCINDOOR.add(new LatLng(9.880621,78.082225));
        FCINDOOR.add(new LatLng(9.879701,78.081978));
        FCINDOOR.add(new LatLng(9.879215,78.081785));
        FCINDOOR.add(new LatLng(9.878496,78.081654));
        FCINDOOR.add(new LatLng(9.877774,78.081405));
        FCINDOOR.add(new LatLng(9.877578,78.081330));
        FCINDOOR.add(new LatLng(9.877596,78.080995));
        FCINDOOR.add(new LatLng(9.882838,78.082683));

        FCOUTDOOR.add(new LatLng(9.883282,78.083236));
        FCOUTDOOR.add(new LatLng(9.883173,78.083246));
        FCOUTDOOR.add(new LatLng(9.883250,78.081539));
        FCOUTDOOR.add(new LatLng(9.883842,78.081407));

        FCKSAUDITORIUM.add(new LatLng(9.883282,78.083236));
        FCKSAUDITORIUM.add(new LatLng(9.883198,78.083246));
        FCKSAUDITORIUM.add(new LatLng(9.883227,78.081976));
        FCKSAUDITORIUM.add(new LatLng(9.882820,78.082337));

        FCKMAUDITORIUM.add(new LatLng(9.883282,78.083236));
        FCKMAUDITORIUM.add(new LatLng(9.883186,78.083246));
        FCKMAUDITORIUM.add(new LatLng(9.883210,78.082540));
        FCKMAUDITORIUM.add(new LatLng(9.882716,78.082540));
        FCKMAUDITORIUM.add(new LatLng(9.882480,78.082541));

        FCPLACEMENTCELL.add(new LatLng(9.883282,78.083236));
        FCPLACEMENTCELL.add(new LatLng(9.883234,78.083246));
        FCPLACEMENTCELL.add(new LatLng(9.883234,78.082540));
        FCPLACEMENTCELL.add(new LatLng(9.883234,78.081681));
        FCPLACEMENTCELL.add(new LatLng(9.883262,78.080870));
        FCPLACEMENTCELL.add(new LatLng(9.883286,78.080765));
        FCPLACEMENTCELL.add(new LatLng(9.883458,78.080706));
        FCPLACEMENTCELL.add(new LatLng(9.885033,78.080787));
        FCPLACEMENTCELL.add(new LatLng(9.885026,78.080954));

        FCGUESTHOUSE.add(new LatLng(9.883282,78.083236));
        FCGUESTHOUSE.add(new LatLng(9.883234,78.083246));
        FCGUESTHOUSE.add(new LatLng(9.883234,78.082540));
        FCGUESTHOUSE.add(new LatLng(9.883234,78.081681));
        FCGUESTHOUSE.add(new LatLng(9.883262,78.080870));
        FCGUESTHOUSE.add(new LatLng(9.883286,78.080765));
        FCGUESTHOUSE.add(new LatLng(9.883458,78.080706));
        FCGUESTHOUSE.add(new LatLng(9.885219,78.080794));
        FCGUESTHOUSE.add(new LatLng(9.885211,78.080632));

        FCMAINCANTEEN.add(new LatLng(9.883282,78.083236));
        FCMAINCANTEEN.add(new LatLng(9.883234,78.083246));
        FCMAINCANTEEN.add(new LatLng(9.883234,78.082540));
        FCMAINCANTEEN.add(new LatLng(9.883234,78.081681));
        FCMAINCANTEEN.add(new LatLng(9.883286,78.080765));
        FCMAINCANTEEN.add(new LatLng(9.883277,78.080255));
        FCMAINCANTEEN.add(new LatLng(9.883264,78.079857));

        FCMENSHOSTEL.add(new LatLng(9.883282,78.083236));
        FCMENSHOSTEL.add(new LatLng(9.883181,78.083246));
        FCMENSHOSTEL.add(new LatLng(9.883211,78.082630));
        FCMENSHOSTEL.add(new LatLng(9.883236,78.081833));
        FCMENSHOSTEL.add(new LatLng(9.883262,78.080870));
        FCMENSHOSTEL.add(new LatLng(9.883286,78.080765));
        FCMENSHOSTEL.add(new LatLng(9.883368,78.080711));
        FCMENSHOSTEL.add(new LatLng(9.883896,78.080727));
        FCMENSHOSTEL.add(new LatLng(9.884735,78.080781));
        FCMENSHOSTEL.add(new LatLng(9.884765,78.080405));
        FCMENSHOSTEL.add(new LatLng(9.884738,78.080071));

        FCWOMENSHOSTEL.add(new LatLng(9.883282,78.083236));
        FCWOMENSHOSTEL.add(new LatLng(9.883181,78.083246));
        FCWOMENSHOSTEL.add(new LatLng(9.882893,78.083421));
        FCWOMENSHOSTEL.add(new LatLng(9.882397,78.083426));
        FCWOMENSHOSTEL.add(new LatLng(9.881682,78.083426));
        FCWOMENSHOSTEL.add(new LatLng(9.881301,78.083517));
        FCWOMENSHOSTEL.add(new LatLng(9.880672,78.083442));
        FCWOMENSHOSTEL.add(new LatLng(9.880375,78.083386));
        FCWOMENSHOSTEL.add(new LatLng(9.879979,78.083493));
        FCWOMENSHOSTEL.add(new LatLng(9.879832,78.083329));
        FCWOMENSHOSTEL.add(new LatLng(9.879632,78.083372));
        FCWOMENSHOSTEL.add(new LatLng(9.879518,78.082975));
        FCWOMENSHOSTEL.add(new LatLng(9.879373,78.082685));
        FCWOMENSHOSTEL.add(new LatLng(9.879288,78.082626));
        FCWOMENSHOSTEL.add(new LatLng(9.878910,78.082653));
        FCWOMENSHOSTEL.add(new LatLng(9.878479,78.082776));
        FCWOMENSHOSTEL.add(new LatLng(9.878434,78.082095));
        FCWOMENSHOSTEL.add(new LatLng(9.878201,78.082072));

        FCLIBRARY.add(new LatLng(9.883282,78.083236));
        FCLIBRARY.add(new LatLng(9.883181,78.083246));
        FCLIBRARY.add(new LatLng(9.883211,78.082630));
        FCLIBRARY.add(new LatLng(9.883236,78.081833));
        FCLIBRARY.add(new LatLng(9.883236,78.081264));
        FCLIBRARY.add(new LatLng(9.882854,78.081243));

        FCBANK.add(new LatLng(9.883282,78.083236));
        FCBANK.add(new LatLng(9.883181,78.083246));
        FCBANK.add(new LatLng(9.883211,78.082630));
        FCBANK.add(new LatLng(9.883236,78.081833));
        FCBANK.add(new LatLng(9.883262,78.080870));
        FCBANK.add(new LatLng(9.883286,78.080765));
        FCBANK.add(new LatLng(9.883458,78.080706));
        FCBANK.add(new LatLng(9.883496,78.079848));

        FCTEMPLE.add(new LatLng(9.883282,78.083236));
        FCTEMPLE.add(new LatLng(9.883181,78.083246));
        FCTEMPLE.add(new LatLng(9.883211,78.082630));
        FCTEMPLE.add(new LatLng(9.883236,78.081833));
        FCTEMPLE.add(new LatLng(9.883262,78.080870));
        FCTEMPLE.add(new LatLng(9.883286,78.080765));
        FCTEMPLE.add(new LatLng(9.883368,78.080711));
        FCTEMPLE.add(new LatLng(9.883896,78.080727));
        FCTEMPLE.add(new LatLng(9.884735,78.080781));
        FCTEMPLE.add(new LatLng(9.885035,78.080792));
        FCTEMPLE.add(new LatLng(9.885443,78.080804));
        FCTEMPLE.add(new LatLng(9.885459,78.080574));

        FCPARKING.add(new LatLng(9.883282,78.083236));
        FCPARKING.add(new LatLng(9.883181,78.083246));
        FCPARKING.add(new LatLng(9.883211,78.082630));
        FCPARKING.add(new LatLng(9.883236,78.081833));
        FCPARKING.add(new LatLng(9.883252,78.081003));
        FCPARKING.add(new LatLng(9.883106,78.080998));
        FCPARKING.add(new LatLng(9.882769,78.080846));


    }
    public void initMensHostelCoordinates()
    {




        MHMAINBUILDING.add(new LatLng(9.884738,78.080071));
        MHMAINBUILDING.add(new LatLng(9.884778,78.080787));
        MHMAINBUILDING.add(new LatLng(9.883286,78.080765));
        MHMAINBUILDING.add(new LatLng(9.883262,78.080870));
        MHMAINBUILDING.add(new LatLng(9.883236,78.081833));
        MHMAINBUILDING.add(new LatLng(9.883225,78.082341));
        MHMAINBUILDING.add(new LatLng(9.883225,78.082530));
        MHMAINBUILDING.add(new LatLng(9.882881,78.082511));



        MHIT.add(new LatLng(9.884738,78.080071));
        MHIT.add(new LatLng(9.884765,78.080405));
        MHIT.add(new LatLng(9.884735,78.080781));
        MHIT.add(new LatLng(9.883896,78.080727));
        MHIT.add(new LatLng(9.883368,78.080711));
        MHIT.add(new LatLng(9.883286,78.080765));
        MHIT.add(new LatLng(9.883262,78.080870));
        MHIT.add(new LatLng(9.883236,78.081833));
        MHIT.add(new LatLng(9.883211,78.082630));
        MHIT.add(new LatLng(9.883168,78.083267));
        MHIT.add(new LatLng(9.882982,78.083423));
        MHIT.add(new LatLng(9.882397,78.083426));
        MHIT.add(new LatLng(9.882397,78.083506));
        MHIT.add(new LatLng(9.882397,78.083569));
        MHIT.add(new LatLng(9.882399,78.083630));



        MHCSE.add(new LatLng(9.884738,78.080071));
        MHCSE.add(new LatLng(9.884765,78.080405));
        MHCSE.add(new LatLng(9.884735,78.080781));
        MHCSE.add(new LatLng(9.883896,78.080727));
        MHCSE.add(new LatLng(9.883368,78.080711));
        MHCSE.add(new LatLng(9.883286,78.080765));
        MHCSE.add(new LatLng(9.883262,78.080870));
        MHCSE.add(new LatLng(9.883236,78.081833));
        MHCSE.add(new LatLng(9.883211,78.082630));
        MHCSE.add(new LatLng(9.883168,78.083267));
        MHCSE.add(new LatLng(9.882982,78.083423));
        MHCSE.add(new LatLng(9.882893,78.083421));
        MHCSE.add(new LatLng(9.882884,78.083593));
        MHCSE.add(new LatLng(9.882896,78.083745));
        MHCSE.add(new LatLng(9.882797,78.083739));



        MHECE.add(new LatLng(9.884738,78.080071));
        MHECE.add(new LatLng(9.884765,78.080405));
        MHECE.add(new LatLng(9.884735,78.080781));
        MHECE.add(new LatLng(9.883896,78.080727));
        MHECE.add(new LatLng(9.883368,78.080711));
        MHECE.add(new LatLng(9.883286,78.080765));
        MHECE.add(new LatLng(9.883262,78.080870));
        MHECE.add(new LatLng(9.883236,78.081833));
        MHECE.add(new LatLng(9.883225,78.082341));
        MHECE.add(new LatLng(9.883016,78.082341));
        MHECE.add(new LatLng(9.882820,78.082338));



        MHEEE.add(new LatLng(9.884738,78.080071));
        MHEEE.add(new LatLng(9.884765,78.080405));
        MHEEE.add(new LatLng(9.884735,78.080781));
        MHEEE.add(new LatLng(9.883896,78.080727));
        MHEEE.add(new LatLng(9.883368,78.080711));
        MHEEE.add(new LatLng(9.883286,78.080765));
        MHEEE.add(new LatLng(9.883262,78.080870));
        MHEEE.add(new LatLng(9.883225,78.081854));
        MHEEE.add(new LatLng(9.882816,78.081854));
        MHEEE.add(new LatLng(9.882466,78.081854));
        MHEEE.add(new LatLng(9.882466,78.082038));
        MHEEE.add(new LatLng(9.882433,78.082086));



        MHCIVIL.add(new LatLng(9.884738,78.080071));
        MHCIVIL.add(new LatLng(9.884765,78.080405));
        MHCIVIL.add(new LatLng(9.884735,78.080781));
        MHCIVIL.add(new LatLng(9.883896,78.080727));
        MHCIVIL.add(new LatLng(9.883368,78.080711));
        MHCIVIL.add(new LatLng(9.883286,78.080765));
        MHCIVIL.add(new LatLng(9.883262,78.080870));
        MHCIVIL.add(new LatLng(9.883225,78.081854));
        MHCIVIL.add(new LatLng(9.882816,78.081854));
        MHCIVIL.add(new LatLng(9.882466,78.081854));
        MHCIVIL.add(new LatLng(9.882464,78.082037));
        MHCIVIL.add(new LatLng(9.882464,78.082333));
        MHCIVIL.add(new LatLng(9.882464,78.082422));
        MHCIVIL.add(new LatLng(9.882341,78.082422));
        MHCIVIL.add(new LatLng(9.882341,78.082764));
        MHCIVIL.add(new LatLng(9.882278,78.082855));



        MHMECH.add(new LatLng(9.884738,78.080071));
        MHMECH.add(new LatLng(9.884765,78.080405));
        MHMECH.add(new LatLng(9.884735,78.080781));
        MHMECH.add(new LatLng(9.883896,78.080727));
        MHMECH.add(new LatLng(9.883368,78.080711));
        MHMECH.add(new LatLng(9.883286,78.080765));
        MHMECH.add(new LatLng(9.883262,78.080870));
        MHMECH.add(new LatLng(9.883234,78.081681));
        MHMECH.add(new LatLng(9.882949,78.081681));
        MHMECH.add(new LatLng(9.882707,78.081253));
        MHMECH.add(new LatLng(9.882365,78.081429));



        MHMECHT.add(new LatLng(9.884738,78.080071));
        MHMECHT.add(new LatLng(9.884765,78.080405));
        MHMECHT.add(new LatLng(9.884735,78.080781));
        MHMECHT.add(new LatLng(9.883896,78.080727));
        MHMECHT.add(new LatLng(9.883368,78.080711));
        MHMECHT.add(new LatLng(9.883286,78.080765));
        MHMECHT.add(new LatLng(9.883262,78.080870));
        MHMECHT.add(new LatLng(9.883234,78.081681));
        MHMECHT.add(new LatLng(9.882949,78.081681));
        MHMECHT.add(new LatLng(9.882707,78.081253));
        MHMECHT.add(new LatLng(9.882365,78.081428));



        MHARCH.add(new LatLng(9.884738,78.080071));
        MHARCH.add(new LatLng(9.884765,78.080405));
        MHARCH.add(new LatLng(9.884735,78.080781));
        MHARCH.add(new LatLng(9.883896,78.080727));
        MHARCH.add(new LatLng(9.883368,78.080711));
        MHARCH.add(new LatLng(9.883286,78.080765));
        MHARCH.add(new LatLng(9.883262,78.080870));
        MHARCH.add(new LatLng(9.883236,78.081653));
        MHARCH.add(new LatLng(9.882771,78.081653));
        MHARCH.add(new LatLng(9.882399,78.081653));
        MHARCH.add(new LatLng(9.882321,78.081682));
        MHARCH.add(new LatLng(9.882207,78.082300));
        MHARCH.add(new LatLng(9.881980,78.082442));
        MHARCH.add(new LatLng(9.881980,78.083002));
        MHARCH.add(new LatLng(9.882124,78.083002));
        MHARCH.add(new LatLng(9.882124,78.083251));
        MHARCH.add(new LatLng(9.882124,78.083426));
        MHARCH.add(new LatLng(9.881682,78.083426));
        MHARCH.add(new LatLng(9.881301,78.083517));
        MHARCH.add(new LatLng(9.880672,78.083442));
        MHARCH.add(new LatLng(9.880558,78.083080));
        MHARCH.add(new LatLng(9.880201,78.083158));
        MHARCH.add(new LatLng(9.878790,78.082110));



        MHSCIENCEBLOCK.add(new LatLng(9.884738,78.080071));
        MHSCIENCEBLOCK.add(new LatLng(9.884765,78.080405));
        MHSCIENCEBLOCK.add(new LatLng(9.884735,78.080781));
        MHSCIENCEBLOCK.add(new LatLng(9.883896,78.080727));
        MHSCIENCEBLOCK.add(new LatLng(9.883368,78.080711));
        MHSCIENCEBLOCK.add(new LatLng(9.883286,78.080765));
        MHSCIENCEBLOCK.add(new LatLng(9.883262,78.080870));
        MHSCIENCEBLOCK.add(new LatLng(9.883234,78.081681));
        MHSCIENCEBLOCK.add(new LatLng(9.882399,78.081653));
        MHSCIENCEBLOCK.add(new LatLng(9.882321,78.081682));
        MHSCIENCEBLOCK.add(new LatLng(9.882207,78.082300));
        MHSCIENCEBLOCK.add(new LatLng(9.881980,78.082442));
        MHSCIENCEBLOCK.add(new LatLng(9.881980,78.083002));
        MHSCIENCEBLOCK.add(new LatLng(9.881980,78.083111));
        MHSCIENCEBLOCK.add(new LatLng(9.881876,78.083152));



        MHFRESHERBLOCK.add(new LatLng(9.884738,78.080071));
        MHFRESHERBLOCK.add(new LatLng(9.884765,78.080405));
        MHFRESHERBLOCK.add(new LatLng(9.884735,78.080781));
        MHFRESHERBLOCK.add(new LatLng(9.883896,78.080727));
        MHFRESHERBLOCK.add(new LatLng(9.883368,78.080711));
        MHFRESHERBLOCK.add(new LatLng(9.883286,78.080765));
        MHFRESHERBLOCK.add(new LatLng(9.883262,78.080870));
        MHFRESHERBLOCK.add(new LatLng(9.883234,78.081681));
        MHFRESHERBLOCK.add(new LatLng(9.882399,78.081653));
        MHFRESHERBLOCK.add(new LatLng(9.882321,78.081682));
        MHFRESHERBLOCK.add(new LatLng(9.882207,78.082300));
        MHFRESHERBLOCK.add(new LatLng(9.881980,78.082442));
        MHFRESHERBLOCK.add(new LatLng(9.881980,78.082817));
        MHFRESHERBLOCK.add(new LatLng(9.88172,78.082617));



        MHNCCBLOCK.add(new LatLng(9.884738,78.080071));
        MHNCCBLOCK.add(new LatLng(9.884765,78.080405));
        MHNCCBLOCK.add(new LatLng(9.884735,78.080781));
        MHNCCBLOCK.add(new LatLng(9.883896,78.080727));
        MHNCCBLOCK.add(new LatLng(9.883483,78.080696));
        MHNCCBLOCK.add(new LatLng(9.883560,78.079803));



        MHINDOOR.add(new LatLng(9.884738,78.080071));
        MHINDOOR.add(new LatLng(9.884765,78.080405));
        MHINDOOR.add(new LatLng(9.884735,78.080781));
        MHINDOOR.add(new LatLng(9.883896,78.080727));
        MHINDOOR.add(new LatLng(9.883368,78.080711));
        MHINDOOR.add(new LatLng(9.883286,78.080765));
        MHINDOOR.add(new LatLng(9.883262,78.080870));
        MHINDOOR.add(new LatLng(9.883236,78.081653));
        MHINDOOR.add(new LatLng(9.882771,78.081653));
        MHINDOOR.add(new LatLng(9.882399,78.081653));
        MHINDOOR.add(new LatLng(9.882321,78.081682));
        MHINDOOR.add(new LatLng(9.882207,78.082300));
        MHINDOOR.add(new LatLng(9.881980,78.082442));
        MHINDOOR.add(new LatLng(9.881980,78.083002));
        MHINDOOR.add(new LatLng(9.882124,78.083002));
        MHINDOOR.add(new LatLng(9.882124,78.083251));
        MHINDOOR.add(new LatLng(9.882124,78.083426));
        MHINDOOR.add(new LatLng(9.881682,78.083426));
        MHINDOOR.add(new LatLng(9.881452,78.083488));
        MHINDOOR.add(new LatLng(9.881540,78.082662));
        MHINDOOR.add(new LatLng(9.880959,78.082606));
        MHINDOOR.add(new LatLng(9.880761,78.082324));
        MHINDOOR.add(new LatLng(9.880621,78.082225));
        MHINDOOR.add(new LatLng(9.879701,78.081978));
        MHINDOOR.add(new LatLng(9.879215,78.081785));
        MHINDOOR.add(new LatLng(9.878496,78.081654));
        MHINDOOR.add(new LatLng(9.877774,78.081405));
        MHINDOOR.add(new LatLng(9.877578,78.081330));
        MHINDOOR.add(new LatLng(9.877596,78.080995));
        MHINDOOR.add(new LatLng(9.882838,78.082683));



        MHOUTDOOR.add(new LatLng(9.884738,78.080071));
        MHOUTDOOR.add(new LatLng(9.884778,78.080721));
        MHOUTDOOR.add(new LatLng(9.883759,78.080721));
        MHOUTDOOR.add(new LatLng(9.883842,78.081407));



        MHKSAUDITORIUM.add(new LatLng(9.884738,78.080071));
        MHKSAUDITORIUM.add(new LatLng(9.884765,78.080405));
        MHKSAUDITORIUM.add(new LatLng(9.884735,78.080781));
        MHKSAUDITORIUM.add(new LatLng(9.883896,78.080727));
        MHKSAUDITORIUM.add(new LatLng(9.883368,78.080711));
        MHKSAUDITORIUM.add(new LatLng(9.883286,78.080765));
        MHKSAUDITORIUM.add(new LatLng(9.883262,78.080870));
        MHKSAUDITORIUM.add(new LatLng(9.883227,78.081976));
        MHKSAUDITORIUM.add(new LatLng(9.882820,78.082337));



        MHKMAUDITORIUM.add(new LatLng(9.884738,78.080071));
        MHKMAUDITORIUM.add(new LatLng(9.884765,78.080405));
        MHKMAUDITORIUM.add(new LatLng(9.884735,78.080781));
        MHKMAUDITORIUM.add(new LatLng(9.883896,78.080727));
        MHKMAUDITORIUM.add(new LatLng(9.883368,78.080711));
        MHKMAUDITORIUM.add(new LatLng(9.883286,78.080765));
        MHKMAUDITORIUM.add(new LatLng(9.883262,78.080870));
        MHKMAUDITORIUM.add(new LatLng(9.883210,78.082540));
        MHKMAUDITORIUM.add(new LatLng(9.882716,78.082540));
        MHKMAUDITORIUM.add(new LatLng(9.882480,78.082541));



        MHPLACEMENTCELL.add(new LatLng(9.884738,78.080071));
        MHPLACEMENTCELL.add(new LatLng(9.884765,78.080405));
        MHPLACEMENTCELL.add(new LatLng(9.884735,78.080781));
        MHPLACEMENTCELL.add(new LatLng(9.885033,78.080787));
        MHPLACEMENTCELL.add(new LatLng(9.885026,78.080954));



        MHGUESTHOUSE.add(new LatLng(9.884738,78.080071));
        MHGUESTHOUSE.add(new LatLng(9.884765,78.080405));
        MHGUESTHOUSE.add(new LatLng(9.884735,78.080781));
        MHGUESTHOUSE.add(new LatLng(9.885219,78.080794));
        MHGUESTHOUSE.add(new LatLng(9.885211,78.080632));



        MHMAINCANTEEN.add(new LatLng(9.884738,78.080071));
        MHMAINCANTEEN.add(new LatLng(9.884765,78.080405));
        MHMAINCANTEEN.add(new LatLng(9.884735,78.080781));
        MHMAINCANTEEN.add(new LatLng(9.883896,78.080727));
        MHMAINCANTEEN.add(new LatLng(9.883286,78.080765));
        MHMAINCANTEEN.add(new LatLng(9.883277,78.080255));
        MHMAINCANTEEN.add(new LatLng(9.883264,78.079857));



        MHFOODCOURT.add(new LatLng(9.884738,78.080071));
        MHFOODCOURT.add(new LatLng(9.884765,78.080405));
        MHFOODCOURT.add(new LatLng(9.884735,78.080781));
        MHFOODCOURT.add(new LatLng(9.883896,78.080727));
        MHFOODCOURT.add(new LatLng(9.883368,78.080711));
        MHFOODCOURT.add(new LatLng(9.883286,78.080765));
        MHFOODCOURT.add(new LatLng(9.883262,78.080870));
        MHFOODCOURT.add(new LatLng(9.883236,78.081833));
        MHFOODCOURT.add(new LatLng(9.883211,78.082630));
        MHFOODCOURT.add(new LatLng(9.883181,78.083246));
        MHFOODCOURT.add(new LatLng(9.883282,78.083236));



        MHWOMENSHOSTEL.add(new LatLng(9.884738,78.080071));
        MHWOMENSHOSTEL.add(new LatLng(9.884778,78.080787));
        MHWOMENSHOSTEL.add(new LatLng(9.883458,78.080706));
        MHWOMENSHOSTEL.add(new LatLng(9.883286,78.080765));
        MHWOMENSHOSTEL.add(new LatLng(9.883262,78.080870));
        MHWOMENSHOSTEL.add(new LatLng(9.883234,78.081681));
        MHWOMENSHOSTEL.add(new LatLng(9.882399,78.081653));
        MHWOMENSHOSTEL.add(new LatLng(9.882321,78.081682));
        MHWOMENSHOSTEL.add(new LatLng(9.882207,78.082300));
        MHWOMENSHOSTEL.add(new LatLng(9.881980,78.082442));
        MHWOMENSHOSTEL.add(new LatLng(9.881980,78.083002));
        MHWOMENSHOSTEL.add(new LatLng(9.882124,78.083002));
        MHWOMENSHOSTEL.add(new LatLng(9.882124,78.083251));
        MHWOMENSHOSTEL.add(new LatLng(9.882124,78.083426));
        MHWOMENSHOSTEL.add(new LatLng(9.881682,78.083426));
        MHWOMENSHOSTEL.add(new LatLng(9.881301,78.083517));
        MHWOMENSHOSTEL.add(new LatLng(9.880672,78.083442));
        MHWOMENSHOSTEL.add(new LatLng(9.880375,78.083386));
        MHWOMENSHOSTEL.add(new LatLng(9.879979,78.083493));
        MHWOMENSHOSTEL.add(new LatLng(9.879832,78.083329));
        MHWOMENSHOSTEL.add(new LatLng(9.879632,78.083372));
        MHWOMENSHOSTEL.add(new LatLng(9.879518,78.082975));
        MHWOMENSHOSTEL.add(new LatLng(9.879373,78.082685));
        MHWOMENSHOSTEL.add(new LatLng(9.879288,78.082626));
        MHWOMENSHOSTEL.add(new LatLng(9.878910,78.082653));
        MHWOMENSHOSTEL.add(new LatLng(9.878479,78.082776));
        MHWOMENSHOSTEL.add(new LatLng(9.878434,78.082095));
        MHWOMENSHOSTEL.add(new LatLng(9.878201,78.082072));



        MHLIBRARY.add(new LatLng(9.884738,78.080071));
        MHLIBRARY.add(new LatLng(9.884778,78.080787));
        MHLIBRARY.add(new LatLng(9.883458,78.080706));
        MHLIBRARY.add(new LatLng(9.883286,78.080765));
        MHLIBRARY.add(new LatLng(9.883262,78.080870));
        MHLIBRARY.add(new LatLng(9.883262,78.081264));
        MHLIBRARY.add(new LatLng(9.882854,78.081243));



        MHBANK.add(new LatLng(9.884738,78.080071));
        MHBANK.add(new LatLng(9.884778,78.080787));
        MHBANK.add(new LatLng(9.883458,78.080706));
        MHBANK.add(new LatLng(9.882854,78.081243));



        MHTEMPLE.add(new LatLng(9.884738,78.080071));
        MHTEMPLE.add(new LatLng(9.884778,78.080787));
        MHTEMPLE.add(new LatLng(9.885444,78.080804));
        MHTEMPLE.add(new LatLng(9.885459,78.080574));



        MHPARKING.add(new LatLng(9.884738,78.080071));
        MHPARKING.add(new LatLng(9.884778,78.080787));
        MHPARKING.add(new LatLng(9.883458,78.080706));
        MHPARKING.add(new LatLng(9.883250,78.080715));
        MHPARKING.add(new LatLng(9.882416,78.080715));
        MHPARKING.add(new LatLng(9.882416,78.080942));
        MHPARKING.add(new LatLng(9.882769,78.080846));


    }
    public void initWomensHostelCoordinates()
    {




        WHMAINBUILDING.add(new LatLng(9.878201,78.082072));
        WHMAINBUILDING.add(new LatLng(9.878434,78.082095));
        WHMAINBUILDING.add(new LatLng(9.878479,78.082776));
        WHMAINBUILDING.add(new LatLng(9.878910,78.082653));
        WHMAINBUILDING.add(new LatLng(9.879288,78.082626));
        WHMAINBUILDING.add(new LatLng(9.879373,78.082685));
        WHMAINBUILDING.add(new LatLng(9.879518,78.082975));
        WHMAINBUILDING.add(new LatLng(9.879632,78.083372));
        WHMAINBUILDING.add(new LatLng(9.879832,78.083329));
        WHMAINBUILDING.add(new LatLng(9.879979,78.083493));
        WHMAINBUILDING.add(new LatLng(9.880375,78.083386));
        WHMAINBUILDING.add(new LatLng(9.880672,78.083442));
        WHMAINBUILDING.add(new LatLng(9.881301,78.083517));
        WHMAINBUILDING.add(new LatLng(9.881682,78.083426));
        WHMAINBUILDING.add(new LatLng(9.882692,78.083426));
        WHMAINBUILDING.add(new LatLng(9.882710,78.083130));
        WHMAINBUILDING.add(new LatLng(9.882731,78.082759));
        WHMAINBUILDING.add(new LatLng(9.882750,78.082536));
        WHMAINBUILDING.add(new LatLng(9.882829,78.082341));
        WHMAINBUILDING.add(new LatLng(9.882881,78.082511));



        WHIT.add(new LatLng(9.878201,78.082072));
        WHIT.add(new LatLng(9.878434,78.082095));
        WHIT.add(new LatLng(9.878479,78.082776));
        WHIT.add(new LatLng(9.878910,78.082653));
        WHIT.add(new LatLng(9.879288,78.082626));
        WHIT.add(new LatLng(9.879373,78.082685));
        WHIT.add(new LatLng(9.879518,78.082975));
        WHIT.add(new LatLng(9.879632,78.083372));
        WHIT.add(new LatLng(9.879832,78.083329));
        WHIT.add(new LatLng(9.879979,78.083493));
        WHIT.add(new LatLng(9.880375,78.083386));
        WHIT.add(new LatLng(9.880672,78.083442));
        WHIT.add(new LatLng(9.881301,78.083517));
        WHIT.add(new LatLng(9.881682,78.083426));
        WHIT.add(new LatLng(9.882397,78.083426));
        WHIT.add(new LatLng(9.882397,78.083506));
        WHIT.add(new LatLng(9.882397,78.083569));
        WHIT.add(new LatLng(9.882399,78.083630));



        WHCSE.add(new LatLng(9.878201,78.082072));
        WHCSE.add(new LatLng(9.878434,78.082095));
        WHCSE.add(new LatLng(9.878479,78.082776));
        WHCSE.add(new LatLng(9.878910,78.082653));
        WHCSE.add(new LatLng(9.879288,78.082626));
        WHCSE.add(new LatLng(9.879373,78.082685));
        WHCSE.add(new LatLng(9.879518,78.082975));
        WHCSE.add(new LatLng(9.879632,78.083372));
        WHCSE.add(new LatLng(9.879832,78.083329));
        WHCSE.add(new LatLng(9.879979,78.083493));
        WHCSE.add(new LatLng(9.880375,78.083386));
        WHCSE.add(new LatLng(9.880672,78.083442));
        WHCSE.add(new LatLng(9.881301,78.083517));
        WHCSE.add(new LatLng(9.881682,78.083426));
        WHCSE.add(new LatLng(9.882397,78.083426));
        WHCSE.add(new LatLng(9.882893,78.083421));
        WHCSE.add(new LatLng(9.882884,78.083593));
        WHCSE.add(new LatLng(9.882896,78.083745));
        WHCSE.add(new LatLng(9.882797,78.083739));



        WHECE.add(new LatLng(9.878201,78.082072));
        WHECE.add(new LatLng(9.878434,78.082095));
        WHECE.add(new LatLng(9.878479,78.082776));
        WHECE.add(new LatLng(9.878910,78.082653));
        WHECE.add(new LatLng(9.879288,78.082626));
        WHECE.add(new LatLng(9.879373,78.082685));
        WHECE.add(new LatLng(9.879518,78.082975));
        WHECE.add(new LatLng(9.879632,78.083372));
        WHECE.add(new LatLng(9.879832,78.083329));
        WHECE.add(new LatLng(9.879979,78.083493));
        WHECE.add(new LatLng(9.880375,78.083386));
        WHECE.add(new LatLng(9.880672,78.083442));
        WHECE.add(new LatLng(9.881301,78.083517));
        WHECE.add(new LatLng(9.881682,78.083426));
        WHECE.add(new LatLng(9.882208,78.083411));
        WHECE.add(new LatLng(9.882319,78.083360));
        WHECE.add(new LatLng(9.882398,78.083309));
        WHECE.add(new LatLng(9.882554,78.083288));
        WHECE.add(new LatLng(9.882691,78.083267));
        WHECE.add(new LatLng(9.882710,78.083130));
        WHECE.add(new LatLng(9.882731,78.082759));
        WHECE.add(new LatLng(9.882750,78.082536));
        WHECE.add(new LatLng(9.882820,78.082338));



        WHEEE.add(new LatLng(9.878201,78.082072));
        WHEEE.add(new LatLng(9.878434,78.082095));
        WHEEE.add(new LatLng(9.878479,78.082776));
        WHEEE.add(new LatLng(9.878910,78.082653));
        WHEEE.add(new LatLng(9.879288,78.082626));
        WHEEE.add(new LatLng(9.879373,78.082685));
        WHEEE.add(new LatLng(9.879518,78.082975));
        WHEEE.add(new LatLng(9.879632,78.083372));
        WHEEE.add(new LatLng(9.879832,78.083329));
        WHEEE.add(new LatLng(9.879979,78.083493));
        WHEEE.add(new LatLng(9.880375,78.083386));
        WHEEE.add(new LatLng(9.880672,78.083442));
        WHEEE.add(new LatLng(9.881301,78.083517));
        WHEEE.add(new LatLng(9.881682,78.083426));
        WHEEE.add(new LatLng(9.882341,78.083402));
        WHEEE.add(new LatLng(9.882341,78.083190));
        WHEEE.add(new LatLng(9.882341,78.082764));
        WHEEE.add(new LatLng(9.882341,78.082422));
        WHEEE.add(new LatLng(9.882464,78.082422));
        WHEEE.add(new LatLng(9.882464,78.082333));
        WHEEE.add(new LatLng(9.882464,78.082037));
        WHEEE.add(new LatLng(9.882433,78.082086));



        WHCIVIL.add(new LatLng(9.878201,78.082072));
        WHCIVIL.add(new LatLng(9.878201,78.082072));
        WHCIVIL.add(new LatLng(9.878434,78.082095));
        WHCIVIL.add(new LatLng(9.878479,78.082776));
        WHCIVIL.add(new LatLng(9.878910,78.082653));
        WHCIVIL.add(new LatLng(9.879288,78.082626));
        WHCIVIL.add(new LatLng(9.879373,78.082685));
        WHCIVIL.add(new LatLng(9.879518,78.082975));
        WHCIVIL.add(new LatLng(9.879632,78.083372));
        WHCIVIL.add(new LatLng(9.879832,78.083329));
        WHCIVIL.add(new LatLng(9.879979,78.083493));
        WHCIVIL.add(new LatLng(9.880375,78.083386));
        WHCIVIL.add(new LatLng(9.880672,78.083442));
        WHCIVIL.add(new LatLng(9.881301,78.083517));
        WHCIVIL.add(new LatLng(9.881682,78.083426));
        WHCIVIL.add(new LatLng(9.882326,78.083423));
        WHCIVIL.add(new LatLng(9.882324,78.083199));
        WHCIVIL.add(new LatLng(9.882324,78.082764));
        WHCIVIL.add(new LatLng(9.882278,78.082855));



        WHMECH.add(new LatLng(9.878201,78.082072));
        WHMECH.add(new LatLng(9.878434,78.082095));
        WHMECH.add(new LatLng(9.878479,78.082776));
        WHMECH.add(new LatLng(9.878910,78.082653));
        WHMECH.add(new LatLng(9.879288,78.082626));
        WHMECH.add(new LatLng(9.879373,78.082685));
        WHMECH.add(new LatLng(9.879518,78.082975));
        WHMECH.add(new LatLng(9.879632,78.083372));
        WHMECH.add(new LatLng(9.879832,78.083329));
        WHMECH.add(new LatLng(9.879979,78.083493));
        WHMECH.add(new LatLng(9.880375,78.083386));
        WHMECH.add(new LatLng(9.880672,78.083442));
        WHMECH.add(new LatLng(9.881301,78.083517));
        WHMECH.add(new LatLng(9.881682,78.083426));
        WHMECH.add(new LatLng(9.882124,78.083426));
        WHMECH.add(new LatLng(9.882124,78.083251));
        WHMECH.add(new LatLng(9.882124,78.083002));
        WHMECH.add(new LatLng(9.881980,78.083002));
        WHMECH.add(new LatLng(9.881980,78.082442));
        WHMECH.add(new LatLng(9.882207,78.082300));
        WHMECH.add(new LatLng(9.882321,78.081682));
        WHMECH.add(new LatLng(9.882399,78.081653));
        WHMECH.add(new LatLng(9.882452,78.081388));
        WHMECH.add(new LatLng(9.882707,78.081388));
        WHMECH.add(new LatLng(9.882365,78.081429));



        WHMECHT.add(new LatLng(9.878201,78.082072));
        WHMECHT.add(new LatLng(9.878434,78.082095));
        WHMECHT.add(new LatLng(9.878479,78.082776));
        WHMECHT.add(new LatLng(9.878910,78.082653));
        WHMECHT.add(new LatLng(9.879288,78.082626));
        WHMECHT.add(new LatLng(9.879373,78.082685));
        WHMECHT.add(new LatLng(9.879518,78.082975));
        WHMECHT.add(new LatLng(9.879632,78.083372));
        WHMECHT.add(new LatLng(9.879832,78.083329));
        WHMECHT.add(new LatLng(9.879979,78.083493));
        WHMECHT.add(new LatLng(9.880375,78.083386));
        WHMECHT.add(new LatLng(9.880672,78.083442));
        WHMECHT.add(new LatLng(9.881301,78.083517));
        WHMECHT.add(new LatLng(9.881682,78.083426));
        WHMECHT.add(new LatLng(9.882124,78.083426));
        WHMECHT.add(new LatLng(9.882124,78.083251));
        WHMECHT.add(new LatLng(9.882124,78.083002));
        WHMECHT.add(new LatLng(9.881980,78.083002));
        WHMECHT.add(new LatLng(9.881980,78.082442));
        WHMECHT.add(new LatLng(9.882207,78.082300));
        WHMECHT.add(new LatLng(9.882321,78.081682));
        WHMECHT.add(new LatLng(9.882399,78.081653));
        WHMECHT.add(new LatLng(9.882452,78.081388));
        WHMECHT.add(new LatLng(9.882707,78.081388));
        WHMECHT.add(new LatLng(9.882365,78.081428));



        WHARCH.add(new LatLng(9.878201,78.082072));
        WHARCH.add(new LatLng(9.878434,78.082095));
        WHARCH.add(new LatLng(9.878479,78.082776));
        WHARCH.add(new LatLng(9.878910,78.082653));
        WHARCH.add(new LatLng(9.879288,78.082626));
        WHARCH.add(new LatLng(9.879373,78.082685));
        WHARCH.add(new LatLng(9.879518,78.082975));
        WHARCH.add(new LatLng(9.879632,78.083372));
        WHARCH.add(new LatLng(9.879832,78.083329));
        WHARCH.add(new LatLng(9.880176,78.083175));
        WHARCH.add(new LatLng(9.878790,78.082110));



        WHSCIENCEBLOCK.add(new LatLng(9.878201,78.082072));
        WHSCIENCEBLOCK.add(new LatLng(9.878434,78.082095));
        WHSCIENCEBLOCK.add(new LatLng(9.878479,78.082776));
        WHSCIENCEBLOCK.add(new LatLng(9.878910,78.082653));
        WHSCIENCEBLOCK.add(new LatLng(9.879288,78.082626));
        WHSCIENCEBLOCK.add(new LatLng(9.879373,78.082685));
        WHSCIENCEBLOCK.add(new LatLng(9.879518,78.082975));
        WHSCIENCEBLOCK.add(new LatLng(9.879632,78.083372));
        WHSCIENCEBLOCK.add(new LatLng(9.879832,78.083329));
        WHSCIENCEBLOCK.add(new LatLng(9.879979,78.083493));
        WHSCIENCEBLOCK.add(new LatLng(9.880375,78.083386));
        WHSCIENCEBLOCK.add(new LatLng(9.880672,78.083442));
        WHSCIENCEBLOCK.add(new LatLng(9.881301,78.083517));
        WHSCIENCEBLOCK.add(new LatLng(9.881682,78.083426));
        WHSCIENCEBLOCK.add(new LatLng(9.882169,78.083412));
        WHSCIENCEBLOCK.add(new LatLng(9.882148,78.083023));
        WHSCIENCEBLOCK.add(new LatLng(9.881686,78.083034));
        WHSCIENCEBLOCK.add(new LatLng(9.881876,78.083152));




        WHFRESHERBLOCK.add(new LatLng(9.878201,78.082072));
        WHFRESHERBLOCK.add(new LatLng(9.878434,78.082095));
        WHFRESHERBLOCK.add(new LatLng(9.878479,78.082776));
        WHFRESHERBLOCK.add(new LatLng(9.878910,78.082653));
        WHFRESHERBLOCK.add(new LatLng(9.879288,78.082626));
        WHFRESHERBLOCK.add(new LatLng(9.879373,78.082685));
        WHFRESHERBLOCK.add(new LatLng(9.879518,78.082975));
        WHFRESHERBLOCK.add(new LatLng(9.879632,78.083372));
        WHFRESHERBLOCK.add(new LatLng(9.879832,78.083329));
        WHFRESHERBLOCK.add(new LatLng(9.879979,78.083493));
        WHFRESHERBLOCK.add(new LatLng(9.880375,78.083386));
        WHFRESHERBLOCK.add(new LatLng(9.880672,78.083442));
        WHFRESHERBLOCK.add(new LatLng(9.881301,78.083517));
        WHFRESHERBLOCK.add(new LatLng(9.881682,78.083426));
        WHFRESHERBLOCK.add(new LatLng(9.882169,78.083412));
        WHFRESHERBLOCK.add(new LatLng(9.882148,78.083023));
        WHFRESHERBLOCK.add(new LatLng(9.881834,78.083032));
        WHFRESHERBLOCK.add(new LatLng(9.88172,78.082617));



        WHNCCBLOCK.add(new LatLng(9.878201,78.082072));
        WHNCCBLOCK.add(new LatLng(9.878434,78.082095));
        WHNCCBLOCK.add(new LatLng(9.878479,78.082776));
        WHNCCBLOCK.add(new LatLng(9.878910,78.082653));
        WHNCCBLOCK.add(new LatLng(9.879288,78.082626));
        WHNCCBLOCK.add(new LatLng(9.879373,78.082685));
        WHNCCBLOCK.add(new LatLng(9.879518,78.082975));
        WHNCCBLOCK.add(new LatLng(9.879632,78.083372));
        WHNCCBLOCK.add(new LatLng(9.879832,78.083329));
        WHNCCBLOCK.add(new LatLng(9.879979,78.083493));
        WHNCCBLOCK.add(new LatLng(9.880375,78.083386));
        WHNCCBLOCK.add(new LatLng(9.880672,78.083442));
        WHNCCBLOCK.add(new LatLng(9.881301,78.083517));
        WHNCCBLOCK.add(new LatLng(9.881682,78.083426));
        WHNCCBLOCK.add(new LatLng(9.882124,78.083426));
        WHNCCBLOCK.add(new LatLng(9.882124,78.083251));
        WHNCCBLOCK.add(new LatLng(9.882124,78.083002));
        WHNCCBLOCK.add(new LatLng(9.881980,78.083002));
        WHNCCBLOCK.add(new LatLng(9.881980,78.082442));
        WHNCCBLOCK.add(new LatLng(9.882207,78.082300));
        WHNCCBLOCK.add(new LatLng(9.882321,78.081682));
        WHNCCBLOCK.add(new LatLng(9.882399,78.081653));
        WHNCCBLOCK.add(new LatLng(9.883234,78.081681));
        WHNCCBLOCK.add(new LatLng(9.883262,78.080870));
        WHNCCBLOCK.add(new LatLng(9.883286,78.080765));
        WHNCCBLOCK.add(new LatLng(9.883458,78.080706));
        WHNCCBLOCK.add(new LatLng(9.883560,78.079803));



        WHINDOOR.add(new LatLng(9.878201,78.082072));
        WHINDOOR.add(new LatLng(9.878434,78.082095));
        WHINDOOR.add(new LatLng(9.878479,78.082776));
        WHINDOOR.add(new LatLng(9.878910,78.082653));
        WHINDOOR.add(new LatLng(9.879288,78.082626));
        WHINDOOR.add(new LatLng(9.879373,78.082685));
        WHINDOOR.add(new LatLng(9.879518,78.082975));
        WHINDOOR.add(new LatLng(9.879632,78.083372));
        WHINDOOR.add(new LatLng(9.879832,78.083329));
        WHINDOOR.add(new LatLng(9.879979,78.083493));
        WHINDOOR.add(new LatLng(9.880375,78.083386));
        WHINDOOR.add(new LatLng(9.880672,78.083442));
        WHINDOOR.add(new LatLng(9.881301,78.083517));
        WHINDOOR.add(new LatLng(9.881452,78.083488));
        WHINDOOR.add(new LatLng(9.881540,78.082662));
        WHINDOOR.add(new LatLng(9.880959,78.082606));
        WHINDOOR.add(new LatLng(9.880761,78.082324));
        WHINDOOR.add(new LatLng(9.880621,78.082225));
        WHINDOOR.add(new LatLng(9.879701,78.081978));
        WHINDOOR.add(new LatLng(9.879215,78.081785));
        WHINDOOR.add(new LatLng(9.878496,78.081654));
        WHINDOOR.add(new LatLng(9.877774,78.081405));
        WHINDOOR.add(new LatLng(9.877578,78.081330));
        WHINDOOR.add(new LatLng(9.877596,78.080995));
        WHINDOOR.add(new LatLng(9.882838,78.082683));



        WHOUTDOOR.add(new LatLng(9.878201,78.082072));
        WHOUTDOOR.add(new LatLng(9.878434,78.082095));
        WHOUTDOOR.add(new LatLng(9.878479,78.082776));
        WHOUTDOOR.add(new LatLng(9.878910,78.082653));
        WHOUTDOOR.add(new LatLng(9.879288,78.082626));
        WHOUTDOOR.add(new LatLng(9.879373,78.082685));
        WHOUTDOOR.add(new LatLng(9.879518,78.082975));
        WHOUTDOOR.add(new LatLng(9.879632,78.083372));
        WHOUTDOOR.add(new LatLng(9.879832,78.083329));
        WHOUTDOOR.add(new LatLng(9.879979,78.083493));
        WHOUTDOOR.add(new LatLng(9.880375,78.083386));
        WHOUTDOOR.add(new LatLng(9.880672,78.083442));
        WHOUTDOOR.add(new LatLng(9.881301,78.083517));
        WHOUTDOOR.add(new LatLng(9.881682,78.083426));
        WHOUTDOOR.add(new LatLng(9.882124,78.083426));
        WHOUTDOOR.add(new LatLng(9.882124,78.083251));
        WHOUTDOOR.add(new LatLng(9.882124,78.083002));
        WHOUTDOOR.add(new LatLng(9.881980,78.083002));
        WHOUTDOOR.add(new LatLng(9.881980,78.082442));
        WHOUTDOOR.add(new LatLng(9.882207,78.082300));
        WHOUTDOOR.add(new LatLng(9.882321,78.081682));
        WHOUTDOOR.add(new LatLng(9.882399,78.081653));
        WHOUTDOOR.add(new LatLng(9.883234,78.081681));
        WHOUTDOOR.add(new LatLng(9.883250,78.081539));
        WHOUTDOOR.add(new LatLng(9.883842,78.081407));



        WHKSAUDITORIUM.add(new LatLng(9.878201,78.082072));
        WHKSAUDITORIUM.add(new LatLng(9.878434,78.082095));
        WHKSAUDITORIUM.add(new LatLng(9.878479,78.082776));
        WHKSAUDITORIUM.add(new LatLng(9.878910,78.082653));
        WHKSAUDITORIUM.add(new LatLng(9.879288,78.082626));
        WHKSAUDITORIUM.add(new LatLng(9.879373,78.082685));
        WHKSAUDITORIUM.add(new LatLng(9.879518,78.082975));
        WHKSAUDITORIUM.add(new LatLng(9.879632,78.083372));
        WHKSAUDITORIUM.add(new LatLng(9.879832,78.083329));
        WHKSAUDITORIUM.add(new LatLng(9.879979,78.083493));
        WHKSAUDITORIUM.add(new LatLng(9.880375,78.083386));
        WHKSAUDITORIUM.add(new LatLng(9.880672,78.083442));
        WHKSAUDITORIUM.add(new LatLng(9.881301,78.083517));
        WHKSAUDITORIUM.add(new LatLng(9.881682,78.083426));
        WHKSAUDITORIUM.add(new LatLng(9.882208,78.083411));
        WHKSAUDITORIUM.add(new LatLng(9.882319,78.083360));
        WHKSAUDITORIUM.add(new LatLng(9.882398,78.083309));
        WHKSAUDITORIUM.add(new LatLng(9.882554,78.083288));
        WHKSAUDITORIUM.add(new LatLng(9.882691,78.083267));
        WHKSAUDITORIUM.add(new LatLng(9.882710,78.083130));
        WHKSAUDITORIUM.add(new LatLng(9.882731,78.082759));
        WHKSAUDITORIUM.add(new LatLng(9.882750,78.082536));
        WHKSAUDITORIUM.add(new LatLng(9.882786,78.081976));
        WHKSAUDITORIUM.add(new LatLng(9.882820,78.082337));



        WHKMAUDITORIUM.add(new LatLng(9.878201,78.082072));
        WHKMAUDITORIUM.add(new LatLng(9.878434,78.082095));
        WHKMAUDITORIUM.add(new LatLng(9.878479,78.082776));
        WHKMAUDITORIUM.add(new LatLng(9.878910,78.082653));
        WHKMAUDITORIUM.add(new LatLng(9.879288,78.082626));
        WHKMAUDITORIUM.add(new LatLng(9.879373,78.082685));
        WHKMAUDITORIUM.add(new LatLng(9.879518,78.082975));
        WHKMAUDITORIUM.add(new LatLng(9.879632,78.083372));
        WHKMAUDITORIUM.add(new LatLng(9.879832,78.083329));
        WHKMAUDITORIUM.add(new LatLng(9.879979,78.083493));
        WHKMAUDITORIUM.add(new LatLng(9.880375,78.083386));
        WHKMAUDITORIUM.add(new LatLng(9.880672,78.083442));
        WHKMAUDITORIUM.add(new LatLng(9.881301,78.083517));
        WHKMAUDITORIUM.add(new LatLng(9.881682,78.083426));
        WHKMAUDITORIUM.add(new LatLng(9.882208,78.083411));
        WHKMAUDITORIUM.add(new LatLng(9.882319,78.083360));
        WHKMAUDITORIUM.add(new LatLng(9.882398,78.083309));
        WHKMAUDITORIUM.add(new LatLng(9.882554,78.083288));
        WHKMAUDITORIUM.add(new LatLng(9.882691,78.083267));
        WHKMAUDITORIUM.add(new LatLng(9.882710,78.083130));
        WHKMAUDITORIUM.add(new LatLng(9.882731,78.082759));
        WHKMAUDITORIUM.add(new LatLng(9.882716,78.082540));
        WHKMAUDITORIUM.add(new LatLng(9.882480,78.082541));



        WHPLACEMENTCELL.add(new LatLng(9.878201,78.082072));
        WHPLACEMENTCELL.add(new LatLng(9.878434,78.082095));
        WHPLACEMENTCELL.add(new LatLng(9.878479,78.082776));
        WHPLACEMENTCELL.add(new LatLng(9.878910,78.082653));
        WHPLACEMENTCELL.add(new LatLng(9.879288,78.082626));
        WHPLACEMENTCELL.add(new LatLng(9.879373,78.082685));
        WHPLACEMENTCELL.add(new LatLng(9.879518,78.082975));
        WHPLACEMENTCELL.add(new LatLng(9.879632,78.083372));
        WHPLACEMENTCELL.add(new LatLng(9.879832,78.083329));
        WHPLACEMENTCELL.add(new LatLng(9.879979,78.083493));
        WHPLACEMENTCELL.add(new LatLng(9.880375,78.083386));
        WHPLACEMENTCELL.add(new LatLng(9.880672,78.083442));
        WHPLACEMENTCELL.add(new LatLng(9.881301,78.083517));
        WHPLACEMENTCELL.add(new LatLng(9.881682,78.083426));
        WHPLACEMENTCELL.add(new LatLng(9.882124,78.083426));
        WHPLACEMENTCELL.add(new LatLng(9.882124,78.083251));
        WHPLACEMENTCELL.add(new LatLng(9.882124,78.083002));
        WHPLACEMENTCELL.add(new LatLng(9.881980,78.083002));
        WHPLACEMENTCELL.add(new LatLng(9.881980,78.082442));
        WHPLACEMENTCELL.add(new LatLng(9.882207,78.082300));
        WHPLACEMENTCELL.add(new LatLng(9.882321,78.081682));
        WHPLACEMENTCELL.add(new LatLng(9.882399,78.081653));
        WHPLACEMENTCELL.add(new LatLng(9.883234,78.081681));
        WHPLACEMENTCELL.add(new LatLng(9.883262,78.080870));
        WHPLACEMENTCELL.add(new LatLng(9.883286,78.080765));
        WHPLACEMENTCELL.add(new LatLng(9.883458,78.080706));
        WHPLACEMENTCELL.add(new LatLng(9.885033,78.080787));
        WHPLACEMENTCELL.add(new LatLng(9.885026,78.080954));



        WHGUESTHOUSE.add(new LatLng(9.878201,78.082072));
        WHGUESTHOUSE.add(new LatLng(9.878434,78.082095));
        WHGUESTHOUSE.add(new LatLng(9.878479,78.082776));
        WHGUESTHOUSE.add(new LatLng(9.878910,78.082653));
        WHGUESTHOUSE.add(new LatLng(9.879288,78.082626));
        WHGUESTHOUSE.add(new LatLng(9.879373,78.082685));
        WHGUESTHOUSE.add(new LatLng(9.879518,78.082975));
        WHGUESTHOUSE.add(new LatLng(9.879632,78.083372));
        WHGUESTHOUSE.add(new LatLng(9.879832,78.083329));
        WHGUESTHOUSE.add(new LatLng(9.879979,78.083493));
        WHGUESTHOUSE.add(new LatLng(9.880375,78.083386));
        WHGUESTHOUSE.add(new LatLng(9.880672,78.083442));
        WHGUESTHOUSE.add(new LatLng(9.881301,78.083517));
        WHGUESTHOUSE.add(new LatLng(9.881682,78.083426));
        WHGUESTHOUSE.add(new LatLng(9.882124,78.083426));
        WHGUESTHOUSE.add(new LatLng(9.882124,78.083251));
        WHGUESTHOUSE.add(new LatLng(9.882124,78.083002));
        WHGUESTHOUSE.add(new LatLng(9.881980,78.083002));
        WHGUESTHOUSE.add(new LatLng(9.881980,78.082442));
        WHGUESTHOUSE.add(new LatLng(9.882207,78.082300));
        WHGUESTHOUSE.add(new LatLng(9.882321,78.081682));
        WHGUESTHOUSE.add(new LatLng(9.882399,78.081653));
        WHGUESTHOUSE.add(new LatLng(9.883234,78.081681));
        WHGUESTHOUSE.add(new LatLng(9.883262,78.080870));
        WHGUESTHOUSE.add(new LatLng(9.883286,78.080765));
        WHGUESTHOUSE.add(new LatLng(9.883458,78.080706));
        WHGUESTHOUSE.add(new LatLng(9.885219,78.080794));
        WHGUESTHOUSE.add(new LatLng(9.885211,78.080632));



        WHMAINCANTEEN.add(new LatLng(9.878201,78.082072));
        WHMAINCANTEEN.add(new LatLng(9.878434,78.082095));
        WHMAINCANTEEN.add(new LatLng(9.878479,78.082776));
        WHMAINCANTEEN.add(new LatLng(9.878910,78.082653));
        WHMAINCANTEEN.add(new LatLng(9.879288,78.082626));
        WHMAINCANTEEN.add(new LatLng(9.879373,78.082685));
        WHMAINCANTEEN.add(new LatLng(9.879518,78.082975));
        WHMAINCANTEEN.add(new LatLng(9.879632,78.083372));
        WHMAINCANTEEN.add(new LatLng(9.879832,78.083329));
        WHMAINCANTEEN.add(new LatLng(9.879979,78.083493));
        WHMAINCANTEEN.add(new LatLng(9.880375,78.083386));
        WHMAINCANTEEN.add(new LatLng(9.880672,78.083442));
        WHMAINCANTEEN.add(new LatLng(9.881301,78.083517));
        WHMAINCANTEEN.add(new LatLng(9.881682,78.083426));
        WHMAINCANTEEN.add(new LatLng(9.882124,78.083426));
        WHMAINCANTEEN.add(new LatLng(9.882124,78.083251));
        WHMAINCANTEEN.add(new LatLng(9.882124,78.083002));
        WHMAINCANTEEN.add(new LatLng(9.881980,78.083002));
        WHMAINCANTEEN.add(new LatLng(9.881980,78.082442));
        WHMAINCANTEEN.add(new LatLng(9.882207,78.082300));
        WHMAINCANTEEN.add(new LatLng(9.882321,78.081682));
        WHMAINCANTEEN.add(new LatLng(9.882399,78.081653));
        WHMAINCANTEEN.add(new LatLng(9.883234,78.081681));
        WHMAINCANTEEN.add(new LatLng(9.883286,78.080765));
        WHMAINCANTEEN.add(new LatLng(9.883277,78.080255));
        WHMAINCANTEEN.add(new LatLng(9.883264,78.079857));



        WHFOODCOURT.add(new LatLng(9.878201,78.082072));
        WHFOODCOURT.add(new LatLng(9.878434,78.082095));
        WHFOODCOURT.add(new LatLng(9.878479,78.082776));
        WHFOODCOURT.add(new LatLng(9.878910,78.082653));
        WHFOODCOURT.add(new LatLng(9.879288,78.082626));
        WHFOODCOURT.add(new LatLng(9.879373,78.082685));
        WHFOODCOURT.add(new LatLng(9.879518,78.082975));
        WHFOODCOURT.add(new LatLng(9.879632,78.083372));
        WHFOODCOURT.add(new LatLng(9.879832,78.083329));
        WHFOODCOURT.add(new LatLng(9.879979,78.083493));
        WHFOODCOURT.add(new LatLng(9.880375,78.083386));
        WHFOODCOURT.add(new LatLng(9.880672,78.083442));
        WHFOODCOURT.add(new LatLng(9.881301,78.083517));
        WHFOODCOURT.add(new LatLng(9.881682,78.083426));
        WHFOODCOURT.add(new LatLng(9.882397,78.083426));
        WHFOODCOURT.add(new LatLng(9.882893,78.083421));
        WHFOODCOURT.add(new LatLng(9.883181,78.083246));
        WHFOODCOURT.add(new LatLng(9.883282,78.083236));



        WHMENSHOSTEL.add(new LatLng(9.878201,78.082072));
        WHMENSHOSTEL.add(new LatLng(9.878434,78.082095));
        WHMENSHOSTEL.add(new LatLng(9.878479,78.082776));
        WHMENSHOSTEL.add(new LatLng(9.878910,78.082653));
        WHMENSHOSTEL.add(new LatLng(9.879288,78.082626));
        WHMENSHOSTEL.add(new LatLng(9.879373,78.082685));
        WHMENSHOSTEL.add(new LatLng(9.879518,78.082975));
        WHMENSHOSTEL.add(new LatLng(9.879632,78.083372));
        WHMENSHOSTEL.add(new LatLng(9.879832,78.083329));
        WHMENSHOSTEL.add(new LatLng(9.879979,78.083493));
        WHMENSHOSTEL.add(new LatLng(9.880375,78.083386));
        WHMENSHOSTEL.add(new LatLng(9.880672,78.083442));
        WHMENSHOSTEL.add(new LatLng(9.881301,78.083517));
        WHMENSHOSTEL.add(new LatLng(9.881682,78.083426));
        WHMENSHOSTEL.add(new LatLng(9.882124,78.083426));
        WHMENSHOSTEL.add(new LatLng(9.882124,78.083251));
        WHMENSHOSTEL.add(new LatLng(9.882124,78.083002));
        WHMENSHOSTEL.add(new LatLng(9.881980,78.083002));
        WHMENSHOSTEL.add(new LatLng(9.881980,78.082442));
        WHMENSHOSTEL.add(new LatLng(9.882207,78.082300));
        WHMENSHOSTEL.add(new LatLng(9.882321,78.081682));
        WHMENSHOSTEL.add(new LatLng(9.882399,78.081653));
        WHMENSHOSTEL.add(new LatLng(9.883234,78.081681));
        WHMENSHOSTEL.add(new LatLng(9.883262,78.080870));
        WHMENSHOSTEL.add(new LatLng(9.883286,78.080765));
        WHMENSHOSTEL.add(new LatLng(9.883458,78.080706));
        WHMENSHOSTEL.add(new LatLng(9.884778,78.080787));
        WHMENSHOSTEL.add(new LatLng(9.884738,78.080071));



        WHLIBRARY.add(new LatLng(9.878201,78.082072));
        WHLIBRARY.add(new LatLng(9.878434,78.082095));
        WHLIBRARY.add(new LatLng(9.878479,78.082776));
        WHLIBRARY.add(new LatLng(9.878910,78.082653));
        WHLIBRARY.add(new LatLng(9.879288,78.082626));
        WHLIBRARY.add(new LatLng(9.879373,78.082685));
        WHLIBRARY.add(new LatLng(9.879518,78.082975));
        WHLIBRARY.add(new LatLng(9.879632,78.083372));
        WHLIBRARY.add(new LatLng(9.879832,78.083329));
        WHLIBRARY.add(new LatLng(9.879979,78.083493));
        WHLIBRARY.add(new LatLng(9.880375,78.083386));
        WHLIBRARY.add(new LatLng(9.880672,78.083442));
        WHLIBRARY.add(new LatLng(9.881301,78.083517));
        WHLIBRARY.add(new LatLng(9.881682,78.083426));
        WHLIBRARY.add(new LatLng(9.882124,78.083426));
        WHLIBRARY.add(new LatLng(9.882124,78.083251));
        WHLIBRARY.add(new LatLng(9.882124,78.083002));
        WHLIBRARY.add(new LatLng(9.881980,78.083002));
        WHLIBRARY.add(new LatLng(9.881980,78.082442));
        WHLIBRARY.add(new LatLng(9.882207,78.082300));
        WHLIBRARY.add(new LatLng(9.882321,78.081682));
        WHLIBRARY.add(new LatLng(9.882399,78.081653));
        WHLIBRARY.add(new LatLng(9.882982,78.081681));
        WHLIBRARY.add(new LatLng(9.882982,78.081445));
        WHLIBRARY.add(new LatLng(9.883105,78.081445));
        WHLIBRARY.add(new LatLng(9.882854,78.081243));



        WHBANK.add(new LatLng(9.878201,78.082072));
        WHBANK.add(new LatLng(9.878434,78.082095));
        WHBANK.add(new LatLng(9.878479,78.082776));
        WHBANK.add(new LatLng(9.878910,78.082653));
        WHBANK.add(new LatLng(9.879288,78.082626));
        WHBANK.add(new LatLng(9.879373,78.082685));
        WHBANK.add(new LatLng(9.879518,78.082975));
        WHBANK.add(new LatLng(9.879632,78.083372));
        WHBANK.add(new LatLng(9.879832,78.083329));
        WHBANK.add(new LatLng(9.879979,78.083493));
        WHBANK.add(new LatLng(9.880375,78.083386));
        WHBANK.add(new LatLng(9.880672,78.083442));
        WHBANK.add(new LatLng(9.881301,78.083517));
        WHBANK.add(new LatLng(9.881682,78.083426));
        WHBANK.add(new LatLng(9.882124,78.083426));
        WHBANK.add(new LatLng(9.882124,78.083251));
        WHBANK.add(new LatLng(9.882124,78.083002));
        WHBANK.add(new LatLng(9.881980,78.083002));
        WHBANK.add(new LatLng(9.881980,78.082442));
        WHBANK.add(new LatLng(9.882207,78.082300));
        WHBANK.add(new LatLng(9.882321,78.081682));
        WHBANK.add(new LatLng(9.882399,78.081653));
        WHBANK.add(new LatLng(9.883234,78.081681));
        WHBANK.add(new LatLng(9.883262,78.080870));
        WHBANK.add(new LatLng(9.883286,78.080765));
        WHBANK.add(new LatLng(9.883458,78.080706));
        WHBANK.add(new LatLng(9.883496,78.079848));



        WHTEMPLE.add(new LatLng(9.878201,78.082072));
        WHTEMPLE.add(new LatLng(9.878434,78.082095));
        WHTEMPLE.add(new LatLng(9.878479,78.082776));
        WHTEMPLE.add(new LatLng(9.878910,78.082653));
        WHTEMPLE.add(new LatLng(9.879288,78.082626));
        WHTEMPLE.add(new LatLng(9.879373,78.082685));
        WHTEMPLE.add(new LatLng(9.879518,78.082975));
        WHTEMPLE.add(new LatLng(9.879632,78.083372));
        WHTEMPLE.add(new LatLng(9.879832,78.083329));
        WHTEMPLE.add(new LatLng(9.879979,78.083493));
        WHTEMPLE.add(new LatLng(9.880375,78.083386));
        WHTEMPLE.add(new LatLng(9.880672,78.083442));
        WHTEMPLE.add(new LatLng(9.881301,78.083517));
        WHTEMPLE.add(new LatLng(9.881682,78.083426));
        WHTEMPLE.add(new LatLng(9.882124,78.083426));
        WHTEMPLE.add(new LatLng(9.882124,78.083251));
        WHTEMPLE.add(new LatLng(9.882124,78.083002));
        WHTEMPLE.add(new LatLng(9.881980,78.083002));
        WHTEMPLE.add(new LatLng(9.881980,78.082442));
        WHTEMPLE.add(new LatLng(9.882207,78.082300));
        WHTEMPLE.add(new LatLng(9.882321,78.081682));
        WHTEMPLE.add(new LatLng(9.882399,78.081653));
        WHTEMPLE.add(new LatLng(9.883234,78.081681));
        WHTEMPLE.add(new LatLng(9.883262,78.080870));
        WHTEMPLE.add(new LatLng(9.883286,78.080765));
        WHTEMPLE.add(new LatLng(9.883368,78.080711));
        WHTEMPLE.add(new LatLng(9.883896,78.080727));
        WHTEMPLE.add(new LatLng(9.884735,78.080781));
        WHTEMPLE.add(new LatLng(9.885035,78.080792));
        WHTEMPLE.add(new LatLng(9.885443,78.080804));
        WHTEMPLE.add(new LatLng(9.885459,78.080574));



        WHPARKING.add(new LatLng(9.878201,78.082072));
        WHPARKING.add(new LatLng(9.878434,78.082095));
        WHPARKING.add(new LatLng(9.878479,78.082776));
        WHPARKING.add(new LatLng(9.878910,78.082653));
        WHPARKING.add(new LatLng(9.879288,78.082626));
        WHPARKING.add(new LatLng(9.879373,78.082685));
        WHPARKING.add(new LatLng(9.879518,78.082975));
        WHPARKING.add(new LatLng(9.879632,78.083372));
        WHPARKING.add(new LatLng(9.879832,78.083329));
        WHPARKING.add(new LatLng(9.879979,78.083493));
        WHPARKING.add(new LatLng(9.880375,78.083386));
        WHPARKING.add(new LatLng(9.880672,78.083442));
        WHPARKING.add(new LatLng(9.881301,78.083517));
        WHPARKING.add(new LatLng(9.881682,78.083426));
        WHPARKING.add(new LatLng(9.882124,78.083426));
        WHPARKING.add(new LatLng(9.882124,78.083251));
        WHPARKING.add(new LatLng(9.882124,78.083002));
        WHPARKING.add(new LatLng(9.881980,78.083002));
        WHPARKING.add(new LatLng(9.881980,78.082442));
        WHPARKING.add(new LatLng(9.882207,78.082300));
        WHPARKING.add(new LatLng(9.882321,78.081682));
        WHPARKING.add(new LatLng(9.882399,78.081653));
        WHPARKING.add(new LatLng(9.883234,78.081681));
        WHPARKING.add(new LatLng(9.883252,78.081003));
        WHPARKING.add(new LatLng(9.883106,78.080998));
        WHPARKING.add(new LatLng(9.883104,78.080942));


    }
}
