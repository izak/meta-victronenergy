DESCRIPTION = "Communication driver for Bornay Wind+ MPPT controller."
HOMEPAGE = "https://github.com/CarlosBornay/Bornay-venus-driver"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRCREV = "be56d27e30711dfea61da133c36d032d9562c6ef"
SRC_URI = "\
    gitsm://github.com/izak/Bornay-venus-driver.git;protocol=http;branch=master \
    file://com.victronenergy.windcharger.conf \
"

SRC_URI[md5sum] = "29b173fd5fa572ec0764d1fd7b527260"
SRC_URI[sha256sum] = "398a3db6d61899d25fd4a06c6ca12051b0ce171d705decd7ed5511517b4bb93d"

S = "${WORKDIR}/git"

inherit allarch
#inherit setuptools
inherit ve_package
inherit daemontools

DAEMONTOOLS_SERVICE_DIR = "${bindir}/service"
DAEMONTOOLS_RUN = "${bindir}/bornay --Bornay_serial TTY"
DAEMONTOOLS_DOWN = "1"
DAEMONTOOLS_SERVICE_SYMLINK = "0"
DAEMONTOOLS_LOG_DIR = "${DAEMONTOOLS_LOG_DIR_PREFIX}/vedirect.TTY"

do_install_append () {
	install -d ${D}${bindir}
    install -m 755 driver_vic.py ${D}${bindir}
	cp -r ${S}/ext ${D}${bindir}/ext

    install -d ${D}/${sysconfdir}/dbus-1/system.d
    install -m 644 ${WORKDIR}/com.victronenergy.windcharger.conf ${D}/${sysconfdir}/dbus-1/system.d
}

RDEPENDS_${PN} = " \
	localsettings \
	python-argparse \
	python-dbus \
    python-pymodbus \
"
