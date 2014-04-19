<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<link rel="stylesheet" href="css/main.css" type="text/css" />
	<head>
	
	<script>
			function showCourse(str)
			{
			var xmlhttp;    
			if (str=="")
			  {
			  document.getElementById("txtHint").innerHTML="";
			  return;
			  }
			if (window.XMLHttpRequest)
			  {// code for IE7+, Firefox, Chrome, Opera, Safari
			  xmlhttp=new XMLHttpRequest();
			  }
			else
			  {// code for IE6, IE5
			  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			  }
			xmlhttp.onreadystatechange=function()
			  {
			  if (xmlhttp.readyState==4 && xmlhttp.status==200)
			    {
			    document.getElementById("txtHint").innerHTML=xmlhttp.responseText;
			    }
			  }
			xmlhttp.open("GET","coursePicker?department="+str,true);
			xmlhttp.send();
			}
		</script>
	
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>UGA Book Exchange</title>
	</head>
	
	<body>
		
		<div id="loginPanel">
			<a class="links" href="login.jsp">Login&nbsp</a>
			<a class="links" href="signup.jsp">Signup</a>
		</div>
		
		<div id="titleDiv">
		<p id="siteTitle">The UGA</br>Book Exchange</p>
		<p id="slogan">trade a book, save a tree</p>
		</div>		
	
		<div id="searchDiv">
			<form style="text-align:center";>
				<input id="searchBox" type="text" placeholder="Search for a book" />
				<input class="searchButton" type="submit" value="Search" /> 
			</form>
			</br>
			<form>
				<select class="dropdownMenu" name="department" onchange="showCourse(this.value)>
					<option selected="selected" value="-1">Browse by department</option>
							
					<option value="AAEC">AAEC - Agricultural and Applied Economics</option>
					<option value="ACAC">ACAC - Academic Assistance Counseling</option>
					<option value="ACAE">ACAE - Academic Assistance English</option>
					<option value="ACAM">ACAM - Academic Assistance Math</option>
					<option value="ACAR">ACAR - Academic Assistance Reading</option>
					<option value="ACCT">ACCT - Accounting</option>
					<option value="ADPR">ADPR - Advertising and Public Relations</option>
					<option value="ADSC">ADSC - Animal and Dairy Sciences</option>
					<option value="AESC">AESC - Agricultural and Environmental Sciences</option>
					<option value="AEXT">AEXT - Agricultural Extension</option>
					<option value="AFAM">AFAM - African American Studies</option>
					<option value="AFST">AFST - African Studies</option>
					<option value="AGCM">AGCM - Agricultural Communications</option>
					<option value="AGED">AGED - Agricultural Education</option>
					<option value="AIRS">AIRS - Air Force ROTC - Aerospace Studies</option>
					<option value="ALDR">ALDR - Agricultural Leadership</option>
					<option value="AMHA">AMHA - Amharic Studies</option>
					<option value="ANNU">ANNU - Animal Nutrition</option>
					<option value="ANTH">ANTH - Anthropology</option>
					<option value="APTC">APTC - Applied Technology</option>
					<option value="ARAB">ARAB - Arabic</option>
					<option value="ARED">ARED - Art Education</option>
					<option value="ARGD">ARGD - Art Graphic Design</option>
					<option value="ARHI">ARHI - Art History</option>
					<option value="ARID">ARID - Art Interior Design</option>
					<option value="ARST">ARST - Art Studio Art</option>
					<option value="ARTI">ARTI - Artificial Intelligence</option>
					<option value="ARTS">ARTS - Art</option>
					<option value="ASTR">ASTR - Astronomy</option>
					<option value="BCHE">BCHE - Biochemical Engineering</option>
					<option value="BCMB">BCMB - Biochemistry and Molecular Biology</option>
					<option value="BENG">BENG - Bengali</option>
					<option value="BHSI">BHSI - Biomedical and Health Sciences Institute</option>
					<option value="BINF">BINF - Bioinformatics</option>
					<option value="BIOL">BIOL - Biology</option>
					<option value="BIOS">BIOS - Biostatistics</option>
					<option value="BTEC">BTEC - Biotechnology</option>
					<option value="BUSN">BUSN - Business</option>
					<option value="CBIO">CBIO - Cellular Biology</option>
					<option value="CHEM">CHEM - Chemistry</option>
					<option value="CHFD">CHFD - Child and Family Development</option>
					<option value="CHNS">CHNS - Chinese</option>
					<option value="CLAS">CLAS - Classical Culture</option>
					<option value="CMLT">CMLT - Comparative Literature</option>
					<option value="CMSD">CMSD - Communication Sciences and Disorders</option>
					<option value="COMM">COMM - Communication Studies</option>
					<option value="CRSS">CRSS - Crop and Soil Sciences</option>
					<option value="CSCI">CSCI - Computer Science</option>
					<option value="CSEE">CSEE - Computer Systems Engineering</option>
					<option value="CVLE">CVLE - Civil Engineering</option>
					<option value="DANC">DANC - Dance</option>
					<option value="DMAN">DMAN - Disaster Management</option>
					<option value="DRAM">DRAM - Drama</option>
					<option value="EADU">EADU - Adult Education</option>
					<option value="EBUS">EBUS - Business Education</option>
					<option value="ECHD">ECHD - Counseling and Human Development Services</option>
					<option value="ECOL">ECOL - Ecology</option>
					<option value="ECON">ECON - Economics</option>
					<option value="EDAP">EDAP - Educational Administration and Policy</option>
					<option value="EDEC">EDEC - Early Childhood Education</option>
					<option value="EDEL">EDEL - Elementary Education</option>
					<option value="EDES">EDES - Environmental Design</option>
					<option value="EDHI">EDHI - Higher Education</option>
					<option value="EDIT">EDIT - Instructional Technology Education</option>
					<option value="EDMS">EDMS - Middle School Education</option>
					<option value="EDUC">EDUC - Education</option>
					<option value="EDUL">EDUL - Educational Leadership</option>
					<option value="EETH">EETH - Environmental Ethics</option>
					<option value="EFCS">EFCS - Family and Consumer Sciences Education</option>
					<option value="EFND">EFND - Foundations of Education</option>
					<option value="EHSC">EHSC - Environmental Health Science</option>
					<option value="ELAN">ELAN - Language Education</option>
					<option value="ELEE">ELEE - Electrical and Electronics Engineering</option>
					<option value="EMAT">EMAT - Mathematics Education</option>
					<option value="EMBA">EMBA - Executive MBA</option>
					<option value="EMKT">EMKT - Marketing Education</option>
					<option value="EMUS">EMUS - Music Education</option>
					<option value="ENED">ENED - Engineering Education</option>
					<option value="ENGG">ENGG - General Faculty of Engineering courses</option>
					<option value="ENGL">ENGL - English</option>
					<option value="ENGR">ENGR - Engineering</option>
					<option value="ENTO">ENTO - Entomology</option>
					<option value="ENVE">ENVE - Environmental Engineering</option>
					<option value="ENVM">ENVM - Environmental Economics and Management</option>
					<option value="EOCS">EOCS - Occupational Studies</option>
					<option value="EPID">EPID - Epidemiology</option>
					<option value="EPIT">EPIT - Educational Psychology and Instructional Technology</option>
					<option value="EPSY">EPSY - Educational Psychology</option>
					<option value="ERSH">ERSH - Educational Research and Measurement</option>
					<option value="ESCI">ESCI - Science Education</option>
					<option value="ESOC">ESOC - Social Studies Education</option>
					<option value="ESSE">ESSE - Elementary and Social Studies Education</option>
					<option value="ESWK">ESWK - Social Work Education</option>
					<option value="ETAP">ETAP - Educational Theory and Practice</option>
					<option value="ETES">ETES - Technological Studies</option>
					<option value="FANR">FANR - Forestry and Natural Resources</option>
					<option value="FCID">FCID - Franklin College Interdisciplinary</option>
					<option value="FDNS">FDNS - Foods and Nutrition</option>
					<option value="FDST">FDST - Food Science and Technology</option>
					<option value="FHCE">FHCE - Financial Planning, Housing and Consumer Economics</option>
					<option value="FILM">FILM - Film</option>
					<option value="FINA">FINA - Banking and Finance</option>
					<option value="FISH">FISH - Fisheries and Aquaculture</option>
					<option value="FORS">FORS - Forestry and Natural Resources</option>
					<option value="FREN">FREN - French</option>
					<option value="FRES">FRES - Freshman Seminars</option>
					<option value="FYOS">FYOS - First-Year Odyssey Seminar</option>
					<option value="GENE">GENE - Genetics</option>
					<option value="GEOG">GEOG - Geography</option>
					<option value="GEOL">GEOL - Geology</option>
					<option value="GLOB">GLOB - Global Health</option>
					<option value="GPST">GPST - Global Policy Studies</option>
					<option value="GREK">GREK - Greek</option>
					<option value="GRMN">GRMN - German</option>
					<option value="GRNT">GRNT - Gerontology</option>
					<option value="GRSC">GRSC - Graduate School</option>
					<option value="HACE">HACE - Housing and Consumer Economics</option>
					<option value="HADM">HADM - Health Administration</option>
					<option value="HDFS">HDFS - Human Development and Family Science</option>
					<option value="HEBR">HEBR - Hebrew</option>
					<option value="HIPR">HIPR - Historic Preservation</option>
					<option value="HIST">HIST - History</option>
					<option value="HNDI">HNDI - Hindi</option>
					<option value="HONS">HONS - Honors</option>
					<option value="HORT">HORT - Horticulture</option>
					<option value="HPAM">HPAM - Health Policy and Management</option>
					<option value="HPRB">HPRB - Health Promotion and Behavior</option>
					<option value="ICON">ICON - Integrative Conservation</option>
					<option value="IDIS">IDIS - Infectious Diseases</option>
					<option value="IEBP">IEBP - Evidence-Based Health Professions Education</option>
					<option value="IHDD">IHDD - Institute on Human Development and Disability</option>
					<option value="ILAD">ILAD - Institute for Leadership Advancement</option>
					<option value="INDO">INDO - Indonesian</option>
					<option value="INTB">INTB - International Business</option>
					<option value="INTL">INTL - International Affairs</option>
					<option value="INTS">INTS - Interdisciplinary Studies</option>
					<option value="ISCI">ISCI - Integrated Science</option>
					<option value="ITAL">ITAL - Italian</option>
					<option value="JNMW">JNMW - Journalism Narrative Media Writing</option>
					<option value="JOUR">JOUR - Journalism</option>
					<option value="JPNS">JPNS - Japanese</option>
					<option value="JRLC">JRLC - Journalism Core</option>
					<option value="JRMC">JRMC - Journalism and Mass Communication</option>
					<option value="JURI">JURI - Jurisprudence</option>
					<option value="KINS">KINS - Kinesiology</option>
					<option value="KREN">KREN - Korean</option>
					<option value="LACS">LACS - Latin American and Caribbean Studies</option>
					<option value="LAMS">LAMS - Large Animal Medicine and Surgery</option>
					<option value="LAND">LAND - Landscape Architecture</option>
					<option value="LATN">LATN - Latin</option>
					<option value="LEGL">LEGL - Legal Studies</option>
					<option value="LING">LING - Linguistics</option>
					<option value="LLED">LLED - Language and Literacy Education</option>
					<option value="MAND">MAND - Manding</option>
					<option value="MARK">MARK - Marketing</option>
					<option value="MARS">MARS - Marine Sciences</option>
					<option value="MATH">MATH - Mathematics</option>
					<option value="MBUS">MBUS - Music Business</option>
					<option value="MCHE">MCHE - Mechanical Engineering</option>
					<option value="MGMT">MGMT - Management</option>
					<option value="MIBO">MIBO - Microbiology</option>
					<option value="MILS">MILS - Army ROTC - Military Science</option>
					<option value="MIST">MIST - Management Information Systems</option>
					<option value="MNPO">MNPO - Master of Nonprofit Organizations</option>
					<option value="MSIT">MSIT - Management Sciences and Information Technology</option>
					<option value="MUSI">MUSI - Music</option>
					<option value="NAMS">NAMS - Native American Studies</option>
					<option value="NMIX">NMIX - New Media Institute</option>
					<option value="NRRT">NRRT - Natural Resource Recreation and Tourism</option>
					<option value="PADP">PADP - Public Administration and Policy</option>
					<option value="PASH">PASH - Pashto</option>
					<option value="PATH">PATH - Plant Pathology</option>
					<option value="PBGG">PBGG - Plant Breeding, Genetics, and Genomics</option>
					<option value="PBHL">PBHL - Public Health</option>
					<option value="PBIO">PBIO - Plant Biology</option>
					<option value="PEDB">PEDB - Physical Education Basic</option>
					<option value="PERS">PERS - Persian</option>
					<option value="PGEN">PGEN - Plant Genetics</option>
					<option value="PHAR">PHAR - Pharmacy</option>
					<option value="PHIL">PHIL - Philosophy</option>
					<option value="PHRM">PHRM - Pharmacy</option>
					<option value="PHYS">PHYS - Physics</option>
					<option value="PLAN">PLAN - Environmental Planning</option>
					<option value="PMCY">PMCY - Pharmacy</option>
					<option value="POLS">POLS - Political Science</option>
					<option value="POPH">POPH - Population Health</option>
					<option value="PORT">PORT - Portuguese</option>
					<option value="POUL">POUL - Poultry Science</option>
					<option value="PSYC">PSYC - Psychology</option>
					<option value="PTSP">PTSP - Portuguese and Spanish</option>
					<option value="QUAL">QUAL - Qualitative Research</option>
					<option value="QUEC">QUEC - Quechua</option>
					<option value="READ">READ - Reading Education</option>
					<option value="REAL">REAL - Real Estate</option>
					<option value="RELI">RELI - Religion</option>
					<option value="RGTE">RGTE - Regents' Test Essay Preparation</option>
					<option value="RGTR">RGTR - Regents' Test Reading Preparation</option>
					<option value="RLST">RLST - Recreation and Leisure Studies</option>
					<option value="RMIN">RMIN - Risk Management and Insurance</option>
					<option value="ROML">ROML - Romance Languages</option>
					<option value="RUSS">RUSS - Russian</option>
					<option value="SAMS">SAMS - Small Animal Medicine and Surgery</option>
					<option value="SCAN">SCAN - Scandinavian</option>
					<option value="SEMI">SEMI - Semitic</option>
					<option value="SLAV">SLAV - Slavic Languages and Cultures</option>
					<option value="SOCI">SOCI - Sociology</option>
					<option value="SOWK">SOWK - Social Work</option>
					<option value="SPAN">SPAN - Spanish</option>
					<option value="SPCM">SPCM - Speech Communication</option>
					<option value="SPED">SPED - Special Education</option>
					<option value="STAT">STAT - Statistics</option>
					<option value="SWAH">SWAH - Swahili</option>
					<option value="TELE">TELE - Telecommunications</option>
					<option value="THEA">THEA - Theatre</option>
					<option value="TURK">TURK - Turkish</option>
					<option value="TXMI">TXMI - Textiles, Merchandising and Interiors</option>
					<option value="UNIV">UNIV - University Orientation</option>
					<option value="URDU">URDU - Urdu</option>
					<option value="VARB">VARB - Veterinary Anatomy and Radiology</option>
					<option value="VBDI">VBDI - Veterinary Biosciences and Diagnostic Imaging</option>
					<option value="VETM">VETM - Veterinary Medicine</option>
					<option value="VIET">VIET - Vietnamese</option>
					<option value="VPAT">VPAT - Veterinary Pathology</option>
					<option value="VPHY">VPHY - Physiology and Pharmacology</option>
					<option value="WASH">WASH - Washington Semester Program</option>
					<option value="WASR">WASR - Water and Soil Resources</option>
					<option value="WFED">WFED - Workforce Education, Leadership, and Social Foundations</option>
					<option value="WILD">WILD - Wildlife</option>
					<option value="WIPP">WIPP - Writing Intensive Program Pedagogy</option>
					<option value="WMST">WMST - Women's Studies</option>
					<option value="YORB">YORB - Yoruba</option>
					<option value="ZULU">ZULU - Zulu</option>

				</select>
				<!--<div id="txtHint"><select name="className"><option value="">Select a Class</option></select></div>-->
				<input class="searchButton" type="submit" value="Search" />
			</form>
		</div>
		
		<!--<div id="moveSellTrade">
			<a class="sellTradeButtons" id="leftSellTrade" href="sell.jsp">sell a book</a>
			<a class="sellTradeButtons" id="rightSellTrade" href="trade.jsp">trade a book</a>	
		</div>-->	
	
		
		<div id="treeImg">
		<img src="css/tree.png">
		</div>
	
	</body>
</html>