# ABAP Code Insight

ABAP Code Insight is an Open Source Plugin which enabled inline code information for ABAP code in Eclipse. 

The only prerequisite to use this plugin for developing with ABAP is an [ABAP Development Tool (ADT) on Eclipse](https://tools.hana.ondemand.com/#abap) installation. 

The plugin shows<br> 
         * **reference counts** - for ABAP classes, interfaces, reports, function modules and CDS views<br>
         * **method signature information**  -  for ABAP methods, thus the header and body definition of ABAP methods are not separated anymore<br>
         
![Abap Code Insight Screenshot](https://github.com/andau/abap-code-insight/blob/master/docu/abap_code_insight_animated_gif_1.gif)

Each type of inline code information can be activated/deactived in the ABAP preferences, section Code Insight (experimental).

The plugin can be installed over the Eclipse Marketplace, see [Eclipse Marketplace - ABAP Code Insight](https://marketplace.eclipse.org/content/abap-code-insight) or by forking this repository. 

**If the plugin is not activated after updating, start Eclipse one time from the command line with the parameter -clean**
