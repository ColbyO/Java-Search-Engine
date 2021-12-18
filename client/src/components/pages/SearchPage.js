import React, { useState, useEffect } from 'react'
import axios from 'axios'
// COMPONENTS
import ListSearches from '../page components/ListSearches'
import NavBar from '../page components/NavBar'
import SQLDataService from '../services/SQL';
import MongoDBDataService from '../services/MongoDB';
// BOOTSTRAP
import { Container, InputGroup, Dropdown, DropdownButton, FormControl as FormControlBoot, Button as ButtonBoot, Modal, Form } from 'react-bootstrap'
// MATERIAL UI
import MoreVertIcon from '@material-ui/icons/MoreVert';
import { FormControl, Radio, RadioGroup, FormControlLabel, FormLabel, Button, IconButton } from '@material-ui/core';


function SearchPage({history}) {
    // Input setState
    const [username, setUsername] = useState(localStorage.getItem("username"))
    const [search, setSearch] = useState("")
    const [searchTerm, setSearchTerm] = useState()
    // Select database button
    const [database, setDatabase] = useState("Database")
    // Filter 
    const [radio, setRadio] = useState('firstname');
    // database button color
    const [databaseColor, setDatabaseColor] = useState("outline-secondary")
    // modal
    const [open, setOpen] = useState(false)

    axios.defaults.headers.post['Content-Type'] = 'application/json'
    axios.defaults.headers.common['Authorization'] = `Bearer ${localStorage.getItem("authToken")}`

    // Search Database function
    const getAllContacts = async () => {
        if (search === "") {
            alert("Not searching anything!")
        } else {
            if (database === "PostgreSQL") {
                if (radio === "firstname") {
                    if (search === "All") {
                        await SQLDataService.getAll.then((res)=> {
                            setSearchTerm(res.data)
                        })
                        await MongoDBDataService.createLogs({username: username, searchTerm: search, searchQuery: radio, database: database, createdAt: new Date().toLocaleString()}).then((res)=> {
                            throw res;
                        })
                    } else {
                        await SQLDataService.findByFirstName(search).then((res)=> {
                            setSearchTerm(res.data)
                        })
                        await MongoDBDataService.createLogs({id: 1, username: username, searchTerm: search, searchQuery: radio, database: database, createdAt: new Date().toLocaleString()}).then((res)=> {
                            throw res;
                        })
                    }
                }
                if (radio === "lastname") {
                    await SQLDataService.findByLastName(search).then((res)=> {
                        setSearchTerm(res.data)
                    })
                    await MongoDBDataService.createLogs({username: username, searchTerm: search, searchQuery: radio, database: database, createdAt: new Date().toLocaleString()}).then((res)=> {
                        throw res;
                    })
                }
                if (radio === "email") {
                    await SQLDataService.findByEmail(search).then((res)=> {
                        setSearchTerm(res.data)
                    })
                    await MongoDBDataService.createLogs({username: username, searchTerm: search, searchQuery: radio, database: database, createdAt: new Date().toLocaleString()}).then((res)=> {
                        throw res;
                    })
                }
                if (radio === "phone") {
                    await SQLDataService.findByPhoneNumber(search).then((res)=> {
                        setSearchTerm(res.data)
                    })
                    await MongoDBDataService.createLogs({username: username, searchTerm: search, searchQuery: radio, database: database, createdAt: new Date().toLocaleString()}).then((res)=> {
                        throw res;
                    })
                }
                if (radio === "company") {
                    await SQLDataService.findByCompany(search).then((res)=> {
                        setSearchTerm(res.data)
                    })
                    await MongoDBDataService.createLogs({username: username, searchTerm: search, searchQuery: radio, database: database, createdAt: new Date().toLocaleString()}).then((res)=> {
                        throw res;
                    })
                }
                if (radio === "department") {
                    await SQLDataService.findByDepartment(search).then((res)=> {
                        setSearchTerm(res.data)
                    })
                    await MongoDBDataService.createLogs({username: username, searchTerm: search, searchQuery: radio, database: database, createdAt: new Date().toLocaleString()}).then((res)=> {
                        throw res;
                    })
                }
                if (radio === "jobtitle") {
                    await SQLDataService.findByJobTitle(search).then((res)=> {
                        setSearchTerm(res.data)
                    })
                    await MongoDBDataService.createLogs({username: username, searchTerm: search, searchQuery: radio, database: database, createdAt: new Date().toLocaleString()}).then((res)=> {
                        throw res;
                    })

                }
            }
            if (database === "MongoDB") {
                if (radio === "firstname") {
                    if (search === "") {
                        await MongoDBDataService.getAll().then((res)=> {
                            setSearchTerm(res.data)
                        })
                        await MongoDBDataService.createLogs({username: username, searchTerm: search, searchQuery: radio, database: database, createdAt: new Date().toLocaleString()}).then((res)=> {
                            throw res;
                        })
                    } else {
                        await MongoDBDataService.findByFirstName(search).then((res)=> {
                            setSearchTerm(res.data)
                        })
                        await MongoDBDataService.createLogs({username: username, searchTerm: search, searchQuery: radio, database: database, createdAt: new Date().toLocaleString()}).then((res)=> {
                            throw res;
                        })
                    }
                }
                if (radio === "lastname") {
                    await MongoDBDataService.findByLastName(search).then((res)=> {
                        setSearchTerm(res.data)
                    })
                    await MongoDBDataService.createLogs({username: username, searchTerm: search, searchQuery: radio, database: database, createdAt: new Date().toLocaleString()}).then((res)=> {
                        throw res;
                    })
                }
                if (radio === "email") {
                    await MongoDBDataService.findByEmail(search).then((res)=> {
                        setSearchTerm(res.data)
                    })
                    await MongoDBDataService.createLogs({username: username, searchTerm: search, searchQuery: radio, database: database, createdAt: new Date().toLocaleString()}).then((res)=> {
                        throw res;
                    })
                }
                if (radio === "phone") {
                    await MongoDBDataService.findByPhoneNumber(search).then((res)=> {
                        setSearchTerm(res.data)
                    })
                    await MongoDBDataService.createLogs({username: username, searchTerm: search, searchQuery: radio, database: database, createdAt: new Date().toLocaleString()}).then((res)=> {
                        throw res;
                    })
                }
                if (radio === "company") {
                    await MongoDBDataService.findByCompany(search).then((res)=> {
                        setSearchTerm(res.data)
                    })
                    await MongoDBDataService.createLogs({username: username, searchTerm: search, searchQuery: radio, database: database, createdAt: new Date().toLocaleString()}).then((res)=> {
                        throw res;
                    })
                }
                if (radio === "department") {
                    await MongoDBDataService.findByDepartment(search).then((res)=> {
                        setSearchTerm(res.data)
                    })
                    await MongoDBDataService.createLogs({username: username, searchTerm: search, searchQuery: radio, database: database, createdAt: new Date().toLocaleString()}).then((res)=> {
                        throw res;
                    })
                }
                if (radio === "jobtitle") {
                    await MongoDBDataService.findByJobTitle(search).then((res)=> {
                        setSearchTerm(res.data)
                    })
                    await MongoDBDataService.createLogs({username: username, searchTerm: search, searchQuery: radio, database: database, createdAt: new Date().toLocaleString()}).then((res)=> {
                        throw res;
                    })
                }                
            }
            if (database === "Both") {
                if (radio === "firstname") {
                    if (search === "") {
                        await axios.all([MongoDBDataService.getAll(), SQLDataService.getAll(),
                        MongoDBDataService.createLogs({username: username, searchTerm: search, searchQuery: radio, database: database, createdAt: new Date().toLocaleString()})])
                        .then((axios.spread((data1, data2, data3) => {
                            // combines both array's
                            Array.prototype.push.apply(data1.data, data2.data);
                            setSearchTerm(data1.data)
                            throw data3
                        })))
                    } else {
                        await axios.all([MongoDBDataService.findByFirstName(search), SQLDataService.findByFirstName(search),
                            MongoDBDataService.createLogs({username: username, searchTerm: search, searchQuery: radio, database: database, createdAt: new Date().toLocaleString()})])
                            .then((axios.spread((data1, data2, data3) => {
                            // combines both array's
                            Array.prototype.push.apply(data1.data, data2);
                            setSearchTerm(data1.data)
                            throw data3
                            })))
                    }
                }
                if (radio === "lastname") {
                    await axios.all([MongoDBDataService.findByLastName(search), SQLDataService.findByLastName(search),
                        MongoDBDataService.createLogs({username: username, searchTerm: search, searchQuery: radio, database: database, createdAt: new Date().toLocaleString()})])
                        .then(axios.spread((data1, data2, data3) => {
                            // combines both array's
                            Array.prototype.push.apply(data1.data, data2.data);
                            setSearchTerm(data1.data)
                            throw data3
                        }))
                }
                if (radio === "email") {
                    await axios.all([MongoDBDataService.findByEmail(search), SQLDataService.findByEmail(search),
                        MongoDBDataService.createLogs({username: username, searchTerm: search, searchQuery: radio, database: database, createdAt: new Date().toLocaleString()})])
                        .then(axios.spread((data1, data2, data3) => {
                            // combines both array's
                            Array.prototype.push.apply(data1.data, data2.data);
                            setSearchTerm(data1.data)
                            throw data3
                        }))  
                }
                if (radio === "phone") {
                    await axios.all([MongoDBDataService.findByPhoneNumber(search), SQLDataService.findByPhoneNumber(search),
                        MongoDBDataService.createLogs({username: username, searchTerm: search, searchQuery: radio, database: database, createdAt: new Date().toLocaleString()})])
                        .then(axios.spread((data1, data2, data3) => {
                            // combines both array's
                            Array.prototype.push.apply(data1.data, data2.data);
                            setSearchTerm(data1.data)
                            throw data3
                        }))
                }
                if (radio === "company") {
                    await axios.all([MongoDBDataService.findByCompany(search), SQLDataService.findByCompany(search),
                        MongoDBDataService.createLogs({username: username, searchTerm: search, searchQuery: radio, database: database, createdAt: new Date().toLocaleString()})])
                        .then(axios.spread((data1, data2, data3) => {
                            // combines both array's
                            Array.prototype.push.apply(data1.data, data2.data);
                            setSearchTerm(data1.data)
                            throw data3
                        }))
                }
                if (radio === "department") {
                    await axios.all([MongoDBDataService.findByDepartment(search), SQLDataService.findByDepartment(search),
                        MongoDBDataService.createLogs({username: username, searchTerm: search, searchQuery: radio, database: database, createdAt: new Date().toLocaleString()})])
                        .then(axios.spread((data1, data2, data3) => {
                            // combines both array's
                            Array.prototype.push.apply(data1.data, data2.data);
                            setSearchTerm(data1.data)
                            throw data3
                        }))
                }
                if (radio === "jobtitle") {
                    await axios.all([MongoDBDataService.findByJobTitle(search), SQLDataService.findByJobTitle(search),
                        MongoDBDataService.createLogs({username: username, searchTerm: search, searchQuery: radio, database: database, createdAt: new Date().toLocaleString()})])
                        .then(axios.spread((data1, data2, data3) => {
                            // combines both array's
                            Array.prototype.push.apply(data1.data, data2.data);
                            setSearchTerm(data1.data)
                            throw data3
                        }))
                }
            }
            if (database === "Database") {
                            return (
                                alert("No Database Selected!")
                            )
                        }
        }
    }
    // set filter state
    const handleChange = (event) => {
        setRadio(event.target.value);
      };

      // open filter modal
      function openModal() {
        setOpen(true)
      }
    
      // close filter modal
      function closeModal() {
        setOpen(false)
      }
    
      // prevent default for form
      function handleSubmit(e) {
        e.preventDefault()
      }

    return (
        <>
        <NavBar/>
        <Container className="mt-5">
        {/**************************** CHOOSE DATABASE  ****************************/}
        <InputGroup className="mb-3">
            <DropdownButton
            variant={databaseColor}
            title={database}
            id="input-group-dropdown-1"
            >
            {/**************************** CHOOSE POSTGRESQL DATABASE  ****************************/}
            <Dropdown.Item href="#" onClick={() => {
                setDatabase("PostgreSQL")
                setDatabaseColor("outline-primary")
                }}>PostgreSQL</Dropdown.Item>
            {/**************************** CHOOSE MONGODB DATABASE  ****************************/}
            <Dropdown.Item href="#" onClick={() => {
                setDatabase("MongoDB")
                setDatabaseColor("outline-success") 
                }}>MongoDB</Dropdown.Item>
            {/**************************** CHOOSE BOTH DATABASES  ****************************/}
            <Dropdown.Item href="#" onClick={() => {
                setDatabase("Both")
                setDatabaseColor("outline-warning")
            }}>Both</Dropdown.Item>
            </DropdownButton>
            {/**************************** SEARCH INPUT  ****************************/}
            <FormControlBoot aria-label="Text input with dropdown button" placeholder="Search..." onChange={(e)=> setSearch(e.target.value)}/> 
            <Button onClick={getAllContacts} variant="contained" color="primary" disableElevation>Search</Button>
            {/**************************** FILTER MODAL BUTTON  ****************************/}
            <IconButton aria-label="filter" onClick={openModal}>
                <MoreVertIcon color="primary"/>
            </IconButton>
            </InputGroup>
            <>
            {/**************************** FILTER MODAL  ****************************/}
            <Modal show={open} onHide={closeModal}>
                <Form onSubmit={handleSubmit} >
                <Modal.Body>
                    {/**************************** CHOOSE FILTER ****************************/}
                        <FormControl component="fieldset"  >
                            <FormLabel component="legend">Filter By:</FormLabel>
                        <RadioGroup  aria-label="filter" name="filterby" value={radio} onChange={handleChange} >
                            <FormControlLabel  value="firstname" control={<Radio />} label="First Name" />
                            <FormControlLabel value="lastname" control={<Radio  />} label="Last Name" />
                            <FormControlLabel value="email" control={<Radio  />} label="Email" />
                            <FormControlLabel value="phone" control={<Radio  />} label="Phone" />
                            <FormControlLabel value="company" control={<Radio  />} label="Company"  />
                            <FormControlLabel value="department" control={<Radio  />} label="Department" />
                            <FormControlLabel value="jobtitle" control={<Radio  />} label="Job Title" />
                    </RadioGroup>
                 </FormControl>
                </Modal.Body>
                <Modal.Footer>
                {/**************************** APPLY FILTER  ****************************/}
                  <ButtonBoot variant="primary" type="submit" onClick={closeModal}>
                    Apply
                  </ButtonBoot>
                </Modal.Footer>
                </Form>
            </Modal>
          </>

        </Container>
        <Container>
            {/**************************** LIST CONTACTS  ****************************/}
            {
                searchTerm ? 
                <ListSearches searchTerm={searchTerm} /> : <p></p>
            }
        </Container>
        </>
    )
}

export default SearchPage
