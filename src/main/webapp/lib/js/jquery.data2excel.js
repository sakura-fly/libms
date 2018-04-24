$(function () {
    defaults = {
        exclude: ".noExl",
        name: "data",
        filename: "data",
        fileext: ".xls",
        exclude_img: true,
        exclude_links: true,
        exclude_inputs: true,
        content:[],
        title:[],
        fileds:[],
    };
})


function Plugin (  options ) {
    this.settings = $.extend( {}, defaults, options );
    init()
}


function init () {
	var e = this;

	var utf8Heading = "<meta http-equiv=\"content-type\" content=\"application/vnd.ms-excel; charset=UTF-8\">";
	template = {
		head: "<html xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:x=\"urn:schemas-microsoft-com:office:excel\" xmlns=\"http://www.w3.org/TR/REC-html40\">" + utf8Heading + "<head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets>",
		sheet: {
			head: "<x:ExcelWorksheet><x:Name>",
			tail: "</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet>"
		},
		mid: "</x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body>",
		table: {
			head: "<table>",
			tail: "</table>"
		},
		foot: "</body></html>"
	};
	tableRows = [];
	// 表头
	var th = "<tr>"
	for (var i = 0; i < e.settings.title.length; i++) {
		th += "<td>" + e.settings.title[i] + "</td>"
	}
	th += "</tr>";
	tableRows.push(th)
	//  表体
	for (var i = 0; i < e.settings.content.length; i++) {
		var d = e.settings.content[i];
		var td = "<tr>"
		for (var j = 0; j < e.settings.fileds.length; j++) {
			var di = d[ e.settings.fileds[j]];
			td += "<td>" + di + "</td>";
		}
		td += "</tr>"
		tableRows.push(td)
	}
		dataToExcel(tableRows, e.settings.name, e.settings.sheetName);

	 
   
}

 function dataToExcel(table, name, sheetName) {
            var e = this, fullTemplate="", i, link, a;

            e.format = function (s, c) {
                return s.replace(/{(\w+)}/g, function (m, p) {
                    return c[p];
                });
            };

            sheetName = typeof sheetName === "undefined" ? "Sheet" : sheetName;

            e.ctx = {
                worksheet: name || "Worksheet",
                table: table,
                sheetName: sheetName
            };

            fullTemplate= e.template.head;

            if ( $.isArray(table) ) {
                for (i in table) {
                      fullTemplate += e.template.sheet.head + sheetName + i + e.template.sheet.tail;
                }
            }

            fullTemplate += e.template.mid;

            if ( $.isArray(table) ) {
                for (i in table) {
                    fullTemplate += e.template.table.head + "{table" + i + "}" + e.template.table.tail;
                }
            }

            fullTemplate += e.template.foot;

            for (i in table) {
                e.ctx["table" + i] = table[i];
            }
            delete e.ctx.table;

            var isIE = /*@cc_on!@*/false || !!document.documentMode; 
            if (isIE) {
                if (typeof Blob !== "undefined") {
                    fullTemplate = e.format(fullTemplate, e.ctx); // with this, works with IE
                    fullTemplate = [fullTemplate];
                    var blob1 = new Blob(fullTemplate, { type: "text/html" });
                    window.navigator.msSaveBlob(blob1, getFileName(e.settings) );
                } else {
                    txtArea1.document.open("text/html", "replace");
                    txtArea1.document.write(e.format(fullTemplate, e.ctx));
                    txtArea1.document.close();
                    txtArea1.focus();
                    sa = txtArea1.document.execCommand("SaveAs", true, getFileName(e.settings) );
                }

            } else {
                var blob = new Blob([e.format(fullTemplate, e.ctx)], {type: "application/vnd.ms-excel"});
                window.URL = window.URL || window.webkitURL;
                link = window.URL.createObjectURL(blob);
                a = document.createElement("a");
                a.download = getFileName(e.settings);
                a.href = link;

                document.body.appendChild(a);

                a.click();

                document.body.removeChild(a);
            }

            return true;
        }
 function getFileName(settings) {
        return ( settings.filename ? settings.filename : "data2excel" ) + settings.fileext;
    }








$.data2excel = function(options){
    
    Plugin (  options );
}