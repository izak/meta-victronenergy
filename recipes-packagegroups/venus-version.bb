PR = "${DISTRO_VERSION}"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit ve_package
SRC_URI = "file://reboot-after-opkg-done.sh"

do_install () {
	echo -e "${DISTRO_VERSION}\n${DISTRO_NAME}\n${BUILDNAME}" > version
	install -d ${D}${vedir}
	install -m 644 version ${D}${vedir}

	install -d ${D}${vedir}/opkg-scripts
	install -m 755 ${WORKDIR}/reboot-after-opkg-done.sh ${D}${vedir}/opkg-scripts
}

pkg_postinst_${PN}() {
	if [ "x$D" == "x" ]; then
		echo Starting reboot workaround
		${vedir}/opkg-scripts/reboot-after-opkg-done.sh &
	fi
}

FILES_${PN} += "${vedir}"