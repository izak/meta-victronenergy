require u-boot-rpi.inc

# u-boot-raspberrypi3 is not a full loader, just an alternative build for the
# rpi3. We depend on it because it is listed in config.txt.
RDEPENDS_${PN} = "u-boot-raspberrypi3"

SRC_URI += " \
	file://uEnv.txt \
    file://config.txt \
"

# Install required file for Raspberry Pi bootloader, to indicate that it should
# load u-boot.
do_deploy_append() {
    install ${WORKDIR}/config.txt ${DEPLOYDIR}/config.txt
    ${S}/tools/mkenvimage -s 16384 -o ${DEPLOYDIR}/uboot.env ${WORKDIR}/uEnv.txt
}
