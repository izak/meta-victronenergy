SUMMARY = "common machine specific venus base packages"
DESCRIPTION = "see packagegroup-venus-base, this contain the per MACHINE base adjustments."

PACKAGE_ARCH = "${MACHINE_ARCH}"
inherit packagegroup
LICENSE = "MIT"


DEPENDS_append_ccgx += "\
	technexion-serial \
"

RDEPENDS_${PN} += "\
	simple-upnpd \
"

RDEPENDS_${PN}_append_canvu500 += "\
	cinematicexperience \
	evtest \
	eglinfo-fb \
	imx-kobs \
	kmscube \
	mtd-utils \
	mtd-utils-ubifs \
	pointercal \
	qt5-opengles2-test \
	qt-kms-config \
	swupdate \
	swupdate-scripts \
"

RDEPENDS_${PN}_append_ccgx += "\
	gpio-export \
	mtd-utils \
	mtd-utils-ubifs \
	prodtest \
	swupdate \
	swupdate-scripts \
"

RDEPENDS_${PN}_append_beaglebone += "\
	dnsmasq \
	gpio-export \
	hostapd \
	i2c-tools \
	linux-firmware-rtl8723b \
	prodtest \
	swupdate \
	swupdate-scripts \
"

RDEPENDS_${PN}_append_raspberrypi2 += "\
	gpio-export \
	linux-firmware-bcm43430 \
	swupdate \
	swupdate-scripts \
"
