import os
import re
import setuptools

with open("README.md", "r") as fh:
    long_description = fh.read()

here = os.path.abspath(os.path.dirname(__file__))

def get_version():
    version_file = os.path.join(here, "{{name}}", "__init__.py")
    with open(version_file, encoding="utf-8") as f:
        return re.search(r'^__version__ = [\'"]([^\'"]*)[\'"]', f.read(), re.M).group(1)

setuptools.setup(
    name="{{name}}",
    version=get_version(),
    author="Example Author",
    author_email="author@example.com",
    description="A small example package",
    long_description=long_description,
    long_description_content_type="text/markdown",
    url="https://github.com/pypa/sampleproject",

    packages=setuptools.find_packages(exclude=('tests')),
        python_requires='>=3.6',
    install_requires=[],
    extras_require={"tests": ["pytest"]},

    classifiers=[
        "Programming Language :: Python :: 3",
        "License :: OSI Approved :: MIT License",
        "Operating System :: OS Independent",
    ],

)
