DESCRIPTION = "Switch Multiplus to charge-only if BMS disables discharge"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit allarch
inherit ve_package
inherit daemontools

RDEPENDS_${PN} += " \
	python-dbus \
"

SRC_URI = " \
	gitsm://github.com/izak/bms-bridge.git;protocol=https;tag=v${PV} \
"

S = "${WORKDIR}/git"

DEST_DIR = "${D}${BASE_DIR}"
DAEMONTOOLS_SERVICE_DIR = "${bindir}/service"
DAEMONTOOLS_RUN = "softlimit -d 100000000 -s 1000000 -a 100000000 ${bindir}/bms-bridge.py"

do_install () {
	install -d ${D}${bindir}
	install -m 755 -D ${S}/bms-bridge.py ${D}${bindir}
}
